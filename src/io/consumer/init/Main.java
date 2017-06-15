package io.consumer.init;

import org.springframework.web.client.RestTemplate;

import io.producer.dto.FlightLog;

public class Main {

  public static void main(String[] args) {
      RestTemplate restTemplate = new RestTemplate();
      FlightLog flightLog = restTemplate.getForObject("http://localhost:8080/get/0.02/", FlightLog.class);
      
      System.out.println("Result is : : "+flightLog.getPm_dGroundSpeed());
  }
}