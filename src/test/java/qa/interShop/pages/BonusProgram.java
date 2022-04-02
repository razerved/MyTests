package qa.interShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BonusProgram {
    private WebDriver driver;

    public BonusProgram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String urlBonus = "http://intershop6.skillbox.ru/bonus/";

    public String bonusTestName = "Ivan";
    public String bonusTestPhone = "89111111111";
    public String bonusTestName2 = "Вася";
    public String bonusTestPhone2 = "+79111111111";

    public String textForClient = "Ваша карта оформлена!\n" +
            "\n" +
            "Для применения скидки укажите номер телефона владельца карты в комментариях к заказ";


    @FindBy(css = "#bonus_username")
    public WebElement enterTextBonusProgramLocator;
    //public By enterTextBonusProgramLocator = By.cssSelector("#bonus_username");

    @FindBy(css = "#bonus_phone")
    public WebElement enterPhoneBonusProgramLocator;
    //public By enterPhoneBonusProgramLocator = By.cssSelector("#bonus_phone");

    @FindBy(css = "button.woocommerce-form-register__submit")
    public WebElement buttonCreateCardBonusProgramLocator;
    //public By buttonCreateCardBonusProgramLocator = By.cssSelector("button.woocommerce-form-register__submit");

    @FindBy(xpath = "//div[contains(text(), 'Поле')]")
    public WebElement errorText;

    @FindBy(xpath = "//div[@id='bonus_main']/br/following-sibling::*")
    public WebElement textCardIsIssued;

    @FindBy(xpath = "//div[contains(text(), 'обязательно')]")
    public WebElement textRequiredField;


    //SpecificPageMethod================================================================================================
    public void cardRegistrationMethod(String page1, String page2) {
        enterTextBonusProgramLocator.sendKeys(page1);
        enterPhoneBonusProgramLocator.sendKeys(page2);
        buttonCreateCardBonusProgramLocator.click();
    }

}
