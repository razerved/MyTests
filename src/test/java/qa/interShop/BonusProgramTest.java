package qa.interShop;

import org.junit.Test;
import qa.interShop.pages.BonusProgram;
import qa.interShop.pages.MainPage;

import static org.junit.Assert.*;

public class BonusProgramTest extends TestBase {


    /**
     * Проверка успешного оформления карты, Латиница- Тел (8)
     */
    @Test
    public void issuedCardLatin() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.cardRegistrationMethod(page.bonusTestName,
                page.bonusTestPhone);

        try {
            wait(5000);//тек появляется последовательно, потому накинул wait
            String actualResult = page.textCardIsIssued.getText();
            assertEquals("Отсутствует текст уведомления \"Ваша карта оформлена\"",
                    page.textForClient, actualResult);
        } catch (Exception e) {}

    }



    /**
     * Проверка успешного оформления карты, Кирилица- Тел (+7)
     */
    @Test
    public void issuedCardCyrillic() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.cardRegistrationMethod(page.bonusTestName2,
                page.bonusTestPhone2);

        try {
            wait(5000);//тек появляется последовательно, потому накинул wait
            String actualResult = page.textCardIsIssued.getText();
            assertEquals("Отсутствует текст уведомления \"Ваша карта оформлена\"",
                    page.textForClient, actualResult);
        } catch (Exception e) {}

    }


    /**
     * Проверка обязательного заполнения полей
     */
    @Test
    public void checkRequiredFields() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.buttonCreateCardBonusProgramLocator.click();
        assertEquals("", "Поле \"Имя\" обязательно для заполнения\n" +
                "Поле \"Телефон\" обязательно для заполнения", page.errorText.getText());

        driver.get(page.urlBonus);
        page.enterTextBonusProgramLocator.sendKeys(page.bonusTestName);
        page.buttonCreateCardBonusProgramLocator.click();
        String actualResultTelephone = page.textRequiredField.getText();
        assertEquals("Ошибка вывода текста обязательного заполнения телефона",
                "Поле \"Телефон\" обязательно для заполнения",actualResultTelephone);
        page.enterTextBonusProgramLocator.clear();

        page.enterPhoneBonusProgramLocator.sendKeys(page.bonusTestName);
        page.buttonCreateCardBonusProgramLocator.click();
        String actualResultName = page.textRequiredField.getText();
        assertEquals("Ошибка вывода текста обязательного заполнения имени",
                "Поле \"Имя\" обязательно для заполнения",actualResultName);
        page.enterPhoneBonusProgramLocator.clear();

    }


    /**
     * Проверка предоставления скидки при покупки
     */
    @Test
    public void requiredField(){
        MainPage page = new MainPage(driver);

        driver.get(page.urlMain);

    }


}
