package qa.interShop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import qa.interShop.pages.MainPage;

import static org.junit.Assert.*;

public class ProductsCatalogTest extends TestBase{


    /**
     * Проверка редиректа в корзину, при покупке
     */
    @Test
    public void testAddingToBasket(){
        MainPage page = new MainPage(driver);

        driver.get(page.UrlCatalog);
        page.pc.buttonBasketCatalogLocator.get(2).click(); //PageFactory================================================
        driver.findElement(page.pc.buttonDetailedCatalogLocator).click();
        String actMyCart = driver.getCurrentUrl();
        assertEquals("Редирект на: "
                + page.UrlBasket + "не прошел", page.UrlBasket, actMyCart );

    }


    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckCatalogElements(){
        MainPage page = new MainPage(driver);

        driver.get(page.UrlCatalog);
        assertTrue("Категории товаров отсутствуют",
                driver.findElement(page.pc.productCategoriesLocator).isDisplayed());
        assertTrue("Фильтр отсутствует",
                driver.findElement(page.pc.productFilterLocator).isDisplayed());
        page.findContactsMainPage();

    }


}
