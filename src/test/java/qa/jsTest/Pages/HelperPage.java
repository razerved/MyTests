package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperPage {

    protected WebDriver wd;
    public JavascriptExecutor jS;
    protected WebDriverWait wait;

    public HelperPage(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
        PageFactory.initElements(wd, this);
        jS = (JavascriptExecutor)wd;
    }
    //public HelperPage(WebDriver wd){}
    public HelperPage(){}

    public String getCurrentURL(){
        return wd.getCurrentUrl();
    }

    public void switchToTabs(){
        wd.switchTo().window(wd.getWindowHandle());
    }
    public String containsText(String value){
        return wd.findElement(By.cssSelector(value)).getText();
    }

    public void clik (WebElement elem){
        elem.click();
    }

    public void waitForDisplayed(By element) {
        var newWait = new WebDriverWait(wd, Duration.ofSeconds(7));
        newWait.until(driver -> driver.findElement(element).isDisplayed());
    }


    public void openTaxiSite(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/practice4/");
    }
    public void openNotesSite(){wd.get("http://qa.skillbox.ru/module15/bignotes/#/statistic");}
    public void openWebsiteCallRequests(){wd.get("http://qa.skillbox.ru/module11/practice/feedbacksingle/");}
    public void openWebinars(){wd.get("https://live.skillbox.ru/");}

}



/*try {

        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
        String act = driver.getCurrentUrl();
        }
        }catch(Exception e){
        System.out.println("fail");
        }*/