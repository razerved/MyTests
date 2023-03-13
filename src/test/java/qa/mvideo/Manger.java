package qa.mvideo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import qa.mvideo.pages.HelperPage;
import qa.mvideo.pages.MainPage;

abstract public class Manger {

    //public HelperPage hp;

    public void setUp(){
        WebDriverManager.chromedriver().setup(); //скачивает драйвер и производит настройку
        Configuration.browser = "chrome"; // указываем тип браузера, Mozilla = "geckodriver"
        Configuration.driverManagerEnabled = true; //утверждение настройки Селенида
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; //видим открытие сайта или нет (для jenkins)

        //hp = new HelperPage();
    }

    /*public HelperPage getHp() {
        return hp;
    }*/



    @Before
    public void init(){
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}
