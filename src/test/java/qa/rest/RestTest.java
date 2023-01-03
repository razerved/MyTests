package qa.rest;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class RestTest {

    String testUrl = "https://reqres.in/";

    @Test
    public void firstRest(){
        List<Root> name = given()
                .contentType(ContentType.JSON)
                .when()
                .get(testUrl + "api/users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Root.class);

        List<String> names = name.stream().map(Root::getFirst_name).collect(Collectors.toList());
        for(int i = 0; i< name.size(); i++){
            System.out.println(names.get(0));
            break;
        }


    }

    @Test
    public void secondRest(){

    }


}
