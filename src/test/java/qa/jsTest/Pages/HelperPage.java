package qa.jsTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HelperPage {

    protected WebDriver wd;


    public HelperPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);


    }





}
