package qa.onlineInstitute.page;

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

public class ApplicationManager {

    private WebDriver wd;
    public WebDriverWait wait;

    private Courses course;
    private GroupHelper groupHelper;
    private PersonalCourses personalCourses;
    private PaymentPage PaymentPage;


    public void init() {
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);
        wait = new WebDriverWait(wd, Duration.ofSeconds(3000));

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        PaymentPage = new PaymentPage(wd);
        groupHelper = new GroupHelper(wd);
        course = new Courses(wd);
        personalCourses = new PersonalCourses(wd);
        groupHelper.login("admin", "tester");
    }



    public void stop() throws IOException {
        File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        wd.quit();
    }

    public PaymentPage getPaymentPage() {return PaymentPage;}
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public Courses getCourse(){return course;}
    public PersonalCourses getPersonalCourses(){return  personalCourses;}


}
