package qa.onlineMovie.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends Page {

    //private WebDriver driver;


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



    //ModalWindowLocatorRestorePassword=================================================================================
    @FindBy(css = "#forgot-password-popup")
    public WebElement modalWindowRestorePasswordLocator;

    @FindBy(css = "#forgot-email")
    public WebElement modalWindowEmailLocatorRestorePasswordLocator;

    @FindBy(xpath = "//button[.='Восстановить пароль']")
    public WebElement modalWindowButtonRestorePasswordLocator;

    @FindBy(css = "span.popup-close")
    public WebElement closeModalWindowRestorePasswordLocator;


    @FindBy(css = ".mail__message")
    public WebElement restoreInfoMail;
    //public By restoreMail = By.cssSelector(".mail__message");
    @FindBy(css = "a.user-data.user__login")
    public WebElement userInfoEmailRestoreLocator;
    @FindBy(css = ".user__password")
    public WebElement userInfoPasswordRestoreLocator;
    @FindBy(css = "span.user-data.user__password")
    public WebElement newRestoreUserPasswordLocator;

    @FindBy(css = "a.popup-close")
    public WebElement closeInfoModalWindowRestoreLocator;
        //errorLocator==================================================================================================

    @FindBy(xpath = "//form[@id='forgot-password-form']/p[contains(text(),'email не зарегистрирован')]")
    public WebElement errorEmailNotRegistered;

    @FindBy(xpath = "//p[contains(text(),'Введите email')]")
    public WebElement errorEnterEmail;

    /*@FindBy(xpath = "//p[contains(text(),'Пароль не относится к почте')]")
    public WebElement errorEmailDoestApplyMail;*/

    public By errorEmailDoestApplyMail = By.xpath("//p[contains(text(),'Пароль не относится к почте')]");

    //Method============================================================================================================

    public void authorizationMethod() {
        emailLocator.sendKeys(userEmail);
        passwordLocator.sendKeys(userPassword);
        enterButtonLocator.click();
    }

    public void authorizationMethod(String newPassword) {
        emailLocator.sendKeys(userEmail);
        passwordLocator.sendKeys(newPassword);
        enterButtonLocator.click();
    }





}

