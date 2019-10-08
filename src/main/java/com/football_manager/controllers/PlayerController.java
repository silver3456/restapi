package com.football_manager.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PlayerController {


    //GET --> /api/players
    public static ValidatableResponse getAllPlayers() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .get("/api/players")
                .then()
                .assertThat()
                .statusCode(200);
    }

    //Get -->/api/players/{id}
    public static ValidatableResponse getPlayer(long id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .get("/api/players/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
