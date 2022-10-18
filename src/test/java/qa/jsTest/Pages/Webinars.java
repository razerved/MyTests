package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Webinars extends HelperPage {


    public Webinars(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    @FindBy(css = "")
    public WebElement aboutSkillbox;

    @FindBy(css = "a[href*='company'].dropdown-desktop__link")
    public WebElement aboutPlatform;

    @FindBy(css = "a[href*='career'].dropdown-desktop__link")
    public WebElement centerCareer;

    @FindBy(css = ".menu-desktop-item__link.menu-desktop-item__link--button")
    public WebElement playlists;

    @FindBy(css = ".toggle-menu.header__toggle.toggle-menu--small")
    public WebElement sif;

    @FindBy(css = "a[href*='skillbox.ru/courses/']")
    public WebElement allCourses;


    public void holdAboutSkillboxJs(/*String value*/){
        jS.executeScript("document." +
                "getElementsByClassName('dropdown-desktop menu-desktop-item__dropdown')[0]" +
                ".style = 'display:block'");
        /*Select sl = new Select(aboutPlatform);
        sl.selectByValue(value);*/
    }
    public void holdWebinars(){
        jS.executeScript("document." +
                "getElementsByClassName('dropdown-desktop menu-desktop-item__dropdown')[1]" +
                ".style = 'display:block'");

    }
    //ToDo: перемещение между вкладками (окнами)
    public void switchToTabs(){
        String main = wd.getWindowHandle(); //сохранение номера текущей Main страницы
        //Set<String> allWindow = wd.getWindowHandles();//сохранение массива всех страниц
        for (String tab : wd.getWindowHandles()){
            /*Set<String> otherWindow = allWindow.stream()
                    .filter(x -> !x.equals(main)).collect(Collectors.toSet()); исключаем страницу с которой
                    производили открытие*/
            //wd.switchTo().window(otherWindow.iterator().next());//получить первый элемент из всех
            //wd.switchTo().window(otherWindow.stream().findFirst().get());//получить первый элемент из всех
            wd.switchTo().window(tab);
            //wd.switchTo().window(main) - вернуться к первооткрытой вкладке
        }
    }


    public void goToPlaylist(){
            clik(playlists);
    }


    public boolean isSuccessDisplayed() {
        try {
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return true;//как вариант запихнуть ожидание элемента.isDisplayed
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }


    public void waitForDisplayed(By element) {
        var newWait = new WebDriverWait(wd, Duration.ofSeconds(7));
        newWait.until(driver -> driver.findElement(element).isDisplayed());
    }



}
