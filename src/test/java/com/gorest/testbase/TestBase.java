package com.gorest.testbase;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/users";



    }
}
