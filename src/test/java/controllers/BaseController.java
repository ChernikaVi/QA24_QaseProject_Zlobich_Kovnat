package controllers;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import utils.PropertyReader;
import static io.restassured.RestAssured.given;



public class BaseController {
    public static final String TOKEN = PropertyReader.getProperty("token");
    public static final String BASE_URL = PropertyReader.getProperty("base_api_url");
    Gson converter = new Gson();


    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = given()
                .header("TOKEN", TOKEN)
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
