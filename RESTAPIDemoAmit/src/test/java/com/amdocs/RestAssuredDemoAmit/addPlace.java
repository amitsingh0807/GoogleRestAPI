package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class addPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response resp = given().
			queryParam("key","AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
			body("{"+
				 "\"location\": {"+
				    "\"lat\": -33.8669710,"+
				    "\"lng\": 151.1958750"+
				  "},"+
				  "\"accuracy\": 50,"+
				  "\"name\": \"Google Shoes!\","+
				  "\"phone_number\": \"(02) 9374 4000\","+
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				  "\"types\": [\"shoe_store\"],"+
				  "\"website\": \"http://www.google.com.au/\","+
				  "\"language\": \"en-AU\""+
				"}").
		when().
			post("/maps/api/place/add/json").
		then().
			assertThat().statusCode(200).and().body("status",equalTo("OK")).
			
		extract().response();

				  
			String respAsString = resp.asString();
			System.out.println(respAsString);
			
			JsonPath respAsJson = new JsonPath(respAsString);
			
			String placeId = respAsJson.get("place_id");
			
			System.out.println(placeId);
			
	}

}
