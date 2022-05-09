package qa.onlineMovie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Page {
    //private WebDriver driver;
    //private Page newPage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //newPage = new Page(driver);
        PageFactory.initElements(driver, this);
    }



    public String urlRegister = "https://lm.skillbox.cc/qa_tester/module06/register/";

    @FindBy(css = "h1.main-title")
    public WebElement titleLocator;

    //Field=============================================================================================================
    @FindBy(css = "input[id='name']")
    public WebElement nameLocator;
    //public By nameLocator = By.cssSelector("input[id='name']");

    @FindBy(xpath = "//button[contains(text(), 'Зарегистрироваться')]")
    public WebElement buttonRegistrationLocator;
    //public By buttonRegistrationLocator = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");

    @FindBy(css = "h3.form-title.result")
    public WebElement textYouRegistration;

    @FindBy(css = "a.result-email")
    public WebElement emailAfterRegistration;

    @FindBy(css = "div[class*='container']")
    public WebElement notificationMail;

    //ModalWindowLocator================================================================================================
    @FindBy(css = "div.popup")
    public WebElement modalWindow;

    @FindBy(css = "a.user-data.user__login")
    public WebElement modalLoginField;
    @FindBy(css = "span.user__password")
    public WebElement modalPasswordField;
    @FindBy(css = "a.popup-close")
    public WebElement closeModalWindow;
    @FindBy(xpath = "//a[contains(text(),'по ссылке')]")
    public WebElement modalLinkForAuth;
    ////a[contains(text(),'по ссылке')]
    //Method============================================================================================================

    public void registration() {
        emailLocator.sendKeys(userEmail);
        nameLocator.sendKeys(userName);
        passwordLocator.sendKeys(userPassword);
        click(buttonRegistrationLocator);
    }

    public void registration(String email, String name, String password) {
        emailLocator.sendKeys(email);
        nameLocator.sendKeys(name);
        passwordLocator.sendKeys(password);
        click(buttonRegistrationLocator);
    }

    public void randomRegistration(){
        emailLocator.sendKeys(randomEmail());
        nameLocator.sendKeys(randomName());
        passwordLocator.sendKeys(randomPassword());
        click(buttonRegistrationLocator);
    }





}
