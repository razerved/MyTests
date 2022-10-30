package qa.jsTest.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

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


    public void switchToNewWindow(){
        //String mainPage = wd.getWindowHandle();
            for (String tab : wd.getWindowHandles()){
                wd.switchTo().window(tab);
                //wd.switchTo().window(mainPage);
        }
        //return wd.getCurrentUrl();

    }

    /*public void returnMainWindow(){
        String mainPage = wd.getWindowHandle();
        for (String tab : wd.getWindowHandles()){
            wd.switchTo().window(tab).close();
            wd.switchTo().window(mainPage);
        }
    }*/

    public int switchTableAndGetCount(){
        String main = wd.getWindowHandle();
        Set<String> allWindow = wd.getWindowHandles();
        Set<String> other = allWindow.stream()
                .filter(x -> !x.equals(main)).collect(Collectors.toSet());
        wd.switchTo().window(other.stream().findFirst().get());
        wd.close();
        wd.switchTo().window(main);
        return other.size();
    }

    public void closeCorrentWindow(){
        wd.close();
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


    public void switchToIFrame(WebElement childWindow){
        wd.switchTo().frame(childWindow);
    }

    public void returnToIFrameParent(){
        wd.switchTo().defaultContent();
    }


    public void openTaxiSite(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/practice4/");
    }
    public void openNotesSite(){wd.get("http://qa.skillbox.ru/module15/bignotes/#/statistic");}
    public void openWebsiteCallRequests(){wd.get("http://qa.skillbox.ru/module11/practice/feedbacksingle/");}
    public void openWebinars(){wd.get("https://live.skillbox.ru/");}
    public void openIntersShop(){wd.get("http://intershop5.skillbox.ru/");}
    public void openDatebook(){wd.get("http://qa.skillbox.ru/module15/bignotes/#/");}
    public void openParrotPage(){wd.get("http://qajava.skillbox.ru/module5/homework/");}

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