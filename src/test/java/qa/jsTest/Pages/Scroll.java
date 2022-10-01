package qa.jsTest.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class Scroll extends HelperPage {

    public Scroll(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    @FindBy(css = "")
    public WebElement finger;

    public void scrollMethod(){
        //первый спопоб - ( отдаленно похож на пользовательский,
        // Action сам скролит до елемента )
        new Actions(wd)
                .moveToElement(finger)
                .perform();
        //второй способ - ( приближен к пользователю,
        // мучаешься с определением кол-во вызовов Keys.ARROW_ в нужном направлении )
        for (var i = 0; i < 200; i++){
            finger.sendKeys(Keys.ARROW_DOWN);
        }
        //Третий способ - ( самый быстрый нужно ждать явное появление элемента,
        // если есть анимация, используется как правило в последнем случае )
        jS.executeScript("arguments[0].scrollIntoView();", finger);
        wait.until(ExpectedConditions.visibilityOf(finger));



    }

}
