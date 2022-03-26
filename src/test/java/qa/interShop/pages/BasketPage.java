package qa.interShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public By allProductsCatalogLocator = By.cssSelector("div.wc-products");
    public By buttonBasketCatalogLocator = By.cssSelector("a.button.add_to_cart_button");
    public By buttonDetailedCatalogLocator = By.cssSelector("a.added_to_cart.wc-forward");

    //Basket============================================================================================================
    public By buttonCouponLocator = By.cssSelector("button[name='apply_coupon']");
    public By buttonBasketCheckoutLocator = By.cssSelector("a.button.wc-forward");
    public By enterCouponLocator = By.cssSelector("#coupon_code");
    public By removeButtonLocator = By.cssSelector(".remove");
    public By deleteCouponLocator = By.cssSelector(".woocommerce-remove-coupon");
    public By textSertLocator = By.cssSelector("tr.coupon-sert500");
    public By textPriceLocator = By.xpath("tr[@class='order-total']//span/*[text()[contains(., ',00')]]");
    public By changeNumberLocator = By.cssSelector("input.input-text.qty.text");
    public By emptyBasketTextLocator = By.cssSelector("p.cart-empty.woocommerce-info");
    public By returnProductLocator = By.cssSelector("a.restore-item");
    public By nameProductLocator = By.cssSelector("td.product-name a");
    public By notCorrectCouponTextLocator = By.cssSelector("ul.woocommerce-error li");


    //Checkout==========================================================================================================
    public By inputNameLocator = By.cssSelector("input#billing_first_name");
    public By inputSecondNameLocator = By.cssSelector("input#billing_last_name");
    public By countryLocator = By.cssSelector("span#select2-billing_country-container");
    public By inputAddressLocator = By.cssSelector("input#billing_address_1");
    public By inputCityLocator = By.cssSelector("input#billing_city");
    public By inputStateLocator = By.cssSelector("input#billing_state");
    public By inputIndexLocator = By.cssSelector("input#billing_postcode");
    public By inputPhoneLocator = By.cssSelector("input#billing_phone");
    public By inputMailLocator = By.cssSelector("input#billing_email");
    public By radioButtonBankLocator = By.cssSelector("input#payment_method_bacs");
    public By radioButtonCourierLocator = By.cssSelector("input#payment_method_cod");
    public By buttonOrderLocator = By.cssSelector("button#place_order");
    public By inputCommentsLocator = By.xpath("//*[@id='order_comments']");
    public By finalOrderTextLocator = By.cssSelector("p.woocommerce-thankyou-order-received");
    public By lastOrderTextLocator = By.cssSelector("li.woocommerce-order-overview__order strong");
    public By erorrMessageLocator = By.cssSelector("div.woocommerce-NoticeGroup-checkout");

}
