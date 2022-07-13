package qa.jsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsExperimentsTest extends TestBase {

    @Test
    @DisplayName("simpleTestJs")
    public void test1(){
        //arrange
    app.getTx().openTaxiPage();
    String now =  app.getTx().getDate();
        //act
    app.getTx().setDate("01/02/2022");
    app.getTx().setTime("01:30");
    app.getTx().submit.click();
        //assert
        Assertions.assertNotEquals("11/02/06", now, "Дата не проставилась осталась null");
    }



    @Test
    @DisplayName("simpleTestJs2")
    public void test2(){



    }










}
