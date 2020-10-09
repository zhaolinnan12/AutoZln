package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

@Test
public class GetToken {
    private static String token;

    public static String Token() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("encryptType", 1);
        map.put("password", "H+v4rnlskZQqDzbpATgppqN3Z8fG9kh1gKJq2a70MhOx8anbq2pwybMGNYlTNBtz4MiC804UXFz5HJKMW1aAzxQeWG7Q3W4k7/KFKrsNPF7qMTYATFGaRsswVWoYt4aivBZQfGIemXoqayyFgUOlBeRvK3mV/5MeNIOzl0kwshQ=");
        map.put("systemType", 1);
        map.put("userName", "18557535933");
        map.put("way", 1);
        Response resp =
                given().log().all().header("Content-Type", "application/json")
                        .body(map)
                        .when().post("http://www.layercake.com.cn/sso/data/login/login")
                        .then().log().all().statusCode(200)
                        .extract().response();
        token = (resp.getBody().jsonPath().getString("result.token"));
        return token;
    }

    @Test
    public void testPataParametersType() {
        given().
                pathParam("section", "posts").
                pathParam("id", "3").
                when().
                get("http://jsonplaceholder.typicode.com/{section}/{id}").
                then().
                statusCode(200);

    }
}
