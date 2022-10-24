package qa.jsTest;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.jsTest.Pages.AppManagers;
import qa.jsTest.Pages.HelperPage;
import qa.jsTest.Pages.ParrotPage;

import java.io.IOException;

public class IFrameTest extends TestBase {
    AppManagers appNew = new AppManagers();


    @Test
    @DisplayName("Проверка перехода на новую страницу")
    public void test1() throws IOException {
        appNew.init_whit_no_LoadPage();
        appNew.getPp().openParrotPage();
        appNew.getPp().frameObject(appNew.getPp().frameForm);
        appNew.getPp().inputGirl.click();
        appNew.getPp().frameObject(appNew.getPp().frameFooter);
        appNew.getPp().linkSkillbox.click();
        appNew.getPp().switchToNewWindow();
        String actualUrl = appNew.getPp().getCerrentURL_whitOutLoadPage();
        Assert.assertEquals("URL сайта сходится","https://skillbox.ru/",actualUrl);
    }
    @AfterEach
    protected void newOut() throws IOException {
        appNew.out();
    }

    @Test
    public void test2(){

    }


}
