package qa.onlineInstitute.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PersonalCourses extends GroupHelper {
    //private WebDriver wd;
    private int index;

    public PersonalCourses(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public PersonalCourses(WebDriver wd, int index) {
        super(wd);
        this.index = index;
        PageFactory.initElements(wd, this);
    }

    @FindBy(css = ".baseTabsItem--show .pagePersonal__card")
    public List<WebElement> countAddCourse;

    @FindBy(css = ".baseButton.baseButton--blueFill")
    public WebElement payForCourses;

    @FindBy(css = ".baseButton.pagePersonal__button")
    public WebElement buttonPersonalToListCourses;

    @FindBy(xpath = "//a[@href='#Отложенные курсы']")
    public WebElement defermentPersonalСourses;

    @FindBy(xpath = "//a[@href='#Текущие курсы']")
    public WebElement actualPersonalCourses;

    @FindBy(css = ".baseButton.baseCard__button")
    public List<WebElement> addPersonalCourseButton;

    @FindBy(xpath = "//button[contains(text(),'Отказаться')]")
    public WebElement refuseCourses;

    @FindBy(css = ".baseCard__label")
    public List<WebElement> startDatePersonalCourse;

    @FindBy(css = ".baseCard__title")
    public List<WebElement> titlePersonalCourses;

    @FindBy(css = "div:nth-child(1)>p")
    public List<WebElement> videoPersonalCourses;

    @FindBy(css = "div:nth-child(2)>p")
    public List<WebElement> lessonPersonalCourses;

    @FindBy(xpath = "//p[contains(text(),'месяцев')]")
    public List<WebElement> monthsPersonalCourses;

    @FindBy(css = ".baseButton.baseCard__link")
    public List<WebElement> detailPersonalCourses;



    public String getPersonalStartDate(){return startDatePersonalCourse.get(index).getText();}
    public String getPersonalTitleCourses(){return titlePersonalCourses.get(index).getText();}
    public String getPersonalVideoCourses(){return videoPersonalCourses.get(index).getText();}
    public String getPersonalLessonCourses(){return lessonPersonalCourses.get(index).getText();}
    public String getPersonalMonthsCourses(){return monthsPersonalCourses.get(index).getText();}
    public void getPersonalDetailCourses(){detailPersonalCourses.get(index).click();}

    /*public void add(){
        addPersonalCourseButton.get(index).click();
        submitCourseAdded();
    }*/
    public void goToDeferredCourses() {
        defermentPersonalСourses.click();
    }

    public void payForCourses(){
        payForCourses.click();
    }

}
