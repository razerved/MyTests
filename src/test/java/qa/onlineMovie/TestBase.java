package qa.onlineMovie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import qa.onlineMovie.pages.Page;

import java.io.IOException;

public class TestBase {
    /*WebDriver driver;
    WebDriverWait wait;*/
    protected Page page;

    @BeforeEach
    public void setUp() {
        page.init();
    }



    @AfterEach
    public void teaDown() throws IOException {
        page.stop();
    }




}
