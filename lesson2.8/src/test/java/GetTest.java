import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTest {

    @Test
    void getTest() {

        given()
                .baseUri("https://postman-echo.com")
                .queryParam("name", "Egor")
                .contentType(ContentType.JSON)
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.name", org.hamcrest.Matchers.equalTo("Egor"))
                .body("url", org.hamcrest.Matchers.equalTo("https://postman-echo.com/get?name=Egor"));
    }
}