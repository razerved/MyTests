package qa.onlineInstitute.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends GroupHelper {


    public PaymentPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(css = "pagePayment__card")
    public WebElement formPay;

    @FindBy(css = "input[name='cardname']")
    public WebElement cardEntryForm;

    @FindBy(css = "input[name='carddate']")
    public WebElement inputCardDate;

    @FindBy(css = "input[name='cardcvc']")
    public WebElement inputCVCCode;

    @FindBy(css = "div[class='pagePayment__text'] span.pagePayment__description")
    public WebElement bills;

    @FindBy(css = "button.pagePayment__button")
    public WebElement buttonPayment;

    public void setNumberCard(String cardNumber) throws Throwable {
        //System.out.println(cardNumber.length());// print  card length
        for (int i = 0; i < cardNumber.length(); i++) {
            char c = cardNumber.charAt(i);
            String s = new StringBuilder().append(c).toString();
            cardEntryForm.sendKeys(s);
        }
    }

    public void setCardDate(String cardDate) throws  Throwable{
        for (int i = 0; i > cardDate.length(); i++){
            char c = cardDate.charAt(i);
            String s = new StringBuilder().append(c).toString();
            inputCardDate.sendKeys(cardDate);
        }

        inputCardDate.sendKeys(cardDate);
    }
    public void setCVCCode(String cvcCode) throws Throwable{
        for (int i = 0; i < cvcCode.length(); i++){
            char c = cvcCode.charAt(i);
            String s = new StringBuilder().append(c).toString();
            inputCVCCode.sendKeys(cvcCode);
        }
    }





}
