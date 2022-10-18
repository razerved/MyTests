package qa.inputFile.page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class MainPageInputFile {
    private JavascriptExecutor jsExecutor;
    private WebDriver wd;
    private ChromeOptions option;
    private WebDriverWait wait;


    public MainPageInputFile(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
        jsExecutor = (JavascriptExecutor)wd;
        PageFactory.initElements(wd, this);
    }
    public MainPageInputFile(){

    }

    public void initin(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        option = new ChromeOptions();
        wd = new ChromeDriver(option);
    }



    public void openSite(){
        wd.get(url);
    }

    private String url = "https://lm.skillbox.cc/qa_tester/module88/homework1/";


    @FindBy (css = ".js.greenCheck img[src*=green.png]")
    public WebElement greenCheckBox;

    @FindBy (css = "uploadFile")
    public WebElement fileNameInput;



    public void putFile(){
       var file = System.getProperty("F:\\test\\src\\test\\java\\qa\\inputFile\\exem.png");
        fileNameInput.sendKeys(file);
    }

    public void openDisplayedElementAndPutFile() {
        var file = System.getProperty("F:\\test\\src\\test\\java\\qa\\inputFile\\exem.png");
        jsExecutor.executeScript("document.getElementById(\"uploadInput\")" +
                "setAttribute(\"class\", \"xa-xa\")");
        fileNameInput.sendKeys(file);
    }



    public void out() throws IOException {
        try {
            takeScreenShot();
        }catch (UnhandledAlertException alertException) {
            Alert alert = wd.switchTo().alert();
            System.out.println("Allert text: " + alert.getText());
            alert.accept();
            takeScreenShot();
        }
        wd.quit();
    }

    public void takeScreenShot() throws IOException {
        File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        wd.quit();
    }

}
