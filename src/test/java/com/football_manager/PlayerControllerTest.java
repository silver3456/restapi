package com.football_manager;

import com.football_manager.controllers.PlayerController;
import com.football_manager.model.Player;
import com.football_manager.utils.ResponseParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerControllerTest extends TestRunner {


    @Test//bad way of test creation// very bad way
    public void getAllPlayersTest() {
        RestAssured
                .given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .get("/api/players")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test//not so good way
    public void getPlayerTestSecond() {
        ValidatableResponse response = PlayerController.getPlayer(7);

        String playerName = response.extract().response().getBody().jsonPath().getString("firstName");
        Assert.assertEquals(playerName, "Aaron Ramsey");
    }

    //7 Aaron Ramsey
    @Test//better way
    public void getPlayerTest() {
        ValidatableResponse response = PlayerController.getPlayer(7);
        Player player = ResponseParser.parse(response, Player.class);

        Assert.assertEquals(player.getFirstName(), "Aaron Ramsey");
    }
}
