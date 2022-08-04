package qa.selectTest.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {

    protected AppManager app = new AppManager();
    protected WebDriver wd;

    public MainPage(WebDriver wd) {
        this.wd = wd;

        PageFactory.initElements(wd, this);
    }

    public void open() {
        wd.get("http://qajava.skillbox.ru/search.html");
    }


    @FindBy(name = "author")
    public WebElement author;

    public void setAuthor( ) {
        this.author = author;
    }

    public List<String> getAuthor() {
        Select authors = new Select(author);
        return authors.getOptions().stream().map(element -> element.getText()).
                collect(Collectors.toList());
    }



    @FindBy(name = "year")
    public WebElement year;

    public void setYears(String value){
        Select years = new Select(year);
        years.selectByValue(value);
    }

    public String getYears(){
        Select years = new Select(year);
        return years.getFirstSelectedOption().getText();
    }



    @FindBy(css = ".show-results")
    public WebElement buttonShowFilter;
    public void clickShowFilter(){
        buttonShowFilter.click();
    }
    @FindBy(name = "scost")
    public WebElement costBook;
    public void setCostBook(String money){
        costBook.sendKeys(money);
    }

    @FindBy(css = "div:nth-child(2) > div:nth-child(1) > div.book-price > h1")
    public WebElement firstBookCosts;

    public String getFirstBookCosts(){
        String str = firstBookCosts.getText();
        return str;
    }

    /**
     * String str = firstBookCosts.getText();
     *         String pattern = "[0-9]";
     *         Pattern r = Pattern.compile(pattern);
     *         Matcher m = r.matcher(str);
     *         HashSet<String> ab = new HashSet<String>();
     *         ab.add(m.toString());
     *         return ab.toString();
     */


    @FindBy(name = "fname")
    public WebElement nameBook;

    public void setNameBook (String book){
        nameBook.sendKeys(book);
    }

}