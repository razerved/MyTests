package qa.jsTest.Pages;

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

public class AppManagers {
    private WebDriver wd;
    public WebDriverWait wait;
    public HelperPage hp;
    public TaxiPage tx;
    public NotesPage np;
    public WebsiteCallRequests wcr;
    public Webinars wb;

    public AppManagers(WebDriver wd,
                       WebDriverWait wait,
                       TaxiPage tx,
                       NotesPage np,
                       WebsiteCallRequests wcr,
                       Webinars wb) {
        this.wait = wait;
        this.wd = wd;
        this.tx = tx;
        this.np = np;
        this.wcr = wcr;
        this.wb = wb;
    }
    public AppManagers(){}

    public void init() {
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);
        wait = new WebDriverWait(wd, Duration.ofSeconds(3000));

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        hp = new HelperPage(wd,wait);
        tx = new TaxiPage(wd, wait);
        np = new NotesPage(wd,wait);
        wcr = new WebsiteCallRequests(wd, wait);
        wb = new Webinars(wd);

        /*SSLEngine request = null;
        HttpSession session= (HttpSession) request.getSession();
        session.setMaxInactiveInterval(604800);
        session.setAttribute("loggedOnUser", true);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(Integer.MAX_VALUE);
        HttpServletResponse response = null;
        response.addCookie(cookie);*/

    }


    public void out() throws IOException {
        File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        wd.quit();
    }


    public HelperPage getHp() {return hp;}
    public TaxiPage getTx(){return tx;}
    public NotesPage getNp(){return np;}
    public WebsiteCallRequests getWcr(){return wcr;}
    public Webinars getWb(){return wb;}

}
