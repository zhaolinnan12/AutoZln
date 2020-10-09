package common;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.net.URL;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class RunTestCase {
    public static Response httpSendPost(String addess, HashMap<String, Object> map) throws Exception {
        String msg = null;
        URL url = new URL(addess);
        Response response = given().log().all().
                header("accept", "application/json").
                header("token", "efb80642399c4241bacd24489989d3ad").
                contentType("application/json").
                body(map).
                then().
                when().
                post(url);
        response.getBody().prettyPrint();

        return response;
    }

    public static ValidatableResponse sendgetWithHttp(String addess, String str) throws Exception {
        URL url = new URL(addess);
        ValidatableResponse response = given()
                .log().all()
                .queryParam(str)
                .when()
                .get(addess)
                .then()
                .log().all();
        return response;
    }

    public static Response sendpostWithHttps(String addess, String str) throws Exception {
        URL url = new URL(addess);
        useRelaxedHTTPSValidation();
        Response response = given().log().all().
                header("accept", "application/json").
                contentType("application/json").
                body(str).
                then().
                statusCode(200).
                when().
                post(url);
        response.getBody().prettyPrint();
        return response;
    }

    public static ValidatableResponse sendgetWithHttps(String addess, String str) throws Exception {
        URL url = new URL(addess);
        useRelaxedHTTPSValidation();
        ValidatableResponse response = given()
                .log().all()
                .queryParam(str)
                .when()
                .get(addess)
                .then()
                .log().all()
                .statusCode(200);
        return response;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map1 = new HashMap<>();

        map1.put("isDesc", 0);
        map1.put("orderField", 12);
        map1.put("pageNo", 1);
        map1.put("pageSize", 20);
        httpSendPost("http://www.layercake.com.cn/ktask/data/mall/ktask/task/query/my", map1);
    }
}
