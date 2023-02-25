package qa.onlineMovie.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

public class Page {
    WebDriver driver;

    WebDriverWait wait;
    public RegistrationPage rp;
    public AuthorizationPage ap;
    public PersonalAccountPage pa;

    public Page(WebDriver driver) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //InitializationOptions=============================================================================================
    public void init() {
        /*String Browser = BrowserType.CHROME;
        if (Browser equals(ChromeDriver)){
            driver = new ChromeDriver();
        }else if (Browser equals(EdgeDriver)){
            driver = new EdgeDriver();
        }else if (Browser equals(FirefoxDriver)){
            driver = new FirefoxDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //driver.manage().window().setSize(new Dimension(1920,1080));

        rp = new RegistrationPage(driver);
        ap = new AuthorizationPage(driver);
        pa = new PersonalAccountPage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return rp;
    }

    public AuthorizationPage getAuthorizationPage() {
        return ap;
    }

    public PersonalAccountPage getPersonalAccountPage() {
        return pa;
    }

    public void stop() throws IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        driver.quit();
    }


    //CommonData========================================================================================================
    public String userName = "Иван";
    public String userEmail = "skillbox@test.ru";
    public String userPassword = "qwerty!123";


    //CommonLocators====================================================================================================

    @FindBy(css = "#email")
    public WebElement emailLocator;
    //public By emailLocator = By.cssSelector("#email");

    @FindBy(css = "input[id='password']")
    public WebElement passwordLocator;
    //public By passwordLocator = By.cssSelector("#password");

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    public WebElement enterButtonLocator;


    //CommonMethods=====================================================================================================
    public void open(String url) {
        driver.get(url);
    }


    //Another(Helper)Methods============================================================================================
    public String randomName() {
        return randomText();
    }

    public String randomEmail() {
        return randomText() + "@" + randomText() + ".com";
    }

    public String randomPassword() {
        int i = (int) (Math.random() * (10 - 1) + 1);
        return randomText() + i + "" + i;
    }

    public String randomText() {
        Random rnd = new Random();
        char[] some = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'k', 'l', 'm', 'n', 'o'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char newChar = (char) rnd.nextInt(14);
            stringBuilder.append(some[newChar]);
        }
        return stringBuilder.toString();
    }

    public void click(WebElement locator) {
        locator.click();
    }

    public void click(By cssSelector) {
        driver.findElement(cssSelector).click();
    }

    //Явное ожидание элемента (кастомный)
    public void waitForDisplayed(By element) {
        var newWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        newWait.until(driver -> driver.findElement(element).isDisplayed());
    }

    //Увеличеное ожидание, c откатом ожидания до нормы 5 сек (кастомный)
    public boolean isSuccessDisplayed() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return true;//как вариант запихнуть ожидание элемента.isDisplayed
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    //SpecificMethods===================================================================================================
    public void toGotoModalWindowForgotPass() {
        getRegistrationPage().notificationMail.click();
        getRegistrationPage().modalLinkForAuth.click();
        getAuthorizationPage().forgotPasswordLink.click();
    }

    public void fillForgotPasswordForm(String mail) {
        getAuthorizationPage().modalWindowEmailLocatorRestorePasswordLocator
                .sendKeys(mail);
        getAuthorizationPage().modalWindowButtonRestorePasswordLocator.click();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public String getTextAttribute(By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public boolean elementPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }


}
