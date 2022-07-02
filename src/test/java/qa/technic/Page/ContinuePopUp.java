package qa.technic.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContinuePopUp {
    private WebDriver wd;
    Pagination pages;

    public ContinuePopUp(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
        pages = new Pagination(wd);
    }





}
