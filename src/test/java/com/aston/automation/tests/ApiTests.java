package com.aston.automation.tests;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public class ApiTests {
    String baseUri = "https://postman-echo.com";


    @Test
    public void testGetRequest() {
        given().baseUri(baseUri)
                .when().get("/get")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.19)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("url", equalTo("http://postman-echo.com/get"));
    }

    @Test
    public void testPostRawText() {
        String test = "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. " +
                "Junk MTV quiz graced by fox whelps..";

        given().baseUri(baseUri)
                .contentType("text/plain")
                .body(test)
                .when().post("/post")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())
                .body("data", equalTo(test))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("json", nullValue())
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPostFormData() {
        String foo1Key = "foo1";
        String foo1Value = "bar1";
        String foo2Key = "foo2";
        String foo2Value = "bar2";

        given().baseUri(baseUri)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam(foo1Key, foo1Value)
                .formParam(foo2Key, foo2Value)
                .when().post("/post")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())
                .body("data", isEmptyOrNullString())
                .body("files", anEmptyMap())
                .body("form." + foo1Key, equalTo(foo1Value))
                .body("form." + foo2Key, equalTo(foo2Value))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("json." + foo1Key, equalTo(foo1Value))
                .body("json." + foo2Key, equalTo(foo2Value))
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPut() {
        String test = "Some put text";

        given().baseUri(baseUri)
                .contentType("text/plain")
                .body(test)
                .when().put("/put")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())
                .body("data", equalTo(test))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("json", nullValue())
                .body("url", equalTo("http://postman-echo.com/put"));
    }

    @Test
    public void testPatch() {
        String test = "Some patch text";

        given().baseUri(baseUri)
                .contentType("text/plain")
                .body(test)
                .when().patch("/patch")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())
                .body("data", equalTo(test))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("json", nullValue())
                .body("url", equalTo("http://postman-echo.com/patch"));
    }

    @Test
    public void testDelete() {
        String test = "Some delete text";

        given().baseUri(baseUri)
                .contentType("text/plain")
                .body(test)
                .when().delete("/delete")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args", anEmptyMap())
                .body("data", equalTo(test))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.x-request-start", containsString("t="))
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", containsString("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))

                .body("json", nullValue())
                .body("url", equalTo("http://postman-echo.com/delete"));
    }
}

