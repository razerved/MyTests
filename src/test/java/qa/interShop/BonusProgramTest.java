package qa.interShop;

import org.junit.Assert;
import org.junit.Test;
import qa.interShop.pages.BonusProgram;
import qa.interShop.pages.MainPage;

import static org.junit.Assert.*;

public class BonusProgramTest extends TestBase {


    /**
     * Проверка обязательного заполнения полей, при пустых данных выводит ошибку
     */
    @Test
    public void checkRequiredFields() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.buttonCreateCardBonusProgramLocator.click();
        assertEquals("", "Поле \"Имя\" обязательно для заполнения\n" +
                "Поле \"Телефон\" обязательно для заполнения", page.errorText.getText());

    }

    /**
     * Проверка успешного оформления карты
     */
    @Test
    public void issuedCard() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.enterTextBonusProgramLocator.sendKeys(page.bonusName);
        page.enterPhoneBonusProgramLocator.sendKeys(page.bonusTel);
        page.buttonCreateCardBonusProgramLocator.click();

        try {
            wait(5000);//тек появляется последовательно, потому накинул wait
            String actualResult = page.textCardIsIssued.getText();
            assertEquals("Отсутствует текст \"Ваша карта оформлена\"",page.textForClient,
                    actualResult);
        } catch (Exception e) {}

    }



}
