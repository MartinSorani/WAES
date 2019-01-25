package testCases;

import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BackendTests {

    @Test
    @Parameters("BaseUri")
    public void retrieving_info_for_one_user(String baseUri) {

        given()
                .baseUri(baseUri)
                .param("username", "dev")
                .when()
                .get("/waesheroes/api/v1/users/details")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(matchesJsonSchemaInClasspath("jsonSources/singleUserResponse.json"));
    }

    @Test
    @Parameters("BaseUri")
    public void retrieving_information_from_all_users(String baseUri) {

        given()
                .baseUri(baseUri)
                .auth()
                .preemptive()
                .basic("admin", "hero")
                .when()
                .get("/waesheroes/api/v1/users/all")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Parameters("BaseUri")
    public void signUp(String baseUri) {

        File signUp = new File("src/test/resources/jsonSources/signUpBody.json");

        given()
                .baseUri(baseUri)
                .contentType("application/json")
                .body(signUp)
                .post("/waesheroes/api/v1/users")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @Parameters("BaseUri")
    public void login(String baseUri) {

        given()
                .baseUri(baseUri)
                .auth()
                .preemptive()
                .basic("tester", "maniac")
                .when()
                .get("/waesheroes/api/v1/users/access")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Parameters("BaseUri")
    public void updateUser(String baseUri) {

        File update = new File("src/test/resources/jsonSources/updateUserBody.json");

        given()
                .baseUri(baseUri)
                .auth()
                .preemptive()
                .basic("dev", "wizard")
                .contentType("application/json")
                .body(update)
                .put("/waesheroes/api/v1/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods={"signUp"})
    @Parameters("BaseUri")
    public void deleteUser(String baseUri) {

        File delete = new File("src/test/resources/jsonSources/deleteUserBody.json");

        given()
                .baseUri(baseUri)
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
