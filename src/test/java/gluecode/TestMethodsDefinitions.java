package gluecode;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TestMethodsDefinitions {

    public static Response getLatestExchangeRates(String path) {
        return  when()
                .get(path)
                .then().using().extract().response();
    }
}
