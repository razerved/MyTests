package qa.onlineInstitute.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {

    private WebDriver wd;


    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }



    //Methods===========================================================================================================
    public void login(String userName, String userPassword) {
        wd.get("http://qa.skillbox.ru/module16/maincatalog/");
        wd.findElement(By.linkText("Войти")).click();
        //wd.findElement(By.name("login")).click();
        wd.findElement(By.name("login")).sendKeys(userName);
        wd.findElement(By.name("password")).sendKeys(userPassword);
        wd.findElement(By.cssSelector(".baseButton")).click();
    }

    public void listCourses() {
        wd.findElement(By.linkText("К списку курсов")).click();
    }

    public void goToPersonalAccount() {
        wd.findElement(By.cssSelector(".baseHeader__name")).click();
    }

    public void submitCourseAdded() {
        wd.findElement(By.cssSelector(".popup__button")).click();
    }



}
