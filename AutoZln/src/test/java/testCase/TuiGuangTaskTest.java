package testCase;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

import io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static base.TestBase.testUtils;

public class TuiGuangTaskTest extends TestBase {

    @Test(timeOut = 5000, description = "查看任务列表，断言是否存在赵林楠的数据")
    public void test01_list() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isDesc", 0);
        map.put("orderField", "12");
        map.put("pageNo", 1);
        map.put("pageSize", 20);
        res = req.when().body(map).post("ktask/data/mall/ktask/task/query/my");
//        res.then().assertThat().body(get);
//        jp = getJsonPath(res);
//        testUtils.printAllResponseText(res);
        res.then().body("result.bizUserName[0]", is("赵林楠"));
//        res.then().body("result.bizUserName[0]", equalsTo("赵林楠"));

    }

}