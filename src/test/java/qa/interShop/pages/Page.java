package qa.interShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    protected WebDriver driver;
    public HeaderPanel hp;

    public Page(WebDriver driver) {
        this.driver = driver;
        hp = new HeaderPanel(driver);
        PageFactory.initElements(driver, this);
    }
    /* protected WebDriver driver;
    public HeaderPanel hp;
    public BasketPage bp;
    public ProductCatalogPage pc;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.hp = hp;
        this.bp = bp;
        this.pc = pc;
        PageFactory.initElements(driver, this);
    }*/


}
