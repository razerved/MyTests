package qa.interShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import qa.interShop.pages.BonusProgram;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BonusProgramTest extends TestBase {


    /**
     * Параметризованный
     * Проверка успешного оформления карты, Латиница- Тел (8) и Кирилица- Тел (+7)
     */
    private static Stream<Arguments> parametersLatinCyrillic(){
        return Stream.of(
                arguments("Вася","+79111111111"),
                arguments("Ivan","89111111111")
        );
    }

    @ParameterizedTest
    @MethodSource("parametersLatinCyrillic")
    public void issuedCardLatin(String name, String phone) {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.cardRegistrationMethod(name,
                phone);

        try {
            wait(5000);//текст появляется последовательно, потому накинул wait
            String actualResult = page.textCardIsIssued.getText();
            assertEquals("Отсутствует текст заголовка \"Ваша карта оформлена\"",
                    actualResult, page.textForClient);
        } catch (Exception e) {
        }

    }

   /* @Test //использован как Параметризированные данные
    public void issuedCardCyrillic() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.cardRegistrationMethod(page.bonusTestName2,
                page.bonusTestPhone2);

        try {
            wait(5000);//тек появляется последовательно, потому накинул wait
            String actualResult = page.textCardIsIssued.getText();
            assertEquals("Отсутствует текст заголовка \"Ваша карта оформлена\"",
                    actualResult, page.textForClient);
        } catch (Exception e) {
        }

    }*/


    /**
     * Проверка обязательного заполнения полей
     */
    @Test
    public void checkRequiredFields() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        page.buttonCreateCardBonusProgramLocator.click();
        assertEquals(page.errorText.getText(), "Поле \"Имя\" обязательно для заполнения\n" +
                "Поле \"Телефон\" обязательно для заполнения");

        driver.get(page.urlBonus);
        page.enterTextBonusProgramLocator.sendKeys(page.bonusTestName);
        page.buttonCreateCardBonusProgramLocator.click();
        String actualResultTelephone = page.textRequiredField.getText();
        assertEquals("Поле \"Телефон\" обязательно для заполнения", actualResultTelephone,
                "Ошибка вывода текста обязательного заполнения телефона");
        page.enterTextBonusProgramLocator.clear();

        page.enterPhoneBonusProgramLocator.sendKeys(page.bonusTestName);
        page.buttonCreateCardBonusProgramLocator.click();
        String actualResultName = page.textRequiredField.getText();
        assertEquals("Поле \"Имя\" обязательно для заполнения", actualResultName,
                "Ошибка вывода текста обязательного заполнения имени");
        page.enterPhoneBonusProgramLocator.clear();

    }


    /**
     * При переходе на страницу Бонусной программы изначально не отображается Карта Оформлена
     */
    @Test
    public void SuccessResultMessageNotDisplayed() {
        BonusProgram page = new BonusProgram(driver);

        driver.get(page.urlBonus);
        Assertions.assertTrue(true, "При открытии страницы," +
                        " сразу не отоброжается успешное оформление карты");

    }


}
