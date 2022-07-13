package qa.jsTest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HelperPage {

    protected WebDriver wd;
    public JavascriptExecutor jS;

    public HelperPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
        jS = (JavascriptExecutor)wd;
    }


    public void clik (WebElement elem){
        elem.click();
    }


    public void openTaxiPage(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/practice4/");
    }


}
