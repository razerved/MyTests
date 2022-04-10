package qa.interShop;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import qa.interShop.pages.MainPage;
import static org.junit.jupiter.api.Assertions.*;


public class MainPageTest extends TestBase {

    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckMainElements(){
        var page = new MainPage(driver);

        driver.get(page.urlMain);
        //driver.navigate().to(mp.url);
        assertAll(
                ()->assertTrue(driver.findElement(page.logoTitleLocator).isDisplayed(),
                        "Logo отсутствует"),
                ()->assertTrue(driver.findElement(page.enterLocator).isDisplayed(),
                "Кнопка 'Войти' отсутствует"),
                ()->assertTrue(driver.findElement(page.sectionSaleLocator).isDisplayed(),
                        "Секция 'Распродажа' отсутствует"),
                ()->assertTrue(driver.findElement(page.sectionNewCollectionLocator).isDisplayed(),
                        "Секция 'Новые Товары' отсутствует")
        );
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        page.findContactsMainPage();
        assertTrue(driver.findElement(page.contactsInfoLocator).isDisplayed(),
                "Секция 'Контакты' отсутствует");
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
        assertEquals( page.urlAuthoriz, actMyAccount,
                "Переход осуществлен на страницу: " + actMyAccount);

        driver.get(page.urlMain);
        driver.findElement(page.hp.navigationBasketPanelLocator).click();
        String actMyBasket = driver.getCurrentUrl();
        assertEquals(page.urlBasket, actMyBasket,
                "Переход осуществлен на страницу: " + actMyBasket);

        driver.get(page.urlBasket);
        page.hp.navigationMainPanelLocator.click(); //PageFactory=======================================================
        String actMyMain = driver.getCurrentUrl();
        assertEquals(page.urlMain , actMyMain,
                "Переход осуществлен на страницу: " + actMyMain);

        driver.get(page.urlMain);
        driver.findElement(page.hp.bonusProgramLocator).click();
        String actBonusProgram = driver.getCurrentUrl();
        assertEquals(page.bonus.urlBonus, actBonusProgram,
                "Переход осуществлен на страницу: " + actBonusProgram);

    }
    
    /*@Test
    public void testAuthorization(){

    }*/

    /*@Test
    public void test(){
        MainPage page = new MainPage(driver);

        driver.get(page.urlMain);
        page.randomRegistrationMethod();
    }*/



}
