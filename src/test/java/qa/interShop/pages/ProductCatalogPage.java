package qa.interShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCatalogPage {
    private WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        this.driver = driver;
    }


    //Catalog===========================================================================================================
    public By productCategoriesLocator = By.cssSelector(".widget.woocommerce.widget_product_categories");
    public By productFilterLocator = By.cssSelector(".widget.woocommerce.widget_price_filter");

    public By catalogSearchResultLocator = By.cssSelector(".woocommerce-breadcrumb.accesspress-breadcrumb span");
    public By searchProductNameLocator = By.xpath("//ul//h3[contains(text(), 'Холодиль')]");

    public By allProductsCatalogLocator = By.cssSelector("div.wc-products");
    public By buttonBasketCatalogLocator = By.cssSelector("a.button.add_to_cart_button");
    public By buttonDetailedCatalogLocator = By.cssSelector("a.added_to_cart.wc-forward");


}
