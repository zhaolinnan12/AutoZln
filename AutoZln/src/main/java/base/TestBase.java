package base;

import java.util.ResourceBundle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GetToken;
import utils.TestUtils;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static RequestSpecification httpRequest;
    public static Response response;
    public Logger logger;

    public static String serverHost;
    public static String port;
    public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    public static TestUtils testUtils = new TestUtils();
    public RequestSpecification req;

    static {
        // 用于加载properties文件
        // 注意这里不需要文件扩展名.properties
        ResourceBundle rb = ResourceBundle.getBundle("config");
        serverHost = rb.getString("Host");
        port = rb.getString("Port");
    }

    @BeforeClass
    public void setup() {
        String className = this.getClass().getName();
        logger = Logger.getLogger(className);
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.setLevel(Level.DEBUG);
        setBaseURI(); //设置Base URI
//        setBasePath();
//      setContentType(ContentType.JSON); //设置Content Type
        String token = GetToken.Token();
        req = RestAssured.given().header(new Header("token", token)).contentType(ContentType.JSON).log().all();


    }

    @AfterClass
    public void afterTest() {
        resetBaseURI();
        resetBasePath();
    }

    //设置 base URI
    public static void setBaseURI() {
//        if("80".equals(port)) {
//            RestAssured.baseURI = serverHost;
//        }else {
//            RestAssured.baseURI = serverHost+":"+port;
//        }
        RestAssured.baseURI = serverHost;
        //System.out.println(RestAssured.baseURI);
    }

    //设置base path
    public static void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    //执行完测试后重置 Base URI
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //执行完测试后重置 base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    //返回 JsonPath对象
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }


}