package com.aston.automation.specification;

import io.restassured.builder.ResponseSpecBuilder;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class ResponseSpecification {

    public static io.restassured.specification.ResponseSpecification statusCodeSpec(int status) {
        return new ResponseSpecBuilder().expectStatusCode(status)
                .build();
    }

    public static io.restassured.specification.ResponseSpecification contentTypeJsonSpec(String contentType) {
        return new ResponseSpecBuilder()
                .expectContentType(contentType)
                .build();
    }

    public static io.restassured.specification.ResponseSpecification keyNotNullSpec(String key) {
        return new ResponseSpecBuilder()
                .expectBody(key, notNullValue())
                .build();
    }

    public static io.restassured.specification.ResponseSpecification keyNullSpec(String key) {
        return new ResponseSpecBuilder()
                .expectBody(key, nullValue())
                .build();
    }

    public static io.restassured.specification.ResponseSpecification equalsToSeveralValuesSpec(String jsonPath, String... expectedValues) {
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();

        // Проверяем, что значение заголовка "accept" соответствует всем ожидаемым значениям
        for (String expectedValue : expectedValues) {
            specBuilder.expectBody(jsonPath, containsString(expectedValue));
        }

        // Проверяем, что в ответе нет дополнительных значений
        StringBuilder allExpectedValues = new StringBuilder();
        for (String expectedValue : expectedValues) {
            allExpectedValues.append(expectedValue).append(", ");
        }

        // Убираем последнюю запятую и пробел
        String expectedValuesString = allExpectedValues.length() > 0
                ? allExpectedValues.substring(0, allExpectedValues.length() - 2)
                : "";

        specBuilder.expectBody(jsonPath, equalTo(expectedValuesString));

        return specBuilder.build();
    }

    public static io.restassured.specification.ResponseSpecification keyIsEmptySpec(String key) {
        return new ResponseSpecBuilder()
                .expectBody(key, anEmptyMap())
                .build();
    }

    public static io.restassured.specification.ResponseSpecification keyEqualToSpec(String key, String value) {
        return new ResponseSpecBuilder()
                .expectBody(key, equalTo(value))
                .build();
    }

    public static io.restassured.specification.ResponseSpecification keyContainsSpec(String key, String value) {
        return new ResponseSpecBuilder()
                .expectBody(key, containsString(value))
                .build();
    }

    public static io.restassured.specification.ResponseSpecification keyEqualSeveralToSpec(String jsonPath, Map<String, String> keyValues) {
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();

        // Добавляем проверку для каждого ключа и его значения
        keyValues.forEach((key, value) -> {
            specBuilder.expectBody(jsonPath + "." + key, equalTo(value));
        });

        return specBuilder.build();
    }
}
