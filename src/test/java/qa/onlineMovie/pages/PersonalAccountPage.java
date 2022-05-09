package qa.onlineMovie.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListener;

public class PersonalAccountPage extends Page {
    //private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Field=============================================================================================================
    public String urlPersonAccount = "https://lm.skillbox.cc/qa_tester/module06/personal/index.html";

    @FindBy(xpath = "//main[@id='yes_auth']//h1")
    public WebElement titlePersonAcLocator;

    public By myFilmTextLocator = By.cssSelector(".films-title");

    @FindBy(css = ".user-avatar")
    public WebElement userAvatarPersonAcLocator;

    @FindBy(css = "span.username")
    public WebElement userNamePersonAcLocator;

    @FindBy(css = "p.user-email")
    public WebElement userEmailPersonAcLocator;

    @FindBy(css = "button.logout")
    public WebElement buttonLogAutPersonAcLocator;





}
