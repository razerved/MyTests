package qa.interShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogPage {
    private WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements/*инициализирует елементы(запоминает)*/(driver, this/*передается класс страницы*/);
        //Добавление PageFactory - инициализирует страницы,
        // запоминает для каждого, елемента его локатор. Запускает поиск элемента при обращнеии к нему.
    }


    //Catalog===========================================================================================================
    public By productCategoriesLocator = By.cssSelector(".widget.woocommerce.widget_product_categories");
    public By productFilterLocator = By.cssSelector(".widget.woocommerce.widget_price_filter");

    public By catalogSearchResultLocator = By.cssSelector(".woocommerce-breadcrumb.accesspress-breadcrumb span");
    public By searchProductNameLocator = By.xpath("//ul//h3[contains(text(), 'Холодиль')]");
    public By allProductsCatalogLocator = By.cssSelector("div.wc-products");

    @FindBy(css = "a.button.add_to_cart_button")//структура PageFactory
    public List<WebElement> buttonBasketCatalogLocator;

    //public By buttonBasketCatalogLocator = By.cssSelector("a.button.add_to_cart_button");
    public By buttonDetailedCatalogLocator = By.cssSelector("a.added_to_cart.wc-forward");


}
