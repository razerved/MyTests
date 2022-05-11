package qa.onlineInstitute;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import qa.onlineInstitute.page.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp(){
        app.init();

    }


    @AfterEach
    public void tearDown() throws IOException {
        app.stop();
    }


}

/*
 * В одном из тестов добавьте в «Отложенные курсы» два курса и с помощью assertAll
 * проверьте заголовки добавленных курсов. Они должны быть разными и равными заголовкам курсов,
 * которые были добавлены.
 * В другом тесте осуществите клик по кнопке «К списку курсов»
 * из пустого раздела «Отложенные курсы». Перед проверкой используйте
 * явное ожидание появления  восьми элементов-карточек с курсами.
 * Создайте параметризированный тест (@ParametrizedTest), в котором бы вы добавляли один курс,
 * а затем проверяли все его параметры в личном кабинете в разделе «Отложенные курсы».
 * Для каждого из восьми курсов ― свои параметры.
 */