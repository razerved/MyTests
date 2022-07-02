package qa.technic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckTimeTest extends TestBase {


    @Test
    @DisplayName("Первая проверка")
    public void test1(){
        String sec = app.getSf().getTimeSelect();
    }

}
