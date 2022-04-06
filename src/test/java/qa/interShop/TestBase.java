package qa.interShop;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));//неявное ожидание елемента в DOM страницы
        driver.manage().window().setSize(new Dimension(1920,1080));

    }

    @AfterEach
    public void tearDown() throws IOException {
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        driver.quit();
    }

}
