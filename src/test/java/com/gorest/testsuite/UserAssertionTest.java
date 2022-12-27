package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {
    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        // RestAssured.port = 8080;
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);

    }

//    1. Verify the if the total record is 20

    @Test
    public void test001() {
        response.body("total.size", equalTo(20));
    }


    //  2. Verify the if the name of id = 5311 is equal to ”Laal Kaul”
    @Test
    public void test002() {
        response.body("findAll{it.id== 5311}.name", hasItem("Laal Kaul"));
    }

    // 3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003() {
        response.body("name", hasItem("Vimala Kakkar"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList ("Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void test004() {
        response.body("name", hasItems("Rep. Chidambar Rana","Vimala Kakkar","Deeptimoyee Sharma"));
    }

    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005() {
        response.body("find{it.id== 5303}.email", equalTo("menon_udit@bartell-mccullough.info"));
    }


    //  6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006() {
        response.body("find{it.name =='Udit Menon'}.status", equalTo("active"));
    }

//   7. Verify the Gender = male of user name is “Niro Prajapa

    @Test
    public void test007() {
        response.body("find{it.name =='Rep. Chidambar Rana'}.email", equalTo("rana_chidambar_rep@kihn.name"));
    }

}
