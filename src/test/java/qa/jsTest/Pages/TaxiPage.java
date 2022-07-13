package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaxiPage extends HelperPage {
    //private WebDriver wd;

    public TaxiPage(WebDriver wd) {
        super(wd);
        //PageFactory.initElements(wd, this);
    }


    /*@FindBy(css = "#date")
    public WebElement setADate;
    public By one = By.cssSelector("#date");
    public By two = By.xpath("");*/

    @FindBy(css = "[name='time']")
    public WebElement setATime;

    @FindBy(css = ".form-submit")
    public WebElement submit;

    public String cssDate = "#date";


    public void setDate(String date){
        jS.executeScript(String.format
                ("$(\"%s\").datepicker(\"setDate\", \"%s\")", cssDate, date));
    }

    public String getDate(){
        return String.valueOf(jS.executeScript
                (String.format
                        ("return $(\"%s\").datepicker(\"getDate\")", cssDate)));
    }


    public void setTime(String setTime){
    setATime.sendKeys(setTime);
    }





}
