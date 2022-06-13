package qa.booksStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BooksTestSelect extends TestBase {

    @Test
    @DisplayName("Проставление года")
    public void test1(){



        Assertions.assertAll(
                () -> Assertions.assertEquals("",""),
                ()-> Assertions.assertEquals("","")
        );
    }


    @Test
    @DisplayName("Сверка ФИО Авторов")
    public void test2(){

        Assertions.assertNotEquals("","");
    }


    @Test
    @DisplayName("")
    public void test3(){

        Assertions.assertEquals("","");
    }


}
