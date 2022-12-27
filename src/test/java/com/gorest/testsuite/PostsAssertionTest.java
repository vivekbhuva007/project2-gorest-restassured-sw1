package com.gorest.testsuite;


import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsAssertionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);

    }

//    1. Verify the if the total record is 25

    @Test
    public void test001() {
        response.body("total.size", equalTo(25));
    }
//     2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”

    @Test
    public void test002() {
        response.body("find{it.id==2730}.title", equalTo("Ad ipsa coruscus ipsam eos demitto centum."));

    }


    //     3. Check the single user_id in the Array list (5522)
    @Test
    public void test003() {
        response.body("user_id", hasItem(5522));

    }


//4. Check the multiple ids in the ArrayList (2693, 2684,2681)


    @Test
    public void test004() {
        response.body("id", hasItems(2693, 2674, 2714));

    }


//5. Verify the body of userid = 5428 is equal “ Verto clementia ocer. Est abscido capillus. Temeritas aut quis. Aperte ceno aetas. Substantia pax illo. Natus sumo valens. Consequatur ullam tabula. Tersus dolorem temptatio. Urbs explicabo desino. Summopere socius ipsum. Adficio apud tabernus. Hic tonsor talus. Concido consequatur animi. Valetudo adulescens antea. Curia abduco torqueo. Despecto armarium aurum. Votum curriculum appositus. Aut verbum voluptatem.

    @Test
    public void test005() {
        response.body("find{it.user_id== 5428}.body", equalTo("Verto clementia ocer. Est abscido capillus. Temeritas aut quis. Aperte ceno aetas. Substantia pax illo. Natus sumo valens. Consequatur ullam tabula. Tersus dolorem temptatio. Urbs explicabo desino. Summopere socius ipsum. Adficio apud tabernus. Hic tonsor talus. Concido consequatur animi. Valetudo adulescens antea. Curia abduco torqueo. Despecto armarium aurum. Votum curriculum appositus. Aut verbum voluptatem."));

    }

}