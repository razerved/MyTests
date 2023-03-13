package qa.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecification requestSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .build();
    }


    public static ResponseSpecification responseStatusSpec(int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    /*public static ResponseSpecification responsStat(){

    }*/


    public static void installSpecification(RequestSpecification requestSpec, ResponseSpecification responseSpec){
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }




}
