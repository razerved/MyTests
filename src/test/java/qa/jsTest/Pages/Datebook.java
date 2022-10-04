package qa.jsTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class Datebook extends HelperPage {

    public Datebook(WebDriver wd, WebDriverWait wait) {
    super(wd, wait);
    }

    @FindBy(css = ".baseButtonAdd.pageCreate__baseButtonAdd")
    public WebElement buttonCreateNote;

    @FindBy(css = ".popup__header")
    public WebElement windowNewNote;

    @FindBy(css = ".popup__baseInput>input.baseInput__field")
    public WebElement setNewHeader;

    @FindBy(css = ".popup__textarea .baseTextarea__text")
    public WebElement setNewText;

    @FindBy(css = "button.baseButton.popup__baseButton")
    public WebElement buttonAddNote;

    @FindBy(css = ".articlePreview.pageCreate__articlePreview")
    public WebElement allNotes;

    @FindBy(css = ".articlePreview.pageCreate__articlePreview:last-of-type")
    public WebElement defaultNotes;


    public void scrollNotesSection(){
        new Actions(wd)
                .moveToElement(defaultNotes)
                .perform();
    }

    public By getNotes(int index){
        return By.cssSelector(String.format
                (".articlePreview.pageCreate__articlePreview:nth-of-type(%d)", index));
    }

    public By getDeleteNote(int index){
        return By.cssSelector(String.format
                (".articlePreview.pageCreate__articlePreview:nth-of-type(%d)" +
                        " .articlePreview__button:last-of-type", index));
    }

    public void deleteNotes(int index){
        var noteLocator = getNotes(index);
        new Actions(wd)
                .moveToElement(wd.findElement(noteLocator))
                .perform();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getDeleteNote(index)));
        wd.findElement(getDeleteNote(index)).click();
    }

    public boolean isNoteDisplayed(int index){
        var note = getNotes(index);
        var element = wd.findElement(note);
        return element.isDisplayed();
    }

    public void addRandomNotes(int count){
        for (int i = 0; i < count; i++ ){
            buttonCreateNote.click();
            wait.until(ExpectedConditions.visibilityOf(windowNewNote));
            setNewHeader.sendKeys(Integer.toString(i));
            setNewText.sendKeys(UUID.randomUUID().toString());
            buttonAddNote.click();
        }
    }

}


/**
 * добавьте 10 новых записей;
 * после этого наведите курсор на самую верхнюю запись и удалите её;
 * проскролльте в разделе «Все записи» до самого низа;
 * проверьте, что первые две записи, которые изначально были на странице,
 * по-прежнему присутствуют и отображаются.
 */