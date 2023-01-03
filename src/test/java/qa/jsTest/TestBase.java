package qa.jsTest;


import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import qa.jsTest.Pages.AppManagers;

import java.io.IOException;

public class TestBase{

    public static AppManagers app = new AppManagers();
    public static AppManagers appb =
            new AppManagers("CHROME");

    @BeforeAll
    static void setUp(){
        app.init();
    }



    @AfterAll
    static void tearDown() throws IOException {
        app.out();
    }

}
