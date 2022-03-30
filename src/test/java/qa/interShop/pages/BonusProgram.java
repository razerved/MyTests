package qa.interShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BonusProgram {
    private WebDriver driver;

    public BonusProgram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }








}
