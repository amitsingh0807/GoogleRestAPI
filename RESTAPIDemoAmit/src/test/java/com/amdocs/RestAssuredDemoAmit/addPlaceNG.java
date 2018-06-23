package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class addPlaceNG {
	
	@Test
	public void addPlaceNG() {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		String payLoadBody = "{" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -33.8669710," + 
				"    \"lng\": 151.1958750" + 
				"  },\r\n" + 
				"  \"accuracy\": 50," + 
				"  \"name\": \"Google Shoes!\"," + 
				"  \"phone_number\": \"(02) 9374 4000\"," + 
				"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," + 
				"  \"types\": [\"shoe_store\"]," + 
				"  \"website\": \"http://www.google.com.au/\"," + 
				"  \"language\": \"en-AU\"" + 
				"}";
		
		
		Response resp = given().
			queryParam("key", "AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
			body(payLoadBody).
		when().
			post("/maps/api/place/add/json").
		then().
			assertThat().statusCode(200).body("status", equalTo("OK")).
			extract().response();
		
		System.out.println("Raw Form :"+resp);
		
		String respAsString = resp.asString();
		
		System.out.println("String Form :"+respAsString);
		
		JsonPath respAsJson = new JsonPath(respAsString);
		
		System.out.println("Json Form :"+respAsJson);
		
		String placeID = respAsJson.get("place_id");
				
		System.out.println("Place id is "+placeID);

	}

}
