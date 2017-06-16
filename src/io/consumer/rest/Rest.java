package io.consumer.rest;

import org.springframework.web.client.RestTemplate;

import io.consumer.dto.FlightLog;

public class Rest {
	
	private static String URL                = "http://localhost:8080/get/";
    private static RestTemplate restTemplate = new RestTemplate();
	
	
    
	private static String sNoPreProcess(double f) {
		
		double number = f;
		String sNo = String.valueOf(number);
		String[] parts = sNo.split("\\.");
		
		if (parts[1].length() != 2) {
			sNo += "0";
		}		
		return sNo;
	}
    
    
    public static void prepGet() {		  
	    int i = 0;
	    while (true) {
	    	double x = i / 100.00;
	    	i++;
	    	String sNo = sNoPreProcess(x);
	    	String url = URL+sNo+"/";
	    	get(url);
		}
	      
	      
	}

	private static void get(String url) {
  	  System.out.println("url is : "+url);
	  FlightLog flightLog = restTemplate.getForObject(url, FlightLog.class);	      
	  System.out.println("Result is : : "+flightLog.toString());
	  System.out.println();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	

}
