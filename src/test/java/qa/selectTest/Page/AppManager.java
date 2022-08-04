package qa.selectTest.Page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppManager {

    protected WebDriver wd;
    public WebDriverWait wait;
    public MainPage mp;

    public void init(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);
        wait = new WebDriverWait(wd, Duration.ofSeconds(3000));

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));


        mp = new MainPage(wd);
        mp.open();
    }



    public void close() throws IOException {
        File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        wd.quit();
    }

    public MainPage getMainPage(){
        return mp;
    }


}
