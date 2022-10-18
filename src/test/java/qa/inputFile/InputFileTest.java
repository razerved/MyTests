package qa.inputFile;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qa.inputFile.page.MainPageInputFile;

import java.io.IOException;

public class InputFileTest {

    MainPageInputFile mainPageInrutFile = new MainPageInputFile();

    @BeforeEach
    private void setur(){
        mainPageInrutFile.initin();
    }



    @Test
    public void test1(){
        mainPageInrutFile.openSite();
        mainPageInrutFile.openDisplayedElementAndPutFile();
        Assert.assertTrue("Don't saw green", mainPageInrutFile.greenCheckBox.isDisplayed());

    }


    @AfterEach
    private void down() throws IOException {
        mainPageInrutFile.out();
    }




}
