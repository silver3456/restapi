package com.football_manager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

public class SlackTest {

    String slackUrl = "https://hooks.slack.com/services/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";
    String message = "This is a line of text in a channel";


    @Test
    public void test() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("text", message);
        request.body(requestParams.toJSONString());
        Response response = request.post(slackUrl);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

}
