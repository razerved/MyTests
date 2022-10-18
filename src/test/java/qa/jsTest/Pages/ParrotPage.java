package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParrotPage extends HelperPage {

    public ParrotPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    @FindBy(css = "p.title")
    public WebElement titelPage;

    @FindBy(css = ".header")
    public WebElement headerPage;

    @FindBy(css = "[name='email']")
    public WebElement inputEmail;

    @FindBy(css = "#girl")
    public WebElement inputGirl;

    @FindBy(css = "#boy")
    public WebElement inputBoy;

    @FindBy(css = "#sendMe")
    public WebElement chooseName;

    @FindBy(css = ".footer__contacts > a[href*='skillbox.ru']")
    public WebElement linkSkillbox;

    @FindBy(css = ".footer__contacts > a[href*='mailto:info@test.com']")
    public WebElement linkInfo;

    @FindBy(css = "[src^='./form.html']")
    public WebElement frameForm;

    @FindBy(css = "[src^='./footer.html']")
    public WebElement frameFooter;

    @FindBy(css = ".form-error")
    public WebElement errorText;

    public void frameUp(){
        wd.switchTo().parentFrame();
    }
    public void switchToMainPage(){
        wd.switchTo().defaultContent();
    }
    public void switchFrameForm(){
        wd.switchTo().frame(frameForm);
    }
    public void switchFrameFooter(){
        switchFrameForm();
        wd.switchTo().frame(frameFooter);
    }

    public void frameObject(WebElement element){
        wd.switchTo().frame(element);
    }

    public void fram(){
        jS.executeScript("");
    }

    public String getCerrentURL_whitOutLoadPage(){
        ChromeOptions op = new ChromeOptions();
        op.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return wd.getCurrentUrl();
    }

    public void choisingSex() {
        if (wd.findElement(By.cssSelector("input[checked][id='boy']")).isDisplayed()) {
            inputGirl.click();
        } else if ((wd.findElement(By.cssSelector("input[checked='checked'][id='boy']")).isDisplayed())) {
            inputGirl.click();
        } else if (wd.findElement(By.cssSelector("input[checked][id='girl']")).isDisplayed()) {
            inputBoy.click();
        } else if ((wd.findElement(By.cssSelector("input[checked='checked'][id='girl']")).isDisplayed())) {
            inputBoy.click();
        }
    }

    public void choiseOppositeSex() {
        switchToIFrame(frameForm);
        choisingSex();
    }


    //ToDo: Работа с IFrame окнами

}
