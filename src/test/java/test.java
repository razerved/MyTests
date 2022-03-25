import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class test {


/*public WebDriver driver;

    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
    }*/

    @Test
    public void set(){
        open("https://www.google.com/");
        $("[name='q']").setValue("hi google").pressEnter();
        Configuration.holdBrowserOpen = true;
    }

}
