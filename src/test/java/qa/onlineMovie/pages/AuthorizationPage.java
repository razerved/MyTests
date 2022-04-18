package qa.onlineMovie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends Page {

    private WebDriver driver;


    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String urlAuth = "https://lm.skillbox.cc/qa_tester/module06/auth/index.html";


    public void auth() {

    }

    //Field=============================================================================================================

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    public WebElement buttonRegistrationLocator;
    //public By buttonRegistrationLocator = By.xpath("/button[.='Войти']");

    @FindBy(css = "a.forgot-password")
    public WebElement forgotPasswordLink;



    //ModalWindowLocator================================================================================================
    @FindBy(css = "#forgot-password-popup")
    public WebElement modalWindowRestorePasswordLocator;

    @FindBy(css = "#forgot-email")
    public WebElement modalWindowEmailLocatorRestorePasswordLocator;

    @FindBy(xpath = "//button[.='Восстановить пароль']")
    public WebElement modalWindowButtonRestorePasswordLocator;

    @FindBy(css = "span.popup-close")
    public WebElement closeModalWindowRestorePasswordLocator;


    //Method============================================================================================================


}

