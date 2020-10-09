package common;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpecBuilderTest {
    ResponseSpecification responseSpc;

    @BeforeClass
    public void setup() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectHeader("Content-Type", "application/json; charset=utf-8");
        builder.expectHeader("Cache-Control", "public, max-age=14400");
        responseSpc = builder.build();
    }

    @Test
    public void test1() {
        when().
                get("http://jsonplaceholder.typicode.com/posts?userId=2").
                then().
                spec(responseSpc).
                time(lessThan(3000L));
    }


}
