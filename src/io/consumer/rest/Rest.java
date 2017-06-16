package io.consumer.rest;

import org.springframework.web.client.RestTemplate;

import io.consumer.dto.FlightLog;

public class Rest {
	
	private static String URL                = "http://localhost:8080/get/";
    private static RestTemplate restTemplate = new RestTemplate();
	
	public static void prepGet() {		  
		 	      
	      double i = 0;
	     // get(URL+"0.00/");
	      
	      while(true){
	    	  i += 0.01;
	    	  String url = URL+i+"/";	    	       	  	    	  
	    	  get(url);
	    	 
	      }
	}

	private static void get(String url) {
  	  System.out.println("url is : "+url);
	  FlightLog flightLog = restTemplate.getForObject(url, FlightLog.class);	      
	  System.out.println("Result is : : "+flightLog.toString());
	}
	

}
