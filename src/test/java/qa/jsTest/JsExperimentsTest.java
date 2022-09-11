package qa.jsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class JsExperimentsTest extends TestBase {

    @Test
    @DisplayName("simpleTestJs_Taxi")
    public void test1() {
            //arrange
        app.getTx().openTaxiSite();
        String now = app.getTx().getDate();
            //act
        app.getTx().setDate("01/02/2022");
        app.getTx().setTime("01:30");
        app.getTx().submit.click();
            //assert
        Assertions.assertNotEquals("11/02/06", now, "Дата не проставилась осталась null");
    }


    @Test
    @DisplayName("simpleTestJs2_Notes")
    public void test2() {
            //arrange
        app.getNp().openNotesSite();
            //act
        String currentDate = app.getNp().getCSSCalendar();
            //app.getNp().setCSSCalendar("07/07/2022");
            //String newDate = app.getNp().getCSSCalendar();
            //assert
        Assertions.assertNotEquals("newDate", currentDate, "Дата изменилась");

    }


    private static Stream<Arguments> timeArguments(){
        return Stream.of(
                Arguments.arguments("12:00","16:00"),
                Arguments.arguments("13:00","18:00")
        );
    }
    @ParameterizedTest
    @MethodSource("timeArguments")
    @DisplayName("Select_Parametrized_WebsiteCallRequests_setTime_test")
    public void test3(String timeFrom, String timeTo) {
            //arrange
        app.getWcr().openWebsiteCallRequests();
            //act
        //String byDefaultTimeTo = app.getWcr().getTimeTo();
        /*String timeFrom = "12:00";
        String timeTo = "16:00";*/
        app.getWcr().selectTimeFrom(timeFrom);
        app.getWcr().selectTimeTo(timeTo);
        String byTimeFrom = app.getWcr().getTimeFrom();
        String byTimeTo = app.getWcr().getTimeTo();
            //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(timeFrom, byTimeFrom, "Error From/time not Equals"),
                () -> Assertions.assertEquals(timeTo, byTimeTo, "Error To/time not Equals")
        );
    }




    private static Stream<Arguments> NumberCall(){
        return Stream.of(
                Arguments.arguments("9778007071","4958451221")
        );
    }
    @ParameterizedTest
    @MethodSource("NumberCall")
    @DisplayName("3.5 Заявки на обратный звонок, WebsiteCallRequests_setPhoneNumber")
    public void test4(String firstNumber, String secondNumber){
        //arrange
    app.getWcr().openWebsiteCallRequests();
        //act
    app.getWcr().setFieldPhone(firstNumber);
    String exp = app.getWcr().getFieldPhone();
    app.getWcr().setFieldPhone(secondNumber);
    String exp2 = app.getWcr().getFieldPhone();
        //assert
    Assertions.assertAll(
            ()-> Assertions.assertEquals(firstNumber,exp,"1-ый номер не сходится"),
            ()-> Assertions.assertEquals(secondNumber,exp2,"2-ой номер не сходится")
        );
    }

    @Test
    @DisplayName("3.5 Заявки на обратный звонок")
    public void ret(){
        app.getWcr().openWebsiteCallRequests();
        //app.getWcr().openCalendar();
        /*List<String> day = app.getWcr().getDays();
        day.get(2);*/
        //app.getWcr().getDays("4");
        //app.getWcr().setDay(2);
        app.getWcr().setCalendarDate("09/11/2022");
        int i = 0;
    }









}
