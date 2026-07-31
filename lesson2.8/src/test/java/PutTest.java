import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PutTest {
    @Test
    void putTest() {

        String body = "Update";

        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}