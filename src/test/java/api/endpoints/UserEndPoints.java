package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.endpoints.Routes.put_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class UserEndPoints {

    //User Module
    //This method is to create user
    public static Response createUser(User payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(payload)
                .when()
                .post(Routes.post_URL);
        return response;
    }

    public static Response readUser(String Username)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",Username)
                .when()
                .get(Routes.get_URL);
        return response;
    }

    public static Response updateUser(String Username,User payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",Username)
                .body(payload)
                .when()
                .put(Routes.put_URL);
        return response;
    }

    public static Response deleteUser(String Username)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",Username)
                .when()
                .delete(Routes.delete_URL);
        return response;
    }
}
