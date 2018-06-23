package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addAndDeletePlaceNGusingFile {
	

	@Test
	public void addAndDeletePlaceNGusingFile() {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response resp = given().
				queryParams("key", "AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
				body("{" + 
						"  \"location\": {" + 
						"    \"lat\": -33.8669710," + 
						"    \"lng\": 151.1958750" + 
						"  }," + 
						"  \"accuracy\": 50," + 
						"  \"name\": \"Google Shoes!\"," + 
						"  \"phone_number\": \"(02) 9374 4000\"," + 
						"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," + 
						"  \"types\": [\"shoe_store\"]," + 
						"  \"website\": \"http://www.google.com.au/\"," + 
						"  \"language\": \"en-AU\"" + 
						"}").
				when().
					post("/maps/api/place/add/json").
				then().
					assertThat().statusCode(200).and().body("status",equalTo("OK")).
					extract().response();
		
		String respInString = resp.asString();
		
		System.out.println(respInString);
		JsonPath respInJason = new JsonPath(respInString);
		
		
		System.out.println("Place successfully created");
		
		String placeId = respInJason.get("place_id");
				
		System.out.println(placeId);
		
		
		//Delete the place id
		
		given().
			queryParam("key","AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
			body("{" + 
				"  \"place_id\": \""+placeId+"\"" + 
				"}").
		when().
			post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().body("status",equalTo("OK"));
		
		System.out.println("Place successfully Deleted");
		

	}
	
}