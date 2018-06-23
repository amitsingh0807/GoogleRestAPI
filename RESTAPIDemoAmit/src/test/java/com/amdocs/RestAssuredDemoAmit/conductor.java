package com.amdocs.RestAssuredDemoAmit;
import com.amdocs.RestAssuredDemoAmit.*;

import org.apache.logging.log4j.*;

import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;

public class conductor {
	
	private static Logger log = LogManager.getLogger(conductor.class.getName());

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		//BasicConfigurator.configure();
		Map<String, String> testDataInput = new HashMap();
		testDataInput = excelInput.readExcel();
		System.out.println(testDataInput);
		
		log.debug("Fixing log4j2 error");
		
		getPlaceUsingConductor.getPlace(testDataInput.get("baseURI"), testDataInput.get("location"), testDataInput.get("key"), testDataInput.get("radius"));
		
		
		

	}

}
