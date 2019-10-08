package com.football_manager.utils;

import com.football_manager.model.Player;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class ResponseParser {

    public static <T> T parse(ValidatableResponse response, Class<T> clazz) {
        return response
                .log().ifError()
                .contentType(ContentType.JSON)
                .assertThat()
                .extract()
                .body()
                .as(clazz);
    }
}
