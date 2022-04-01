package qa.interShop;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
     * Проверка правильности редиректа Навигационной панели + bonusProgram
     */
    @Test
    @DisplayName("Testing redirect navigation panel")
    public void testCheckRedirectPanel(){
        var page = new MainPage(driver);

        driver.get(page.urlMain);
        driver.findElement(page.hp.navigationMyAccPanelLocator).click();
        String actMyAccount = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyAccount + " ", page.urlAuthoriz, actMyAccount);

        driver.get(page.urlMain);
        driver.findElement(page.hp.navigationBasketPanelLocator).click();
        String actMyBasket = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyBasket + " ", page.urlBasket, actMyBasket);

        driver.get(page.urlBasket);
        page.hp.navigationMainPanelLocator.click(); //PageFactory=======================================================
        String actMyMain = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actMyMain + " ", page.urlMain , actMyMain);

        driver.get(page.urlMain);
        driver.findElement(page.hp.bonusProgramLocator).click();
        String actBonusProgram = driver.getCurrentUrl();
        assertEquals("Переход осуществлен на страницу: "
                + actBonusProgram + " ", page.bonus.urlBonus, actBonusProgram);

    }
    
    /*@Test
    public void testAuthorization(){

    }*/

}
