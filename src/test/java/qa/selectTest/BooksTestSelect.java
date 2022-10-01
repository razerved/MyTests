package qa.selectTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BooksTestSelect extends TestBase {

    @Test
    @DisplayName("Проставление года")
    public void test1(){
        List<String> firstInitYear = app.getMainPage().getAuthor();
        String expected = "2017";
        app.getMainPage().setYears(expected);

        Assertions.assertAll(
                ()-> Assertions.assertNotEquals(firstInitYear,
                        app.getMainPage().getYears(),"В момент открытия год не изменился"),
                ()-> Assertions.assertEquals(expected,
                        app.getMainPage().getYears(), "Год совпадает")
        );
    }


    @Test
    @DisplayName("Сверка ФИО Авторов")
    public void test2(){
        List<String> allAuthors = Arrays.asList("Рэнд А.","Те Нэм Джу","Уайт К.","Лабковский М.",
                "Disney","Хара Д.","Мэнсон М.","Синсеро Дж.","Янссон Т.","Руни С.","Оруэлл Дж.","Петросян М.",
                "Коэльо П.","Сапковский А.","Брэдбери Р.");
        Assertions.assertEquals(allAuthors,app.getMainPage().getAuthor(), "ФИО автооров различается");
    }


    @Test
    @DisplayName("Проверка фильтра по цене")
    public void test3(){
        app.getMainPage().setCostBook("350");
        app.getMainPage().clickShowFilter();
        String actualCost = app.getMainPage().getFirstBookCosts();

        Assertions.assertEquals("350 р.",actualCost, "Фильтр не выдал первой книгой указанную цену");
    }


}
