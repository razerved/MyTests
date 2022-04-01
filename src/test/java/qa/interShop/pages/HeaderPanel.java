package qa.interShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPanel {
    private WebDriver driver;

    public HeaderPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //NavigationPanel===================================================================================================
    @FindBy(xpath = "//a[text()='Главная']/parent::li[@id]")
    public WebElement navigationMainPanelLocator;

    //public By navigationMainPanelLocator = By.xpath("//a[text()='Главная']/parent::li[@id]");
    public By navigationCatalogPanelLocator = By.xpath("//a[text()='Каталог']");
    public By navigationMyAccPanelLocator = By.xpath("//a[text()='Мой аккаунт']/parent::li[@id]");
    public By navigationBasketPanelLocator = By.xpath("//a[text()='Корзина']/parent::li[@id]");
    public By navigationOrderPanelLocator = By.xpath("//a[text()='Оформление заказа']/parent::li[@id]");
    public By bonusProgramLocator = By.xpath("//a[text()='Бонусная программа']/parent::li[@id]");  //*[contains(@class, 'page_item page-item-359 current_page_item')]/a"



}
