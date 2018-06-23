package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
//import io.restassured.http.ContentType;

public class getPlaceUsingConductor {
	
	

	public static void getPlace(String siteURL, String placeLocation, String placeKey, String placeRadius) {
		// TODO Auto-generated method stub
		
		System.out.println(placeKey);
		RestAssured.baseURI= siteURL;
		Response resp = given().
				param("location",placeLocation).
				param("key",placeKey).
				param("radius", placeRadius).
			when().
				get("/maps/api/place/nearbysearch/json").
			then().log().all().
			assertThat().statusCode(200).and().body("status",equalTo("OK")).
			extract().response();
		
		String respString = resp.asString();
		JsonPath respJson = new JsonPath(respString);
		System.out.println(respJson.get("results.size()"));
		System.out.println(respJson.get("results[0].name"));
		System.out.println(respJson.get("status"));
		System.out.println("Status Code is :" +respJson);
			
		
			
			

	}

}
