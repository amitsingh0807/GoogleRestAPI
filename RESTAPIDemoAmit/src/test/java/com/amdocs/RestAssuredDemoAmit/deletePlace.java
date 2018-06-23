package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deletePlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
			queryParam("key", "AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
/*			body("{"+ 
					"  \"place_id\": \""+addPlace.placeId+"\"" + 
					"}").
*/
		when().
			post("/maps/api/place/delete/json").
		then().
		assertThat().statusCode(200).and().body("status",equalTo("OK"));
		

	}

}
