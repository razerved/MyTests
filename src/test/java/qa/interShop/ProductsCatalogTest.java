package qa.interShop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import qa.interShop.pages.MainPage;

public class ProductsCatalogTest extends TestBase{


    /**
     * Проверка основных секций, элементов на странице
     */
    @Test
    public void testCheckCatalogElements(){
        MainPage page = new MainPage(driver);

        driver.get(page.UrlCatalog);
        Assert.assertTrue("Категории товаров отсутствуют",
                driver.findElement(page.pc.productCategoriesLocator).isDisplayed());
        Assert.assertTrue("Фильтр отсутствует",
                driver.findElement(page.pc.productFilterLocator).isDisplayed());
        page.findContactsMainPage();

    }


    /**
     * Проверка редиректа в корзину, при покупке
     */
    @Test
    public void testAddingToBasket(){
        MainPage page = new MainPage(driver);

        driver.get(page.UrlCatalog);
        driver.findElements(page.pc.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.pc.buttonDetailedCatalogLocator).click();
        String actMyCart = driver.getCurrentUrl();
        Assert.assertEquals("Редирект на: "
                + page.UrlBasket + "не прошел", page.UrlBasket, actMyCart );

    }




}
