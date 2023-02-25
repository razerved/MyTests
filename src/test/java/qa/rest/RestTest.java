package qa.rest;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class RestTest {

    String testUrl = "https://reqres.in/";

    @Test
    public void firstRest(){
        List<Data> users = given()
                .contentType(ContentType.JSON)
                .when()
                .get(testUrl + "api/users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Data.class);

        List<String> ava = users.stream().map(Data::getAvatar).collect(Collectors.toList());
        /*for(int i = 0; i< users.size(); i++){
            System.out.println(names.get(0));
            break;
        }*/
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for(int i = 0; i< ava.size(); i++){
            Assertions.assertTrue(ava.get(i).contains(ids.get(i)));

        }

    }

    @Test
    public void secondRest(){
        List<Data> name = given()
                .contentType(ContentType.JSON)
                .when()
                .get(testUrl + "api/users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Data.class);

        //List<String> page = name.stream().map(Root::getPage).collect(Collectors.toList());
        System.out.println("This is name" + name);
        int i = 0;
    }

    @Test
    public void thirdTest(){
        Specification.installSpecification(Specification.requestSpec(testUrl), Specification.responseStatusSpec(200));
        List<Data> name = given()
                .when()
                .get("api/users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Data.class);

    }


    @Test
    public void fourTest(){
        Specification.installSpecification(Specification.requestSpec(testUrl), Specification.responseStatusSpec(200));
        Response responce = given()
            .get(testUrl + "api/users?page=2")
            .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .extract().response();
        JsonPath jsonPath = responce.jsonPath();

        List<String> emails = jsonPath.get("data.email");
    }

    /**
     * Почему не работает Specification на POST но работает на GET?
     */
    @Test
    public void fiveTest(){
        //Specification.installSpecification(Specification.requestSpec(testUrl), Specification.responseStatusSpec(201));
        String name  = "morpheus";
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        String job = "leader";
        //Root root = new Root(name, job);

        /*Map<String, String> map = new HashMap<>();
        map.put("email","eve.holt@reqres.in");
        map.put("password","pistol");
        given()
                .body(map)
                .when()
                .post("https://reqres.in/api/register")
                //.post("https://reqres.in/api/users")
                .then().log().all();*/

        Response responce = given()
                .contentType(ContentType.JSON)
                .body(name + job)
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .extract().response();
    }






}
