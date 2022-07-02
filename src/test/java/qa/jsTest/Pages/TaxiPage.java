package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.jsTest.TestBase;

public class TaxiPage extends HelperPage {
    //private WebDriver wd;

    public TaxiPage(WebDriver wd) {
        super(wd);
        //PageFactory.initElements(wd, this);
    }


    @FindBy(css = "")
    public WebElement dontNow;

    @FindBy(css = "")
    public WebElement dontCare;


    public By one = By.cssSelector("");
    public By two = By.xpath("");



    public void openTaxiPage(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/practice4/");
    }

    public void set(){


    }





}
