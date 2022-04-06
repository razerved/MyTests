package qa.interShop;

import org.junit.jupiter.api.Test;
import qa.interShop.pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsCatalogTest extends TestBase{


    /**
     * Проверка редиректа в корзину, при покупке
     */
    @Test
    public void testAddingToBasket(){
        MainPage page = new MainPage(driver);

        driver.get(page.urlCatalog);
        page.pc.buttonBasketCatalogLocator.get(2).click(); //PageFactory================================================
        driver.findElement(page.pc.buttonDetailedCatalogLocator).click();
        String actMyCart = driver.getCurrentUrl();
        assertEquals(page.urlBasket, actMyCart ,
                "Редирект на: " + page.urlBasket + "не прошел");

    }


    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckCatalogElements(){
        MainPage page = new MainPage(driver);

        driver.get(page.urlCatalog);
        assertTrue(driver.findElement(page.pc.productCategoriesLocator).isDisplayed(),
                "Категории товаров отсутствуют");
        assertTrue(driver.findElement(page.pc.productFilterLocator).isDisplayed(),
                "Фильтр отсутствует");
        page.findContactsMainPage();

    }


}
