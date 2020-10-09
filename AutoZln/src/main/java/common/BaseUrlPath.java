package common;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseUrlPath {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        RestAssured.port = 80;
        RestAssured.basePath = "/posts";

    }

    @Test
    public void test1() {
        given().get("/1").then().statusCode(200).log().all();

    }

    @Test
    public void test2() {
        given().get("/1/comments").then().statusCode(200).log().body();
    }

    @Test
    public void test3() {
        given().get("?userId=1").then().statusCode(200).log().headers();
    }

}
