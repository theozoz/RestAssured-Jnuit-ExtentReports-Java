package org.ozcanarpaci.base;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.ozcanarpaci.base.BaseConstants.BASE_URL;

public class HttpClient {

    public static Response get(String path) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response get(String path, Map<String, ?> query) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .queryParams(query)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response get(String path, Header header) {

        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response post(Object body, String path) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response patch(String path, String body) {

        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .patch(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response delete(String path, Object body) {

        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .delete(path)
                .then()
                .log().body()
                .extract().response();
    }
}
