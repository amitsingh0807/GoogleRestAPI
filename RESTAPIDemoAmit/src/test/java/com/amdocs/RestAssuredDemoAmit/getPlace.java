package com.amdocs.RestAssuredDemoAmit;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
//import io.restassured.http.ContentType;

public class getPlace {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
			given().
				param("location","-33.8670522,151.1957362").
				param("key","AIzaSyA2ePEUNzcg3XHCGhZ6U1b6gOJnPHocBYI").
				param("radius","500").
			when().
				get("/maps/api/place/nearbysearch/json").
			then().
			assertThat().statusCode(200).and().body("status",equalTo("OK"));
			
		
			
			

	}

}
