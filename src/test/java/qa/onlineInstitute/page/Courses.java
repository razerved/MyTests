package qa.onlineInstitute.page;

import com.codeborne.selenide.impl.WebElementsCollectionWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Courses extends GroupHelper {
    //private WebDriver wd;
    private int index;

    public Courses(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public Courses(WebDriver wd, int index) {
        super(wd);
        this.index = index;
        PageFactory.initElements(wd, this);
    }


    @FindBy(css = ".baseButton.baseCard__button")
    public List<WebElement> addCourseButton;

    @FindBy(css = ".baseCard__label")
    public List<WebElement> startDateCourse;

    @FindBy(css = ".baseCard__title")
    public List<WebElement> titleCourses;

    @FindBy(css = "div:nth-child(1)>p")
    public List<WebElement> videoCourses;

    @FindBy(css = "div:nth-child(2)>p")
    public List<WebElement> lessonCourses;

    @FindBy(xpath = "//p[contains(text(),'месяцев')]")
    public List<WebElement> monthsCourses;

    @FindBy(css = ".baseButton.baseCard__link")
    public List<WebElement> detailCourses;


    public By sou = By.cssSelector("");
    public By sor = By.xpath("");


    //Methods===========================================================================================================
    public String getStartDate(){return startDateCourse.get(index).getText();}
    public String getTitleCourses(){return titleCourses.get(index).getText();}
    public String getVideoCourses(){return videoCourses.get(index).getText();}
    public String getLessonCourses(){return lessonCourses.get(index).getText();}
    public String getMonthsCourses(){return monthsCourses.get(index).getText();}
    public void getDetailCourses(){detailCourses.get(index).click();}

    public void add(){
        addCourseButton.get(index).click();
        submitCourseAdded();
    }

    public void addCourseButton(WebElement element){
        element.getSize();
    }



}
