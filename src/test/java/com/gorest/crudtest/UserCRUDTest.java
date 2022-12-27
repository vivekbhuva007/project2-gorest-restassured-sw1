package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {


    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }



    @Test
    public void verifyUserCreatedSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Albcd");
        userPojo.setEmail("viku"+getRandomValue()+"@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                        .when()
                        .body(userPojo)
                        .post("");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test

    public void verifyUserUpdatedSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("ed");
        userPojo.setEmail("Rgg345ghh6555@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .body(userPojo)
                .pathParam("id","11605")
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAllCustomerInfo() {
        Response response = given()
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .pathParam("id","11526")
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}



