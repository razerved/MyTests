package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Webinars extends HelperPage {


    public Webinars(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = "")
    public WebElement aboutSkillbox;

    @FindBy(css = "a[href*='company'].dropdown-desktop__link")
    public WebElement aboutPlatform;
    @FindBy(css = "")
    public WebElement centerCareer;

    @FindBy(css = "")
    public WebElement webinar;




    public void holdAboutSkillboxJs(/*String value*/){
        jS.executeScript("document." +
                "getElementsByClassName('dropdown-desktop menu-desktop-item__dropdown')[0]" +
                ".style = 'display:block'");
        /*Select sl = new Select(aboutPlatform);
        sl.selectByValue(value);*/
    }


    public void holdAboutSkillboxSelect(){

    }


    public void holdWebinars(){
        jS.executeScript("document." +
                "getElementsByClassName('dropdown-desktop menu-desktop-item__dropdown')[1]" +
                ".style = 'display:block'");
    }



    /**
     *  Блок
     */
    //------------------------------------------------------------------------------------------------------------------


    /**
     *  Блок
     */
    //------------------------------------------------------------------------------------------------------------------


    /**
     *  Блок
     */
    //------------------------------------------------------------------------------------------------------------------


    /**
     *  Блок
     */



}
