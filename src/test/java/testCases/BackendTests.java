package testCases;

import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BackendTests {

    //@BeforeSuite
    //RestAssured.baseUri = "http://localhost:8081";
    private String basePath = "http://localhost:8081";

    @Test
    public void retrieving_info_for_one_user() {

        given()
                .param("username", "dev")
                .when()
                .get("http://localhost:8081/waesheroes/api/v1/users/details")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(matchesJsonSchemaInClasspath("jsonSources/singleUserResponse.json"));
    }

    @Test
    public void retrieving_information_from_all_users() {

        given()
                .auth()
                .preemptive()
                .basic("admin", "hero")
                .when()
                .get("http://localhost:8081/waesheroes/api/v1/users/all")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void login() {

        given()
                .auth()
                .preemptive()
                .basic("tester", "maniac")
                .when()
                .get("http://localhost:8081/waesheroes/api/v1/users/access")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void signUp() {

        File signUp = new File("src/test/resources/jsonSources/signUpBody.json");

        given()
                .contentType("application/json")
                .body(signUp)
                .post("http://localhost:8081/waesheroes/api/v1/users")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    public void updateUser() {

        File update = new File("src/test/resources/jsonSources/updateUserBody.json");

        given()
                .auth()
                .preemptive()
                .basic("dev", "wizard")
                .contentType("application/json")
                .body(update)
                .put("http://localhost:8081/waesheroes/api/v1/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteUser() {

        File delete = new File("src/test/resources/jsonSources/deleteUserBody.json");

        given()
                .auth()
                .preemptive()
                .basic("tester", "maniac")
                .contentType("application/json")
                .body(delete)
                .delete("http://localhost:8081/waesheroes/api/v1/users")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(IsEqual.equalTo("User 'tester' removed from database."));
    }

}
