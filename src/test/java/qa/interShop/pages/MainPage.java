package qa.interShop.pages;

import org.junit.jupiter.api.MethodOrderer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    public HeaderPanel hp;
    public BasketPage bp;
    public ProductCatalogPage pc;
    public BonusProgram bonus;


    public MainPage(WebDriver driver) {
       //super(driver);
        this.driver = driver;
        hp = new HeaderPanel(driver);
        bp = new BasketPage(driver);
        pc = new ProductCatalogPage(driver);
        bonus = new BonusProgram(driver);
    }

    public String urlMain = "http://intershop6.skillbox.ru/";
    public String urlRegister = "http://intershop6.skillbox.ru/register/";
    public String urlAuthoriz = "http://intershop6.skillbox.ru/my-account/";
    public String urlBasket = "http://intershop6.skillbox.ru/cart/";
    public String urlCatalog = "http://intershop6.skillbox.ru/product-category/catalog/";
    public String urlOrderProcessing = "http://intershop6.skillbox.ru/checkout/";
    public String urlCheckout = "http://intershop6.skillbox.ru/checkout/";
    //http://google.com


    //UserDate==========================================================================================================
    public String testUserEmail = "TsetTset@rb.com";
    public String testUserPassword = "Retro123";



    //SectionCollection=================================================================================================
    public By logoTitleLocator = By.cssSelector("#site-branding a.site-logo");
    public By sectionSaleLocator = By.cssSelector("aside#accesspress_store_product-2");
    public By sectionNewCollectionLocator = By.cssSelector("aside#accesspress_store_product-3");
    public By contactsInfoLocator = By.cssSelector("div.cta-desc_simple");



    //logIn=============================================================================================================
    public By enterLocator = By.cssSelector(".login-woocommerce a");
    public By logInNameLocator = By.cssSelector("#username");
    public By logInPassLocator = By.cssSelector("#password");
    public By hiUserNameLocator = By.xpath("//span[@class='user-name']");



    //Authorization=====================================================================================================
    public By authorizationLocator = By.cssSelector(".custom-register-button");
    public By enterButtonLocator = By.cssSelector(".woocommerce-form-login__submit");
    public By registrationUserNameLocator = By.cssSelector("#reg_username");
    public By registrationMailAddressLocator = By.cssSelector("#reg_email");
    public By registrationPasswordLocator = By.cssSelector("#reg_password");
    public By registrationButtonLocator = By.cssSelector("button[name='register']");
    public By registrationPassTextLocator = By.xpath("//div[text()='Регистрация завершена']");



    //Methods===========================================================================================================
    public void findContactsMainPage() {
        try{
            Thread.sleep(2000);
            driver.findElement(contactsInfoLocator).isDisplayed();
        }catch (Exception e){
            System.out.println("[Error]: couldn't find locator");
        }
    }


    public String randomGuid(){
        return randomText() + '@' + randomText() + ".com";
    }

    public String randomFIO(){
        return randomText() + " " + randomText() + " " + randomText();
    }


    public String randomText(){
        Random rnd = new Random();
        char[] pwdChars = {'a','b','c','d','e','f','g','n','i','j','k','l'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            char n = (char) rnd.nextInt(12);
            sb.append(pwdChars[n]);
        }
        return sb.toString();
    }



    public Boolean isElementsDisplayed(WebElement elementDisplayed){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         return elementDisplayed.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public Boolean isElementsNotDisplayed(WebElement elementDisplayed){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            return elementDisplayed.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }




    public void randomRegistrationMethod() {
        driver.findElement(logoTitleLocator).isDisplayed();
        driver.findElement(enterLocator).click();
        driver.findElement(authorizationLocator).click();
        driver.findElement(registrationUserNameLocator).sendKeys(randomText());
    }
   /* public MainPage clickButton(By button){
        driver.findElement(button).click();
        return new MainPage(driver);
    }*/


}
