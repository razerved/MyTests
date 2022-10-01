package qa.jsTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datebook extends HelperPage {

    public Datebook(WebDriver wd, WebDriverWait wait) {
    super(wd, wait);
    }

    @FindBy(css = ".baseButtonAdd.pageCreate__baseButtonAdd")
    public WebElement buttonEnterNewNote;

    @FindBy(css = ".popup__header")
    public WebElement windowNewNote;

    @FindBy(css = ".popup__baseInput>input.baseInput__field")
    public WebElement newHeader;

    @FindBy(css = ".popup__textarea>div.baseTextarea__inner")
    public WebElement textArea;

    @FindBy(css = "button.baseButton.popup__baseButton")
    public WebElement buttonCreateNote;







}


/**
 * добавьте 10 новых записей;
 * после этого наведите курсор на самую верхнюю запись и удалите её;
 * проскролльте в разделе «Все записи» до самого низа;
 * проверьте, что первые две записи, которые изначально были на странице,
 * по-прежнему присутствуют и отображаются.
 */