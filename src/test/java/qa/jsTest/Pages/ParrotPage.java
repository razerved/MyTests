package qa.jsTest.Pages;

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

    public void frameUp(){
        wd.switchTo().parentFrame();
    }
    public void switchToMainPage(){
        wd.switchTo().defaultContent();
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



    //ToDo: Работа с IFrame окнами

}
