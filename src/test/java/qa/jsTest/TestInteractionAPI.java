package qa.jsTest;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class TestInteractionAPI extends TestBase {


        private static Stream<Arguments> partition(){
            return Stream.of(Arguments.arguments(
                    "http://intershop5.skillbox.ru/product-category/catalog/electronics/phones/",
                    "http://intershop5.skillbox.ru/product-category/catalog/electronics/pad/",
                    "http://intershop5.skillbox.ru/product-category/catalog/electronics/tv/",
                    "http://intershop5.skillbox.ru/product-category/catalog/electronics/photo_video/",
                    "http://intershop5.skillbox.ru/product-category/catalog/electronics/watch/"
                    )
            );
        }
        @ParameterizedTest
        @MethodSource("partition")
        @DisplayName("Move_button_electronics")
        public void test1(String phonePage, String padPage, String televisionPage,
                          String photoAndVideoPage, String watchPage) throws InterruptedException {
            //arrange
            app.getHp().openIntersShop();
            //action
            app.getIs().moveToCatalog(); //конечно можно уменьшить не дублирую код
            app.getIs().selectPartition(app.getIs().sectionElectronics);
            app.getIs().chooseSection(app.getIs().partitionPhones);
            String actualPhone = app.getIs().getCurrentURL();
            //app.wait.until(elem -> app.getIs().sectionElectronics.isDisplayed());
            app.getIs().moveToCatalog();
            app.getIs().selectPartition(app.getIs().sectionElectronics);
            app.getIs().chooseSection(app.getIs().partitionPad);
            String actualPadPage = app.getIs().getCurrentURL();
            app.getIs().moveToCatalog();
            app.getIs().selectPartition(app.getIs().sectionElectronics);
            app.getIs().chooseSection(app.getIs().partitionTelevision);
            String actualTelevisionPage = app.getIs().getCurrentURL();
            app.getIs().moveToCatalog();
            app.getIs().selectPartition(app.getIs().sectionElectronics);
            app.getIs().chooseSection(app.getIs().partitionPhotoVideo);
            String actualPhotoAndVideoPage = app.getIs().getCurrentURL();
            app.getIs().moveToCatalog();
            app.getIs().selectPartition(app.getIs().sectionElectronics);
            app.getIs().chooseSection(app.getIs().partitionWatch);
            String actualWatchPage = app.getIs().getCurrentURL();
            //assert
            Assertions.assertAll(
                    ()-> Assert.assertEquals("URL телефонов различаются",phonePage,actualPhone),
                    ()-> Assert.assertEquals("URL Планшетов различаются",padPage, actualPadPage),
                    ()-> Assert.assertEquals("URL телевизовор различаются",televisionPage,actualTelevisionPage),
                    ()-> Assert.assertEquals("URL фото и видео различаются",photoAndVideoPage, actualPhotoAndVideoPage),
                    ()-> Assert.assertEquals("URL часов различаются",watchPage,actualWatchPage)
            );
        }


        @Test
        @DisplayName("")
        public void test2(){
            //
            app.getHp().openIntersShop();
            //

            //


        }








}
