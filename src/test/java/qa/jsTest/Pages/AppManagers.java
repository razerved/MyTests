package qa.jsTest.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
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
    public IntersShop is;
    public Datebook db;
    public ParrotPage pp;
    public ChromeOptions options;
    public String browser;

    public AppManagers(WebDriver wd,
                       WebDriverWait wait,
                       TaxiPage tx,
                       NotesPage np,
                       WebsiteCallRequests wcr,
                       Webinars wb,
                       IntersShop is,
                       Datebook db,
                       ParrotPage pp) {
        this.wait = wait;
        this.wd = wd;
        this.tx = tx;
        this.np = np;
        this.wcr = wcr;
        this.wb = wb;
        this.is = is;
        this.db = db;
        this.pp = pp;
        this.options = options;
    }
    public AppManagers(){}
    public AppManagers(String browser){
        this.browser = browser;
    }

    public void init() {
       /* if(browser.equals("CHROME")){
            wd = new ChromeDriver(options);
        }else if(browser.equals("EDGE")){
            wd = new EdgeDriver();
        }else if(browser.equals("FIREFOX")){
            wd = new FirefoxDriver();
        }*/

        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        wd = new ChromeDriver(options);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        hp = new HelperPage(wd,wait);
        tx = new TaxiPage(wd, wait);
        np = new NotesPage(wd,wait);
        wcr = new WebsiteCallRequests(wd, wait);
        wb = new Webinars(wd, wait);
        is = new IntersShop(wd, wait);
        db = new Datebook(wd,wait);
        pp = new ParrotPage(wd, wait);

        /*SSLEngine request = null;
        HttpSession session= (HttpSession) request.getSession();
        session.setMaxInactiveInterval(604800);
        session.setAttribute("loggedOnUser", true);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(Integer.MAX_VALUE);
        HttpServletResponse response = null;
        response.addCookie(cookie);*/
    }

    public void init_whit_no_LoadPage(){
        System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        wd = new ChromeDriver(options);

        hp = new HelperPage(wd,wait);
        tx = new TaxiPage(wd, wait);
        np = new NotesPage(wd,wait);
        wcr = new WebsiteCallRequests(wd, wait);
        wb = new Webinars(wd, wait);
        is = new IntersShop(wd, wait);
        db = new Datebook(wd,wait);
        pp = new ParrotPage(wd, wait);
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

    public void outForAppNew() throws IOException {
        File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("F:\\screenShotForTest\\screenshot.png"));
        wd.quit();
    }


    public HelperPage getHp() {return hp;}
    public TaxiPage getTx(){return tx;}
    public NotesPage getNp(){return np;}
    public WebsiteCallRequests getWcr(){return wcr;}
    public Webinars getWb(){return wb;}
    public IntersShop getIs(){return is;}
    public Datebook getDb(){return db;}
    public ParrotPage getPp(){return pp;}

}
