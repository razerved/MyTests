package qa.onlineMovie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    private WebDriver driver;




    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String urlAuth = "https://lm.skillbox.cc/qa_tester/module06/auth/index.html";



    //Field=============================================================================================================



    //Method============================================================================================================

}

