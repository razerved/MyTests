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
    @FindBy(css = "input[id='email']")
    public WebElement emailLocator;
    //public By emailLocator = By.cssSelector("input[id='email']");
    @FindBy(css = "input[id='password']")
    public WebElement passwordLocator;
    //public By passwordLocator = By.cssSelector("input[id='password']");


    @FindBy(css = "button.form-submit")
    public WebElement buttonRegistrationLocator;
    //public By buttonRegistrationLocator = By.cssSelector("button.form-submit");


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
        emailLocator.sendKeys("skillbox@test.ru");
        nameLocator.sendKeys("Иван");
        passwordLocator.sendKeys("qwerty!123");
        click(buttonRegistrationLocator);
    }


}
