package qa.onlineMovie.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class Page {

     WebDriver driver;
     WebDriverWait wait;
    public RegistrationPage rp;
    public AuthorizationPage ap;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //driver.manage().window().setSize(new Dimension(1920,1080));

        rp = new RegistrationPage(driver);
        ap = new AuthorizationPage(driver);
    }

    public void stop() throws IOException {
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        driver.quit();
    }

    public void open(String url){
        driver.get(url);
    }









    public String randomName(){
        return randomText();
    }

    public String randomEmail(){
        return randomText() + "@" + randomText() + ".com";
    }


    public String randomText(){
        Random rnd = new Random();
        char[] some = {'a','b','c','d','e','f','g','k','l','m','n','o'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6 ; i++){
            char newChar = (char) rnd.nextInt(14);
            stringBuilder.append(some[newChar]);
        }
        return stringBuilder.toString();
    }

    public void click(WebElement locator){
        locator.click();
    }





}
