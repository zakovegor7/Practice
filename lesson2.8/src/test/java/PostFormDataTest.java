import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PostFormDataTest {
    @Test
    void postFormDataTest() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.MULTIPART)
                .multiPart("name", "Egor")
                .multiPart("age", "22")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("Egor"))
                .body("form.age", equalTo("22"));
    }
}