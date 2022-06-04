package qa.onlineInstitute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.onlineInstitute.page.Courses;

import java.util.stream.Stream;

public class FirstTest extends TestBase {

    @Test
    @DisplayName("тест добавления курса + проверка добавленый курс в Main = курсу в личном кабинете ")
    public void Test() {
        app.getGroupHelper().gotToCoursesCatalog();
        Courses first = app.getGroupHelper().getCourses(0);
        Courses second = app.getGroupHelper().getCourses(1);

        String expFirstText = first.getTitleCourses();
        String expSecondText = second.getTitleCourses();

        first.add();
        second.add();

        app.getPersonalCourses().goToPersonalAccount();
        app.getPersonalCourses().goToDeferredCourses();

        app.wait.until(wd -> !app.getPersonalCourses()
                .countAddCourse.get(1).getText().equals(""));
        String actFirstCourses = app.getGroupHelper().
                getPersonalCoursesCard(1).getPersonalTitleCourses();
        String actSecondCourses = app.getGroupHelper().
                getPersonalCoursesCard(2).getPersonalTitleCourses();

        Assertions.assertAll(
                () -> Assertions.assertEquals(2,
                        app.getPersonalCourses().countAddCourse.size(),"Количество добавленых в отложенное курсов не совпадает"),
                () -> Assertions.assertEquals(expFirstText,actFirstCourses,
                        "Заголовки первых курсов не сходится"),
                () -> Assertions.assertEquals(expSecondText,actSecondCourses,
                        "Заголовки вторых курсов не сходится"),
                () -> Assertions.assertFalse(actFirstCourses.equals(actSecondCourses),"Добавлены одинаковые курсы")
        );
    }



    @Test
    @DisplayName("Удаление курса из отложенного, кнопка не работает")
    public void test2(){
        app.getPersonalCourses().gotToCoursesCatalog();
        Courses first = app.getGroupHelper().getCourses(3);
        String titleCourses = first.getTitleCourses();
        String durationCourses = first.getMonthsCourses();

        first.add();

        app.getPersonalCourses().goToPersonalAccount();
        app.getPersonalCourses().goToDeferredCourses();

        app.wait.until(wd -> !app.getPersonalCourses()
                .countAddCourse.get(0).getText().equals(""));

        String actTitleCourses = app.getGroupHelper().
                getPersonalCoursesCard(1).getPersonalTitleCourses();
        String actDurationCourses = app.getGroupHelper().
                getPersonalCoursesCard(1).getPersonalMonthsCourses();

        Assertions.assertAll(
                () -> Assertions.assertEquals(titleCourses, actTitleCourses,
                        "Заголовки не совпадают"),
                () -> Assertions.assertEquals(durationCourses, actDurationCourses,
                        "кол-во месяцев различается")
        );
        /*app.getGroupHelper().getPersonalCoursesCard(1).refuseCourses.click();
        Assertions.assertEquals(app.getPersonalCourses()
                .countAddCourse.get(0).getText().equals(""),"","Курс не удален");*/

    }

    @Test
    @DisplayName("Оплата курсов, оплата не работает")
    public void test3(){
        app.getPersonalCourses().gotToCoursesCatalog();
        Courses first = app.getGroupHelper().getCourses(3);

        first.add();
        app.getPersonalCourses().goToPersonalAccount();
        app.getPersonalCourses().goToDeferredCourses();
        app.wait.until(wd -> !app.getPersonalCourses()
                .countAddCourse.get(0).getText().equals(""));
        app.getPersonalCourses().payForCourses();

        try {
            app.getPaymentPage().setNumberCard("1111222233334444");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            app.getPaymentPage().setCVCCode("132");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            app.getPaymentPage().setCardDate("0123");
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }




    private static Stream<Arguments> parametrsTest(){
        return Stream.of(
                Arguments.arguments("admin", "qwerty123"),
                Arguments.arguments("admin", "admin")
        );
    }
    @DisplayName("Параметризированный")
    @ParameterizedTest
    @MethodSource("parametrsTest")
    public void test4(String name, String password){
        app.getGroupHelper().exitLogin();
        app.getGroupHelper().login(name, password, "http://qa.skillbox.ru/module16/autorization1");
        String wrongName = name;
        String wrongPassword = password;
        Assertions.assertTrue(app.getGroupHelper().errorPass.getText().equals("Введен неверный пароль"),"Другой формат/текст ошибки");
    }


}
