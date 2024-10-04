package com.aston.automation.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static com.aston.automation.specification.ResponseSpecification.*;
import static com.aston.automation.specification.RequestsSpecification.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRawTextSpecTests extends ApiTestBase {
    private static String stringTest = "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. " +
            "Junk MTV quiz graced by fox whelps..";
    private static final String METHOD = "/post";
    private static Response response;

    @BeforeAll
    public static void setup() {
        response = given()
                .spec(reqBodyTextSpec(stringTest))
                .log().all() // Логируем перед
                .when().post(METHOD)
                .then().log().body()
                .extract().response();
    }

    @Test
    @Order(1)
    public void testPostRTSchema() {
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("postRawTextSchema.json"));
    }

    @Test
    @Order(2)
    public void testPostRTStatusCode200() {
        response.then()
                .spec(statusCodeSpec(STATUS_CODE_200));
    }

    @Test
    @Order(3)
    public void testPostRTTypeJson() {
        response.then()
                .spec(contentTypeJsonSpec(CONTENT_TYPE_APP_JSON));
    }

    @Test
    @Order(4)
    public void testPostRTArgsIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_ARGS));
    }

    @Test
    @Order(5)
    public void testPostRTDataEqual() {
        response.then()
                .spec(keyEqualToSpec(KEY_DATA, stringTest));
    }

    @Test
    @Order(6)
    public void testPostRTFilesIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_FILES));
    }

    @Test
    @Order(7)
    public void testPostRTFormIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_FORM));
    }

    @Test
    @Order(8)
    public void testPostRTHeaderHostIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_HOST, HOST));
    }

    @Test
    @Order(9)
    public void testPostRTHeaderRequestStartNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_X_REQUEST_START));
    }

    @Test
    @Order(10)
    public void testPostRTHeaderConnectionClose() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_CONNECTION, CONNECTION_CLOSE));
    }

    @Test
    @Order(11)
    public void testPostRTHeaderContentLengthNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_CONTENT_LENGTH));
    }

    @Test
    @Order(12)
    public void testPostRTHeaderProtocolHttps() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_X_FORWARDED_PROTO, PROTOCOL_HTTPS));
    }

    @Test
    @Order(13)
    public void testPostRTHeaderPort443() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_X_FORWARDED_PORT, PORT_443));
    }

    @Test
    @Order(14)
    public void testPostRTHeaderTraceIdIsNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_X_AMZN_TRACE_ID));
    }

    @Test
    @Order(15)
    public void testPostRTHeaderAcceptTypes() {
        String[] expectedValues = {
                CONTENT_TYPE_APP_JSON,
                CONTENT_TYPE_APP_JSCRIPT,
                CONTENT_TYPE_TEXT_JSCRIPT,
                CONTENT_TYPE_TEXT_JSON
        };

        response.then()
                .spec(equalsToSeveralValuesSpec(HEADERS_ACCEPT, expectedValues));

    }

    @Test
    @Order(16)
    public void testPostRTHeaderContentTypeContain() {
        response.then()
                .spec(keyContainsSpec(HEADERS_CONTENT_TYPE, CONTENT_TYPE_TEXT_PLAIN));
    }

    @Test
    @Order(17)
    public void testPostRTHeaderUserAgentNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_USER_AGENT));
    }

    @Test
    @Order(18)
    public void testPostRTHeaderEncodingIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_ACCEPT_ENCODING, ENCODING_GZIP_DEFLATE));
    }

    @Test
    @Order(19)
    public void testPostRTJsonNull() {
        response.then()
                .spec(keyNullSpec(KEY_JSON));
    }

    @Test
    @Order(20)
    public void testPostRTUrlIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(KEY_URL, URL_HOST_POST));
    }
}
