package testCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pageObject.common.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BackendTests extends BaseTest {

    @Test
    public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

        String originalText = "dev";
        int expectedMd5CheckSum = 2;

        given().
                param("username",originalText).
                when().
                get("http://localhost:8081/waesheroes/api/v1/users/details").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("id",equalTo(expectedMd5CheckSum));
    }

    @Test
    public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {

        given().
                auth().
                preemptive().
                basic("admin", "hero").
                when().
                get("http://localhost:8081/waesheroes/api/v1/users/all").
                then().
                assertThat().
                statusCode(200);
    }

}
