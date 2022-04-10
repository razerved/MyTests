package qa.onlineMovie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends TestBase {


    @Test
    @DisplayName("Проверка первая")
    public void test1() {
        page.open(page.rp.urlRegister);

        page.rp.registration();
        assertAll(
                () -> assertEquals("", " ", " "),
                () -> assertEquals("", " ", " "),
                () -> assertEquals("", " ", " ")
        );

    }


    @Test
    public void test2() {
        page.open(page.rp.urlRegister);

    }


    @Test
    public void test3() {


    }

}
