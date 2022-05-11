package qa.onlineInstitute;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FirstTest extends TestBase {
    private WebDriver wd;

    @Test
    public void Test() {

        {
            WebElement element = wd.findElement(By.cssSelector(".baseButton"));
            Actions builder = new Actions(wd);
            builder.moveToElement(element).perform();
        }
        app.getGroupHelper().listCourses();
        wd.findElement(By.cssSelector(".baseCard:nth-child(1) .baseCard__button")).click();
        app.getGroupHelper().submitCourseAdded();
        wd.findElement(By.cssSelector(".baseCard:nth-child(2) .baseCard__button")).click();
        wd.findElement(By.cssSelector(".popup__overflow")).click();
        app.getGroupHelper().goToPersonalAccount();
        wd.findElement(By.cssSelector(".baseTabs__link:nth-child(2) > span")).click();
        {
            WebElement element = wd.findElement(By.cssSelector(".baseTabs__link:nth-child(2) > span"));
            Actions builder = new Actions(wd);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = wd.findElement(By.tagName("body"));
            Actions builder = new Actions(wd);
            builder.moveToElement(element, 0, 0).perform();
        }
    }




}
