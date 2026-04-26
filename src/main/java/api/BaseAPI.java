package api;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    public BaseAPI() {
        RestAssured.baseURI = ConfigManager.get("api.base.url");

        requestSpec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType("application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType("application/json")
                .build();
    }

    protected io.restassured.response.Response get(String endpoint) {
        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .spec(responseSpec)
                .extract().response();
    }

    protected io.restassured.response.Response post(String endpoint, Object body) {
        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(responseSpec)
                .extract().response();
    }

    protected io.restassured.response.Response put(String endpoint, Object body) {
        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .spec(responseSpec)
                .extract().response();
    }

    protected io.restassured.response.Response delete(String endpoint) {
        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .spec(responseSpec)
                .extract().response();
    }
}