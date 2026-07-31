import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostTest {

    @Test
    void postTest() {

        String body = "Privet";

        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}