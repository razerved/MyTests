package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.jsTest.TestBase;

import java.util.List;

public class NotesPage extends HelperPage {

    //ToDo:Перед написанием кода вручную предварительно выясните формат даты.
    // 1) Вызовите JS-код для установки и получения даты.
    // 2) Проверьте, что дата действительно изменилась.



    public NotesPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = "pageStatistic__date")
    public WebElement headerMainDate;

    @FindBy(css = "baseCalendar")
    public List<WebElement> CalendarArray;

    //public By CSSCalendar = By.cssSelector("baseCalendar");

    public String CSSCalendar = "baseCalendar";

    public void setCSSCalendar(String date){
        jS.executeScript(String.
                format("document.getElementsByClassName('baseCalendar')[0].__vue__.setDate(\"%s\");", date));
    }

    public String getCSSCalendar(){
       return String.
               valueOf(jS.executeScript
                       ("return document." +
                               "getElementsByClassName('baseCalendar')[0].__vue__.selectedDate",CSSCalendar));
    }


    /*@FindBy(css = "#date")
    public WebElement setADate;
    public By one = By.cssSelector("#date");
    public By two = By.xpath("");*/





}
