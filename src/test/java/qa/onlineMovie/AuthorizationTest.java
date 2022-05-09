package qa.onlineMovie;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AuthorizationTest extends TestBase {


    @Test
    @Disabled
    @DisplayName("Авторизация ..")//не пройдет, так как перед регистраией нужно сделать регистрацию
    public void test12() throws InterruptedException {
        page.open(page.getAuthorizationPage().urlAuth);
        //page.emailLocator.click();
        page.getAuthorizationPage().
                emailLocator.sendKeys(page.userEmail);
        page.getAuthorizationPage().
                passwordLocator.sendKeys(page.userPassword);
        page.getAuthorizationPage().
                enterButtonLocator.click();
        wait(3);
        String url = driver.getCurrentUrl();

        assertAll(
                () -> assertEquals(page.getPersonalAccountPage().urlPersonAccount,
                        url, "Переход не осуществлен на страницу: " + url),
                () -> assertTrue(page.pa.titlePersonAcLocator.isDisplayed(),
                        "Заголовок Личный Кабинет - отсутствует")
        );

    }



}
