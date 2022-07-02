package qa.technic.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.booksStore.Page.AppManager;

public class Pagination {
    WebDriver wd;

    Pagination(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);

    }

}
