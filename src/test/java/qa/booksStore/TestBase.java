package qa.booksStore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import qa.booksStore.Page.AppManager;

import java.io.IOException;

public class TestBase {

    AppManager app = new AppManager();

    @BeforeEach
    public void setUp(){
        app.init();
    }


    @AfterEach
    public void tearDown() throws IOException {
        app.close();
    }


}
