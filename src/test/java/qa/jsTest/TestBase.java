package qa.jsTest;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.jsTest.Pages.AppManagers;

import java.io.IOException;

public class TestBase{

    AppManagers app = new AppManagers();

    @BeforeEach
    public void setUp(){
        app.init();
    }



    @AfterEach
    public void tearDown() throws IOException {
        app.out();
    }


}
