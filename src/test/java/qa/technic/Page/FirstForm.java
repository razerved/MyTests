package qa.technic.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FirstForm {

    private WebDriver wd;
    public Pagination pages;

    public  FirstForm(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
        pages = new Pagination(wd);
    }

    public FirstForm open(){
        wd.get("https://lm.skillbox.cc/qa_tester/module07/homework1/");
        return this;
    }


}
