package com.aston.automation.specification;

import io.restassured.builder.RequestSpecBuilder;

import java.util.Map;

public class RequestsSpecification {

    public static io.restassured.specification.RequestSpecification reqTypeSpec(String contentType) {
        return new RequestSpecBuilder()
                .setContentType(contentType)  // Указываем тип содержимого
                .build();
    }

    public static io.restassured.specification.RequestSpecification reqBodyTextSpec(String body) {
        return new RequestSpecBuilder()
                .setBody(body)
                .build();
    }

    public static io.restassured.specification.RequestSpecification postReqSpecFormParams2(Map<String, String> formData) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();

        // Добавляем все ключи и значения из карты formData
        formData.forEach(specBuilder::addFormParam);

        return specBuilder.build();
    }
}
