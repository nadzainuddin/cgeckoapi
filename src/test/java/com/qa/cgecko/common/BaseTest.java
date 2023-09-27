package com.qa.cgecko.common;

import com.qa.cgecko.constants.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.codec.binary.Base64;

public class BaseTest {
    Base64 base64 = new Base64();

    public RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .setBaseUri(Endpoints.BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    public RequestSpecification requestSpecBuilderWithToken() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
//                .addCookie("token", getToken())
                .setBaseUri(Endpoints.BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    public RequestSpecification requestSpecBuilderWithAuth() {
        String username = "admin";
        String password = "password123";
        String encodedString = new String(base64.encode((username+":"+password).getBytes()));
        return new RequestSpecBuilder()
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .addHeader("Authorization", "Basic " + encodedString)
                .setBaseUri(Endpoints.BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }

    public ResponseSpecification responseSpecBuilder(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

//    public String getToken() {
//        JSONObject credentials = new JSONObject();
//        credentials.put("password", "password123");
//        credentials.put("username", "admin");
//        return RestAssured.given()
//                .spec(requestSpecBuilder())
//                .body(credentials.toString())
//                .when()
//                .post(Endpoints.AUTH)
//                .then()
//                .log().ifError()
//                .assertThat().statusCode(200)
//                .extract().response().jsonPath().get("token").toString();
//    }
}
