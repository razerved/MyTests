package qa.onlineMovie;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends TestBase {


    @Test
    @DisplayName("Тест успешной регистрации данные соответствуют указанным")
    public void test1() {
        page.open(page.rp.urlRegister);

        page.getRegistrationPage().registration();

        assertAll(
                () -> assertEquals(page.rp.userEmail,
                        page.rp.emailAfterRegistration.getText(),
                        "Почта не соответствует при регистрации"),
                () -> assertTrue(page.rp.notificationMail.isDisplayed(),
                        "Модальное сообщение в виде почты, не появилось")
        );

        page.rp.notificationMail.click();

        assertAll(
                () -> assertEquals(page.rp.userEmail,
                        page.rp.modalLoginField.getText(),
                        "Логин не соответствует почте при регистрации"),
                () -> assertEquals(page.rp.userPassword,
                        page.rp.modalPasswordField.getText(),
                        "Пароль не соответствует заданному при регистрации"),
                () -> assertTrue(page.rp.modalLinkForAuth.isDisplayed(),
                        "Ссылка перехода в личный кабинет отсутсвтвует")
        );

        page.rp.modalLinkForAuth.click();

        try {
            sleep(200);
            String actPage = driver.getCurrentUrl();
            assertEquals(actPage, page.ap.urlAuth,
                    "Переход из модального окна при регистрации," +
                            " на страницу авторизации не успешный");
        } catch (Exception e) {
        }

    }


    @Test
    @DisplayName("Успешный тест восстановление пароля + авторизация с новым паролем")
    public void test2() {
        page.open(page.getRegistrationPage().urlRegister);
        page.getRegistrationPage().registration();
        page.toGotoModalWindowForgotPass();
        page.getAuthorizationPage().modalWindowEmailLocatorRestorePasswordLocator
                .sendKeys(page.userEmail);
        page.getAuthorizationPage().modalWindowButtonRestorePasswordLocator.click();
        page.getAuthorizationPage().restoreInfoMail.click();
        String newPassword = page.getAuthorizationPage().newRestoreUserPasswordLocator.getText();
        page.getAuthorizationPage().closeInfoModalWindowRestoreLocator.click();
        page.getAuthorizationPage().authorizationMethod(newPassword);
        page.waitForDisplayed(page.pa.myFilmTextLocator); // ожидание, в рамках Задачи
        assertTrue(page.getPersonalAccountPage().titlePersonAcLocator.isDisplayed(),
                "Пользователь не попал в личный кабинет");


    }

    @Test
    @DisplayName("Проверка ошибки не верно вписанного email при восстановлении пароля")
    public void test3() {
        page.open(page.getRegistrationPage().urlRegister);
        page.getRegistrationPage().registration();
        page.toGotoModalWindowForgotPass();
        page.fillForgotPasswordForm("test@ts.com");
        String errorMessage = page.getAuthorizationPage().errorEmailNotRegistered.getText();
        assertEquals("Такой email не зарегистрирован",
                errorMessage, "Не выведен тект - Email не зарегистрирован");

    }


    @Test
    @DisplayName("Проверка ошибки \"Введите Email\" при восстановлении пароля")
    public void test4() {
        page.open(page.getRegistrationPage().urlRegister);
        page.getRegistrationPage().registration();
        page.toGotoModalWindowForgotPass();
        page.getAuthorizationPage().modalWindowButtonRestorePasswordLocator.click();
        String errorMessage = page.getAuthorizationPage().errorEnterEmail.getText();
        assertEquals("Введите email",
                errorMessage, "Не выведен тект - Введите email");

    }

    @Test
    @DisplayName("Проверка не валидности старого пароля, при восстановлении пароля")
    public void test5(){
        page.open(page.getRegistrationPage().urlRegister);
        page.getRegistrationPage().registration();
        page.toGotoModalWindowForgotPass();
        page.getAuthorizationPage().modalWindowEmailLocatorRestorePasswordLocator
                .sendKeys(page.userEmail);
        page.getAuthorizationPage().modalWindowButtonRestorePasswordLocator.click();
        page.getAuthorizationPage().restoreInfoMail.click();
        String newPassword = page.getAuthorizationPage().newRestoreUserPasswordLocator.getText();
        page.getAuthorizationPage().closeInfoModalWindowRestoreLocator.click();
        page.getAuthorizationPage().authorizationMethod();
        assertEquals("Пароль не относится к почте",
                page.getText(page.ap.errorEmailDoestApplyMail),"Старый пароль валиден");
    }

}
