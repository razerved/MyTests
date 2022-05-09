package qa.onlineMovie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.onlineMovie.pages.Page;

import java.io.IOException;
import java.util.Random;

/*
  ToDo: Для данного сайта требуется. сделать только не сложные тесты восстановления пароля!!!
*/
public class TestBase {
    protected WebDriver driver;
    /*WebDriver driver;
        WebDriverWait wait;*/
    public Page page = new Page(driver);

    @BeforeEach
    public void setUp() {
        page.init();
    }


    @AfterEach
    public void teaDown() throws IOException {
        page.stop();
    }

}
