package qa.interShop;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        driver.manage().window().setSize(new Dimension(1920,1080));
        File sctFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sctFile, new File("F:\\screenShotForTest"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
