package qa.jsTest;


import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import qa.jsTest.Pages.AppManagers;
import java.io.IOException;
import java.util.stream.Stream;

public class IFrameTest extends TestBase {
    AppManagers appNew = new AppManagers();


    @Test
    @DisplayName("Проверка кол-во активных страниц")
    public void test1() throws IOException {
        appNew.init_whit_no_LoadPage();
        appNew.getPp().openParrotPage();
        appNew.getPp().frameObject(appNew.getPp().frameForm);
        appNew.getPp().inputGirl.click();
        appNew.getPp().frameObject(appNew.getPp().frameFooter);
        appNew.getPp().linkSkillbox.click();
        int countTab = appNew.getPp().switchTableAndGetCount();
        Assert.assertEquals("URL сайта сходится",1, countTab);
        appNew.outForAppNew();
    }


    @Test
    @DisplayName("Проверка перехода по ссылк skillBox")
    public void test2() throws IOException {
        appNew.init_whit_no_LoadPage();
        appNew.getPp().openParrotPage();
        appNew.getPp().frameObject(appNew.getPp().frameForm);
        appNew.getPp().inputGirl.click();
        appNew.getPp().frameObject(appNew.getPp().frameFooter);
        appNew.getPp().linkSkillbox.click();
        appNew.getPp().switchToNewWindow();
        String actual = appNew.getPp().getCerrentURL_whitOutLoadPage();
        Assert.assertEquals("URL сайта SkillBox не сходится","https://skillbox.ru/", actual);
        appNew.outForAppNew();
    }


    @Test
    @DisplayName("Проверка отображения Header")
    public void test3(){
        app.getPp().openParrotPage();
        Assert.assertTrue("Хедер не отображается", app.getPp().headerPage.isDisplayed());
        app.getPp().choiseOppositeSex();
        app.getPp().inputEmail.sendKeys("tets@ter.ru");
        app.getPp().chooseName.click();
        Assert.assertTrue("Хедер не отображается", app.getPp().headerPage.isDisplayed());
    }


    private static Stream<Arguments> someEmail(){
        return Stream.of(Arguments.arguments("11111111")
        );
    }
    @ParameterizedTest
    @MethodSource(("someEmail"))
    @DisplayName("Проверка валидации поля email")
    public void test4(String email){
        app.getPp().openParrotPage();
        app.getPp().choiseOppositeSex();
        app.getPp().inputEmail.sendKeys(email);
        app.getPp().chooseName.click();
        Assert.assertTrue("Ошибка \"Некорректный email\" не выведена",app.getPp().errorText.isDisplayed());
    }

    @Test
    @DisplayName("Проверка отображения ошибки Введите email")
    public void test5(){
        app.getPp().openParrotPage();
        app.getPp().frameObject(app.getPp().frameForm);
        app.getPp().chooseName.click();
        String actualError = app.getPp().errorText.getText();
        Assert.assertEquals("Выведене не корректная ошибка","Введите email",actualError);
        app.getPp().frameObject(app.getPp().frameFooter);
        app.getPp().linkSkillbox.click();
        app.getPp().switchTableAndGetCount();
        Assert.assertEquals("Выведене не корректная ошибка","Введите email",actualError);
    }
    

}
