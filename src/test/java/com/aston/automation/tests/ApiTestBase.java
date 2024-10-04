package com.aston.automation.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.requestSpecification;

public class ApiTestBase {
    private static final String baseUri = "https://postman-echo.com";
    public static final String HOST = "postman-echo.com";
    public static final String PROTOCOL_HTTPS = "https";
    public static final int STATUS_CODE_200 = 200;
    public static final String HEADERS_HOST = "headers.host";
    public static final String HEADERS_X_FORWARDED_PROTO = "headers.x-forwarded-proto";
    public static final String HEADERS_X_REQUEST_START = "headers.x-request-start";
    public static final String HEADERS_CONNECTION = "headers.connection";
    public static final String CONNECTION_CLOSE = "close";
    public static final String HEADERS_X_FORWARDED_PORT = "headers.x-forwarded-port";
    public static final String PORT_443 = "443";
    public static final String HEADERS_X_AMZN_TRACE_ID = "headers.x-amzn-trace-id";
    public static final String HEADERS_ACCEPT = "headers.accept";
    public static final String CONTENT_TYPE_APP_JSON = "application/json";
    public static final String CONTENT_TYPE_APP_JSCRIPT = "application/javascript";
    public static final String CONTENT_TYPE_TEXT_JSCRIPT = "text/javascript";
    public static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    public static final String CONTENT_TYPE_WITH_UTF8 = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final String HEADERS_USER_AGENT = "headers.user-agent";
    public static final String HEADERS_ACCEPT_ENCODING = "headers.accept-encoding";
    public static final String ENCODING_GZIP_DEFLATE = "gzip,deflate";
    public static final String HEADERS_CONTENT_LENGTH = "headers.content-length";
    public static final String HEADERS_CONTENT_TYPE = "headers.content-type";
    public static final String KEY_URL = "url";
    public static final String URL_HOST_GET = "https://postman-echo.com/get";
    public static final String URL_HOST_POST = "https://postman-echo.com/post";
    public static final String URL_HOST_PUT = "https://postman-echo.com/put";
    public static final String URL_HOST_PATCH = "https://postman-echo.com/patch";
    public static final String URL_HOST_DELETE = "https://postman-echo.com/delete";
    public static final String KEY_ARGS = "args";
    public static final String KEY_DATA = "data";
    public static final String KEY_FILES = "files";
    public static final String KEY_FORM = "form";
    public static final String KEY_JSON = "json";

    @BeforeAll
    static void setUp(){
        requestSpecification = RestAssured.given()
                .baseUri(baseUri)
                .accept(ContentType.JSON);

    }
}
