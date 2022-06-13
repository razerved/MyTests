package qa.booksStore.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    protected AppManager app = new AppManager();
    protected WebDriver wd;

    public MainPage(WebDriver wd) {
        this.wd = wd;

        PageFactory.initElements(wd, this);
    }




    @FindBy(name = "author")
    public WebElement author;

    public void setAuthor() {
        this.author = author;
    }

    public List<WebElement> getAuthor() {
        return null;
    }



    @FindBy(name = "year")
    public WebElement year;

    public void setYears(){
        this.year = year;
    }

    public String getYears(){
        return null;
    }


    public void open() {
        wd.get("http://qajava.skillbox.ru/search.html");
    }


}