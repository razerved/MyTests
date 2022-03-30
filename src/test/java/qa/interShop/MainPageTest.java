package qa.interShop;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import qa.interShop.pages.MainPage;

import static org.junit.Assert.*;

public class MainPageTest extends TestBase {

    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckMainElements(){
        var page = new MainPage(driver);

        driver.get(page.urlMain);
        //driver.navigate().to(mp.url);
        assertTrue("Logo отсутствует",
                driver.findElement(page.logoTitleLocator).isDisplayed());
        assertTrue("Кнопка 'Войти' отсутствует",
                driver.findElement(page.enterLocator).isDisplayed());
        assertTrue("Секция 'Распродажа' отсутствует",driver
                .findElement(page.sectionSaleLocator).isDisplayed());
        assertTrue("Секция 'Новые Товары' отсутствует",driver
                .findElement(page.sectionNewCollectionLocator).isDisplayed());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        page.findContactsMainPage();
        assertTrue("Секция 'Контакты' отсутствует",
                driver.findElement(page.contactsInfoLocator).isDisplayed());
    }


    /**
     * Проверка правильности редиректа Навигационной панели
     */
    @Test
    public void testCheckRedirectPanel(){
        var page = new MainPage(driver);

        driver.get(page.urlMain);
        driver.findElement(page.hp.navigationMyAccPanelLocator).click();
        String actMyAccount = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyAccount + " ", page.UrlAuthoriz , actMyAccount);

        driver.get(page.urlMain);
        driver.findElement(page.hp.navigationBasketPanelLocator).click();
        String actMyBasket = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyBasket + " ", page.UrlBasket , actMyBasket);

        driver.get(page.UrlBasket);
        page.hp.navigationMainPanelLocator.click(); //PageFactory=======================================================
        String actMyMain = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyMain + " ", page.urlMain , actMyMain);
    }

    /*@Test
    public void testAuthorization(){

    }*/

}
