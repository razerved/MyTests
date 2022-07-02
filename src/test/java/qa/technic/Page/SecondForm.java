package qa.technic.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SecondForm {

    private WebDriver wd;
    public  Pagination pages;

    public SecondForm(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd,this);
        pages = new Pagination(wd);
    }

    @FindBy(id = "next")
    public WebElement submit;

    public ContinuePopUp submit(){
        submit.click();
        return new ContinuePopUp(wd);
    }


    @FindBy(tagName = "select")
    public WebElement timeSelect;

    public void setTimeSelect(String value) {
        new Select(timeSelect).selectByVisibleText(value);
    }
    public String getTimeSelect(){
        return new Select(timeSelect).getFirstSelectedOption().getText();
    }
}
