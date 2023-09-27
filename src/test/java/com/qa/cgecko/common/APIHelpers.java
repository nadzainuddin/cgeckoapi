package com.qa.cgecko.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIHelpers extends BaseTest {
    public static JsonPath GET(RequestSpecification requestSpecification, String uri, int status) {
        return given().spec(requestSpecification)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    public static JsonPath GETPathParam(RequestSpecification requestSpecification, String uri, String pathParam, int status) {
        return given().spec(requestSpecification)
                .when()
                .get(uri, pathParam)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    public static JsonPath GETQueryParam(RequestSpecification requestSpecification, String field, String value,
                                         String uri, int status) {
        return given().spec(requestSpecification)
                .queryParam(field, value)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    static Response GETQueryParamResp(RequestSpecification requestSpecification, String field, String value,
                                      String uri, int status) {
        return given().spec(requestSpecification)
                .queryParam(field, value)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response();
    }

    static JsonPath GETQueryParam(RequestSpecification requestSpecification, String field, double value,
                                  String uri, int status) {
        return given().spec(requestSpecification)
                .queryParam(field, value)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    static JsonPath GETQueryParam(RequestSpecification requestSpecification, String field, boolean value,
                                  String uri, int status) {
        return given().spec(requestSpecification)
                .queryParam(field, value)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    public static JsonPath GETQueryParams(RequestSpecification requestSpecification, Map<String, Object> map,
                                          String uri, int status) {
        return given().spec(requestSpecification)
                .queryParams(map)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    public static ResponseBody GETQueryParamsStr(RequestSpecification requestSpecification, Map<String, Object> map,
                                                 String uri, int status) {
        return given().spec(requestSpecification)
                .queryParams(map)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().body();
    }

    public static String GETFieldValue(RequestSpecification requestSpecification, String uri, String fieldname,
                                       int bookingId, int status) {
        return given().spec(requestSpecification)
                .when()
                .get(uri, bookingId)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath().get(fieldname);
    }

    static void GETWithPathParam(RequestSpecification requestSpecification, String uri, int pathParam, int status) {
        given().spec(requestSpecification)
                .when()
                .get(uri, pathParam)
                .then()
                .log().ifError()
                .assertThat().statusCode(status);
    }

//    static Booking GETBookingDetails(RequestSpecification requestSpecification, String uri, int pathParam,
//                                     int status) {
//        return given().spec(requestSpecification)
//                .when()
//                .get(uri, pathParam)
//                .then()
//                .log().ifError()
//                .assertThat().statusCode(status)
//                .extract().jsonPath().getObject("", Booking.class);
//    }

    static List<Integer> GETIntValues(RequestSpecification requestSpecification, String token,
                                      String uri, int status, String fieldname) {
        return given().spec(requestSpecification)
                .cookie("token", token)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().jsonPath().getList(fieldname);
    }

    static JsonPath POSTWithBodyReq(RequestSpecification requestSpecification, Object object,
                                    String uri, int status) throws JsonProcessingException {
        return given().spec(requestSpecification)
                .body(Utils.convertObj(object))
                .when()
                .post(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    static void POSTBodyReq(RequestSpecification requestSpecification, Map<String, Object> bodyReq,
                            String uri, int status) throws JsonProcessingException {
        given().spec(requestSpecification)
                .body(bodyReq)
                .when()
                .post(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status);
    }

//    static BookingResponse POSTBodyReq(RequestSpecification requestSpecification, Booking booking,
//                                       String uri, int status) throws JsonProcessingException {
//        return given().spec(requestSpecification)
//                .body(Utils.convertObj(booking))
//                .when()
//                .post(uri)
//                .then()
//                .log().ifError()
//                .assertThat().statusCode(status)
//                .extract().jsonPath().getObject("", BookingResponse.class);
//    }



    static JsonPath PATCH(RequestSpecification requestSpecification, Map<String, Object> req, String uri,
                          int pathParam, int status) {
        return given().spec(requestSpecification)
                .body(req)
                .when()
                .patch(uri, pathParam)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().jsonPath();
    }

    static void DELETEWithPathParam(RequestSpecification requestSpecification, String uri,
                                    int pathParam, int status) {
        given().spec(requestSpecification)
                .when()
                .delete(uri, pathParam)
                .then()
                .log().ifError()
                .assertThat().statusCode(status);
    }
}
