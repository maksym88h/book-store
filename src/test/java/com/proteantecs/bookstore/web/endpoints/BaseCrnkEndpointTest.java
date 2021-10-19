package com.proteantecs.bookstore.web.endpoints;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.proteantecs.bookstore.BookStoreApplication;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.http.HttpStatus.*;

@DirtiesContext
@SpringBootTest(
        classes = BookStoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class BaseCrnkEndpointTest {

    @LocalServerPort
    private int port;
    private String url;
    private int idMock;
    private String objectCreateJsonApi;

    protected void init(String url, String objectCreateJsonApi, String objectUpdateJsonApi) throws IOException {
        RestAssured.port = port;
        this.url = url;
        this.objectCreateJsonApi = objectCreateJsonApi;
        idMock = createMock(objectCreateJsonApi);
    }

    protected void findOneObject() throws IOException {
        RestAssured
                .given()
                .contentType("application/json")
                .when()
                .get(url + idMock)
                .then()
                .assertThat()
                .statusCode(OK.value());
        deleteMock(idMock);
    }

    protected void saveObject() throws IOException {
        final Response response = RestAssured
                .given()
                .contentType("application/vnd.api+json")
                .accept("application/vnd.api+json")
                .body(loadFileFromResources(objectCreateJsonApi))
                .when()
                .patch(url + idMock)
                .then()
                .extract()
                .response();
        Assertions.assertEquals(200, response.statusCode());
        deleteMock(idMock);
    }

    protected void findAllObject() throws IOException {
        final ValidatableResponse response = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
        deleteMock(idMock);
    }

    protected void deleteObject() {
        Assertions.assertEquals(deleteMock(idMock), true);
    }

    protected void createObject() throws IOException {
        Assertions.assertNotNull(idMock);
        deleteMock(idMock);
    }

    private int createMock(String schemaJsonRequest) throws IOException {
        final Response response = RestAssured
                .given()
                .contentType("application/vnd.api+json")
                .accept("application/vnd.api+json")
                .body(loadFileFromResources(schemaJsonRequest))
                .when()
                .post(url)
                .then()
                .extract()
                .response();
        return Integer.parseInt(response.jsonPath().getString("data.id"));
    }

    private boolean deleteMock(Integer id) {
        final Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .when()
                .delete(url + id)
                .then()
                .extract()
                .response();
        return response.statusCode() == 204;
    }

    private static String loadFileFromResources(String filename) throws IOException {
        InputStream inputStream = com.proteantecs.bookstore.BookStoreApplicationTests.class
                .getClassLoader()
                .getResourceAsStream("rest-assured/" + filename);
        return IOUtils.toString(inputStream);
    }
}