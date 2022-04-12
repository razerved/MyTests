package qa.onlineMovie;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLOutput;

public class RegistrationTest extends TestBase {


    @Test
    @DisplayName("Тест успешной регистрации данные соответствуют указанным")
    public void test2() {
        page.open(page.rp.urlRegister);

        page.rp.registration();

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

        try{
            sleep(200);
            String actPage = driver.getCurrentUrl();
            assertEquals(actPage, page.ap.urlAuth,
                    "Переход из модального окна при регистрации," +
                            " на страницу авторизации не успешный");
        }catch (Exception e){}



    }


    /*@Test
    public void test3() {


    }*/


}
