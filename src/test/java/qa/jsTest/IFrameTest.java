package qa.jsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFrameTest extends TestBase {


    @Test
    @DisplayName("Проверка перехода на новую страницу")
    public void test1(){
        app.getPp().openParrotPage();
        app.getPp().frameObject(app.getPp().frameForm);
        app.getPp().inputGirl.click();
        app.getPp().frameObject(app.getPp().frameFooter);
        app.getPp().linkSkillbox.click();
        String actualUrl = app.getPp().switchToNewWindow();
        // = app.getPp().getCurrentURL();
        System.out.println(actualUrl);
    }



}
