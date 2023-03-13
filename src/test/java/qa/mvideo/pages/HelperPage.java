package qa.mvideo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class HelperPage {

    public void goodHelperPage(){

        System.out.println("hi HelperPage!");
    }

    public String getHelp(String word){
        return word;
    }





    public String setHelper(String word){
        return word;
    }

    public void click(SelenideElement elem){
        elem.click();
    }



    public String randomPhone(){
        Random rnd = new Random();
        char[] rndChars = {'6','3','1','0','8','7','5'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++){
            char n = (char) rnd.nextInt(7);
            sb.append(rndChars[n]);
        }
        return sb.toString();
    }





}
