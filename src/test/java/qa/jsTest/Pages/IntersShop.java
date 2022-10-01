package qa.jsTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntersShop extends HelperPage{

    public IntersShop(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    @FindBy(css = ".menu>li:nth-of-type(2)")
    public WebElement catalog;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(text(), 'Электроника')]")
    public WebElement sectionElectronics;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'phones')]")
    public WebElement partitionPhones;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'pad')]")
    public WebElement partitionPad;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'tv')]")
    public WebElement partitionTelevision;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'photo_video')]")
    public WebElement partitionPhotoVideo;

    @FindBy(xpath = "//ul[@class='sub-menu']//a[contains(@href, 'watch')]")
    public WebElement partitionWatch;


    public void moveToCatalog(){
        new Actions(wd)
                .moveToElement(catalog)
                .perform();
    }
    public void selectPartition(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(sectionElectronics));
        var highlight = new Actions(wd)
                .moveToElement(element);
                highlight.perform();
    }
    public void chooseSection(WebElement element){
        element.click();
    }





    public void tes2(){

    }


}
/**
 * Напишите пять тестов, проверяющих осуществление перехода на другую страницу из меню,
 * для сайта интернет-магазина Intershop. В каждом тесте:
 * наведите курсор на пункт меню «Каталог»;
 * затем переместите курсор на подпункт «Электроника»;
 * кликните на одном из появившихся подпунктов;
 * проверьте, что осуществился переход на раздел с названием выбранного подпункта.
 * В итоге получится пять тестов и пять подпунктов: ТЕЛЕФОНЫ, ПЛАНШЕТЫ, ТЕЛЕВИЗОРЫ, ФОТО/ВИДЕО, ЧАСЫ.
 */