package qa.jsTest.Pages;

import org.junit.jupiter.api.Assertions;
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


    public void openTaxiSite(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/practice4/");
    }
    public void openNotesSite(){wd.get("http://qa.skillbox.ru/module15/bignotes/#/statistic");}
    public void openWebsiteCallRequests(){wd.get("http://qa.skillbox.ru/module11/practice/feedbacksingle/");}

}
