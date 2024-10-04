package com.aston.automation.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static com.aston.automation.specification.RequestsSpecification.reqBodyTextSpec;
import static com.aston.automation.specification.ResponseSpecification.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatchSpecTest extends ApiTestBase {

    private static final String METHOD = "/patch";
    private static Response response;
    private static final String stringTest = "Some text";

    @BeforeAll
    public static void setup() {
        response = given()
                .spec(reqBodyTextSpec(stringTest))
                .log().all() // Логируем перед
                .when().patch(METHOD)
                .then().log().body()
                .extract().response();
    }

    @Test
    @Order(1)
    public void testPatchSchema() {
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("patchSchema.json"));
    }

    @Test
    @Order(2)
    public void testPatchStatusCode200() {
        response.then()
                .spec(statusCodeSpec(STATUS_CODE_200));
    }

    @Test
    @Order(3)
    public void testPatchTypeJson() {
        response.then()
                .spec(contentTypeJsonSpec(CONTENT_TYPE_APP_JSON));
    }

    @Test
    @Order(4)
    public void testPatchArgsIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_ARGS));
    }

    @Test
    @Order(5)
    public void testPatchDataEqual() {
        response.then()
                .spec(keyEqualToSpec(KEY_DATA, stringTest));
    }

    @Test
    @Order(6)
    public void testPatchFilesIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_FILES));
    }

    @Test
    @Order(7)
    public void testPatchFormIsEmpty() {
        response.then()
                .spec(keyIsEmptySpec(KEY_FORM));
    }

    @Test
    @Order(8)
    public void testPatchHeaderHostIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_HOST, HOST));
    }

    @Test
    @Order(9)
    public void testPatchHeaderProtocolHttps() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_X_FORWARDED_PROTO, PROTOCOL_HTTPS));
    }

    @Test
    @Order(10)
    public void testPatchHeaderRequestStartNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_X_REQUEST_START));
    }

    @Test
    @Order(11)
    public void testPatchHeaderConnectionClose() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_CONNECTION, CONNECTION_CLOSE));
    }

    @Test
    @Order(12)
    public void testPatchHeaderContentLengthNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_CONTENT_LENGTH));
    }

    @Test
    @Order(13)
    public void testPatchHeaderPort443() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_X_FORWARDED_PORT, PORT_443));
    }

    @Test
    @Order(14)
    public void testPatchHeaderTraceIdIsNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_X_AMZN_TRACE_ID));
    }

    @Test
    @Order(15)
    public void testPatchHeaderAcceptTypes() {
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
    public void testPatchHeaderContentTypeContain() {
        response.then()
                .spec(keyContainsSpec(HEADERS_CONTENT_TYPE, CONTENT_TYPE_TEXT_PLAIN));
    }

    @Test
    @Order(17)
    public void testPatchHeaderUserAgentNotNull() {
        response.then()
                .spec(keyNotNullSpec(HEADERS_USER_AGENT));
    }

    @Test
    @Order(18)
    public void testPatchHeaderEncodingIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(HEADERS_ACCEPT_ENCODING, ENCODING_GZIP_DEFLATE));
    }

    @Test
    @Order(19)
    public void testPatchJsonNull() {
        response.then()
                .spec(keyNullSpec(KEY_JSON));
    }

    @Test
    @Order(20)
    public void testPatchUrlIsCorrect() {
        response.then()
                .spec(keyEqualToSpec(KEY_URL, URL_HOST_PATCH));
    }
}
