package gluecode;

import POJOClasses.responses.ExchangeRates;
import POJOClasses.responses.Rates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class TestStepsDefinitions {

    private final String BASE_URI = "https://api.ratesapi.io/";
    private final String BASE_PATH = "api/";
    private Response response;
    private ResponseBody body;
    private ExchangeRates exchangeRates;
    private Map<String, Float> ratesMap;

    @Given("^I want to ask Rates API webservice for the .* Foreign Exchange rates$")
    public void exchangeRatesEndpoint() throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
    }

    @When("^I submit the GET request for a provided (.*) endpoint$")
    public void sendLatestRatesGetRequest(String path) throws Throwable {
        response = TestMethodsDefinitions.getLatestExchangeRates(path);
    }

    @Then("^I should get (.*) Status Code$")
    public void validateStatusCode(int statusCode) throws Throwable {
        int actualCode = response.getStatusCode();
        //Logging the respone's status line
        response.then().log().status();
        Assert.assertEquals(actualCode, statusCode);
    }

    @Then("^I should receive valid response .*with the exchange rates$")
    public void validateResponse() throws Throwable {
        body = response.getBody();
        //Logging the response's body
        response.then().log().body();

        exchangeRates = response.getBody().as(ExchangeRates.class);
        ratesMap = response.getBody().jsonPath().getMap("rates");

        for (Float value : ratesMap.values())
            Assert.assertNotNull(value);

        Assert.assertNotNull(exchangeRates.getBase());
        Assert.assertNotNull(exchangeRates.getDate());
        Assert.assertNotNull(body, "The response has values");
    }

    @Then("I should get the response with values applicable to current date")
    public void validateResponseWithDate() throws Throwable {
        body = response.getBody();
        //Logging the response's body
        response.then().log().body();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String currentDate = dtf.format(now);
        Assert.assertEquals(body.jsonPath().get("date"), currentDate);
    }
}
