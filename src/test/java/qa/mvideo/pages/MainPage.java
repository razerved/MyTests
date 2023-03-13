package qa.mvideo.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

/**
 * Главная страница сайта МВидео.
 */
public class MainPage extends HelperPage {


    public MainPage(String url){
        Selenide.open(url);
    }

    public MainPage() {
    }

    private SelenideElement search = $x("");
    private ElementsCollection searchs = $$x("//aww"); //коллекция
    private SelenideElement pak = $("");
    private ElementsCollection paks = $$(""); //коллекция
    private SelenideElement searchLine = $("input");
    //для взаимодействия с елементами требуется всегда вызывать метод

    private SelenideElement account = $x("//a[@class='link'] [contains(@href, 'my-account')]");
    private SelenideElement registerForm = $x("//form[@class='login-form ng-untouched ng-pristine ng-valid']");
    private SelenideElement inputPhone = $x("//input[@type='tel']");



    public void clickAccount(){
        click(account);
    }
    public void authRise(){
        clickAccount();
        enterRul();
    }


    public void enterRul(){
        registerForm.should();
        inputPhone.pressEnter().setValue("9778770101");
    }

    public void enterRndPhone(){
        String firsNumber = "977";
        clickAccount();
        registerForm.should();
        inputPhone.pressEnter().setValue(firsNumber + randomPhone());
    }

    public void setSearchLineText(String text){
        searchLine.setValue(text).pressEnter();
    }


    public void goodMain(){
        System.out.println("hi Main!");
    }

    public String getMain(String word){
        return word;
    }

    public String setMain(String word){
        return word;
    }

    public HelperPage text(){

        return new HelperPage();
    }
    public ResultSearchPage some(){
        return new ResultSearchPage();
    }

    public void openWebsite(String URL){
        Selenide.open(URL);
    }


}
