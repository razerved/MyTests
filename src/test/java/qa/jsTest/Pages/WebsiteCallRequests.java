package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebsiteCallRequests extends HelperPage {


    public WebsiteCallRequests(WebDriver wd) {
        super(wd);
    }


    public By cls = By.cssSelector(""); // чисто-так

    public String someClassCss = "";    // чисто-так

    /**
     * Блок Установки Вермени
     */
    //------------------------------------------------------------------------------------------------------------------
    @FindBy(css = ".baseButton")
    public WebElement buttonCallMe;

    @FindBy(xpath = "//select[@name='from']")
    public WebElement timeFrom;

    /*@FindBy(xpath = "//div[@class='timePicker__to']//div[@class='baseSelect__header baseSelect__header--changed']/span")
    public WebElement defaultTimeTo;*/

    @FindBy(xpath = "//select[@name ='to']")
    public WebElement timeTo;


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



    /**
     * Блок ввода номера телефона
     */
    //------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement fieldPhone;




    //------------------------------------------------------------------------------------------------------------------












    public void selectDate(String date){

    }

    public String getDate(){
        return "";
    }







}
