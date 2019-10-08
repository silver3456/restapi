package com.football_manager;

import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestRunner {

    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = "http://localhost:8888/";
    }

    @AfterClass
    public void afterClass(){

    }
}
