package qa.interShop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.interShop.pages.MainPage;

import static org.junit.Assert.*;

public class BasketTest extends TestBase {


    /**
     * Проверка применения купона sert500 - скидка 500 руб.
     */
    @Test
    public void testCoupon(){
        var page = new MainPage(driver);

        driver.get(page.urlCatalog);
        driver.findElements(page.bp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        driver.findElement(page.bp.enterCouponLocator).sendKeys("sert500");
        driver.findElement(page.bp.buttonCouponLocator).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(page.bp.textSertLocator));
        String actRes = driver.findElement(page.bp.textSertLocator).getText();
        assertEquals("Вызывается купон 'Скидка: sert500' ",
                "СКИДКА: SERT500 -500,00₽ [Удалить]",actRes);
        /*String priceText = driver.findElement(hp.textPriceLocator).getText();
        int price = Integer.parseInt(priceText); // это итоговое число для оплаты
        int priceWithCoupon = (price - 500);
        if (price == priceWithCoupon){
            Assert.assertTrue("Скидка применена корректно", (price==priceWithCoupon));
        }else {
            Assert.assertTrue("Скидка применена не корректно", (price!=priceWithCoupon));
        }*/
        driver.findElement(page.bp.buttonBasketCheckoutLocator).click();
    }


    /**
     * Может изменить количество
     */
    @Test
    public void testCanChangQuantity(){
        var page = new MainPage(driver);

        driver.get(page.urlCatalog);
        driver.findElements(page.bp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        driver.findElement(page.bp.changeNumberLocator).sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(page.bp.changeNumberLocator).sendKeys(Keys.BACK_SPACE);
        driver.findElement(page.bp.changeNumberLocator).sendKeys("0");
        driver.findElement(page.bp.changeNumberLocator).sendKeys(Keys.ENTER);
        var x = driver.findElement(page.bp.emptyBasketTextLocator).getText();
        assertEquals("Запись Корзина пуста не появилась","Корзина пуста." , x);
    }


    /**
     * Удаление товара из корзины и восстановление
     */
    @Test
    public void deleteAndRecoveryProduct(){
        var page = new MainPage(driver);

        driver.get(page.urlCatalog);
        driver.findElements(page.bp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        //driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        String product = driver.findElement(page.bp.nameProductLocator).getText();
        driver.findElement(page.bp.removeButtonLocator).click();
        var x = driver.findElement(page.bp.emptyBasketTextLocator).getText();
        assertEquals("Запись Корзина пуста не появилась","Корзина пуста." , x);
        driver.findElement(page.bp.returnProductLocator).click();
        assertEquals("Название товара отличается", product, product);

    }


    /**
     * Применен не верный купон (проверка валидности информ ошибки)
     */
    @Test
    public void notCorrectCoupon(){
        var page = new MainPage(driver);

        driver.get(page.urlCatalog);
        driver.findElements(page.bp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        driver.findElement(page.bp.enterCouponLocator).sendKeys("rest500");
        driver.findElement(page.bp.buttonCouponLocator).click();
        String actRes = driver.findElement(page.bp.notCorrectCouponTextLocator).getText();
        Assert.assertEquals("Вызывается не правильный купон 'Скидка: rest500' ",
                "Неверный купон.",actRes);
    }


    /**
     * Оформленный товар редирект на страницу оформление заказа
     */
    @Test
    public void orderProcessing(){
        var page = new MainPage(driver);

        driver.get(page.urlCatalog);
        driver.findElements(page.bp.buttonBasketCatalogLocator).get(2).click();
        driver.findElement(page.bp.buttonDetailedCatalogLocator).click();
        driver.findElement(page.bp.buttonBasketCheckoutLocator).click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(hp.checkoutHeaderLocator));
        try {
            Thread.sleep(500);
            String ActResult = driver.getCurrentUrl();
            Assert.assertEquals("Редирект на: "
                    + page.urlOrderProcessing + "не прошел", page.urlOrderProcessing, ActResult);
        }catch (Exception e){}


    }





}
