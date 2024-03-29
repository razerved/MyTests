package qa.jsTest.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebsiteCallRequests extends HelperPage {

    public WebsiteCallRequests(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    /**
     * Блок Установки Вермени
     */
    //------------------------------------------------------------------------------------------------------------------
    @FindBy(css = ".baseButton")
    public WebElement buttonCallMe;

    @FindBy(xpath = "//select[@name='from']")
    public WebElement timeFrom;

    @FindBy(css = ".timePicker__message span")
    public WebElement errMessage;

    @FindBy(xpath = "//select[@name ='to']")
    public WebElement timeTo;

    @FindBy(css = ".firstModul__col:nth-of-type(2) .h2")
    public WebElement resultDate;

    @FindBy(css = ".firstModul__col:nth-of-type(1) .h2")
    public WebElement resultTimePeriod;


    public String getErrMessage(){
        return errMessage.getText();
    }

    public void selectTimeFrom(String value){
        jS.executeScript("document." +
                "getElementsByName('from')[0].style = 'display:block;'");//делаем видимым в дом дереве
        Select sl = new Select(timeFrom);
        sl.selectByValue(value);
    }

    public String getTimeFrom(){
        jS.executeScript("document." +
                "getElementsByName('to')[0].style = 'display:block;'");
        Select sl = new Select(timeFrom);
        return sl.getFirstSelectedOption().getText();
    }

    public void selectTimeTo(String value){
        jS.executeScript("document." +
                "getElementsByName('to')[0].style = 'display:block;'");
        Select sl = new Select(timeTo);
        sl.selectByValue(value);
    }

    public String getTimeTo(){
        jS.executeScript("document." +
                "getElementsByName('to')[0].style = 'display:block;'");
        Select sl = new Select(timeTo);
        return sl.getFirstSelectedOption().getText();
        //return defaultTimeTo.getText();
    }

    public String getResultDate(){
         wait.until(x ->!resultDate.getText().isEmpty());
         return resultDate.getText();
    }

    public String getResultPeriod(){
        wait.until(x ->!resultTimePeriod.getText().isEmpty());
        return resultTimePeriod.getText();
    }

    /**
     * Блок ввода Номера телефона
     */
    //------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement fieldPhone;

    public void setFieldPhone(String phone){
        fieldPhone.sendKeys(phone);
    }
    public String getFieldPhone(){
        return fieldPhone.getText();
    }

    /**
     * Блок Календаря
     */
    //------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//div[@class='datepicker__calendar vdp-datepicker__calendar']/div")
    public WebElement calendar;

    @FindBy(xpath = "//div/span[@class='cell day' or @class='cell day today']")
    public List<WebElement> days; //не продуктивный вариант Не Юзать

    public String CssDateCalendar = ".vdp-datepicker.datepicker__main";
    /*@FindBy(css = "input[name='datepicker']") NOT WORKING
    public WebElement currentDate;*/
    /*public String getCurrentDateCalendar(){  NOT WORKING
        return currentDate.getText();
    }*/

    public void setDay(int i){ //не продуктивный вариант Не Юзать
        days.get(i).click();
    }


    public String getCurrentCalendarDate(){
        return String.valueOf(jS.executeScript
                ("return document." +
                        "getElementsByClassName('datepicker__main')[0].__vue__.selectedDate", CssDateCalendar));
    }

    public void openCalendar(){
        jS.executeScript("document." +
                "getElementsByClassName('datepicker__field').datepicker.click();");
    }

    public void setCalendarDate(String data){
        jS.executeScript(String.format("document." +
                "getElementsByClassName('datepicker__main')[0].__vue__.setDate('%s');", data));
    }

    /**
     * Блок Кнопок
     */
    //------------------------------------------------------------------------------------------------------------------





}
