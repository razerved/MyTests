package qa.mvideo;

import org.junit.Test;
import qa.mvideo.pages.MainPage;


public class TestMVideoSite extends Manger {

    private final static String baseURL = "https://www.mvideo.ru/";
    MainPage mn = new MainPage();


    @Test
    public void firstTest(){
        mn.openWebsite(baseURL);

        new MainPage().goodHelperPage();
        mn.goodHelperPage();
        System.out.println(mn.getMain(mn.setHelper("new helper")));

        new MainPage().goodMain();
        mn.goodMain();
    }

    @Test
    public void second(){
        new MainPage().openWebsite(baseURL);
    }

    @Test
    public void testSerch(){
        mn.openWebsite(baseURL);
        mn.setSearchLineText("Телефоны");
        String text = mn.some().returnText();
        int i = 0;
    }

    @Test
    public void testAuth(){
        mn.openWebsite(baseURL);
        mn.authRise();

        int x = 1;

    }

    @Test
    public void testRandomNumber(){
        mn.openWebsite(baseURL);
        mn.enterRndPhone();

        int x = 1;
    }


}
