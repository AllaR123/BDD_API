package com.bdd_api.step_defitions;

import com.bdd_api.resources.TestDataBuild;
import com.bdd_api.resources.Utils;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import org.junit.Assert;
import pojo.*;


public class placeValidationStepDeff extends Utils {

    TestDataBuild data = new TestDataBuild();


    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;


    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {

        res=given().spec(requestSpecification())
                .body(data.addPlacePayLoad(name, language, address));

    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {

        resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        response =res.when().post("/maps/api/place/add/json").
                then().spec(resspec).extract().response();

    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String ExpectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        Assert.assertEquals(js.get(keyValue).toString(), ExpectedValue);

    }

}
