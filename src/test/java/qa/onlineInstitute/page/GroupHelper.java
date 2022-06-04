package qa.onlineInstitute.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupHelper {

    private WebDriver wd;


    public GroupHelper(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }



    //Methods===========================================================================================================
    public void login(String userName, String userPassword) {
        wd.get("http://qa.skillbox.ru/module16/maincatalog/");
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.name("login")).click();
        wd.findElement(By.name("login")).sendKeys(userName);
        wd.findElement(By.name("password")).sendKeys(userPassword);
        wd.findElement(By.cssSelector(".baseButton")).click();
    }
    public void login(String userName, String userPassword,String url) {
        wd.get(url);
        wd.findElement(By.name("login")).click();
        wd.findElement(By.name("login")).sendKeys(userName);
        wd.findElement(By.name("password")).sendKeys(userPassword);
        wd.findElement(By.cssSelector(".baseButton")).click();
    }

    public void exitLogin(){
        wd.findElement(By.cssSelector(".baseHeader__button")).click();
    }
    public void listCourses() {
        wd.findElement(By.linkText("К списку курсов")).click();
    }

    public void goToPersonalAccount() {
        wd.findElement(By.cssSelector(".baseHeader__name")).click();
    }

    public void set(){
        wd.findElement(By.cssSelector(".baseHeader__name")).click();

    }



    public void submitCourseAdded() {
        wd.findElement(By.cssSelector(".popup__button")).click();
    }

    public Courses getCourses(int index){return new Courses(wd, index);}

    public PersonalCourses getPersonalCoursesCard(int index){return new PersonalCourses(wd,index);}

    public void gotToCoursesCatalog(){
        wd.get("http://qa.skillbox.ru/module16/maincatalog/");
    }


    @FindBy(css = "p.baseInput__errorText")
    public WebElement errorPass;

}
