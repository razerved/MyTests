package qa.mvideo.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class ResultSearchPage {

    private ElementsCollection resultSerch = $$x("//a[@class='product-title__text product-title--clamp']");

    public String returnText(){
        return resultSerch.get(0).getText();
    }




}
