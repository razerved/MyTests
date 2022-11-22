package qa.jsTest;


import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import qa.jsTest.Pages.AppManagers;

import java.io.IOException;

public class TestBase{

    public static AppManagers app = new AppManagers();

    @BeforeAll
    static void setUp(){
        app.init();
    }



    @AfterAll
    static void tearDown() throws IOException {
        app.out();
    }


}
