package com.skcet.day7Jpql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day7Jpql.model.Car;
import com.skcet.day7Jpql.service.CarService;

@RestController
@RequestMapping("api/v1/controller")
public class CarController {
  @Autowired
  private CarService carservice;
  
  @PostMapping("/add")
  public ResponseEntity<String> addValues(@RequestBody Car car)
  {
	  boolean dataSaved=carservice.addValues(car);
	  if(dataSaved)
	  {
		  return ResponseEntity.status(200).body("added successfully");
	  }
	  else
	  {
		  return ResponseEntity.status(404).body("not added successfully");
	  }
  }
  
  @GetMapping("/getQuery")
  public ResponseEntity<List<Car>> getAllQuery()
  {
	  return ResponseEntity.status(200).body(carservice.getQuery());
  }
  
  @GetMapping("/getQueryCarName/{carName}")
  public ResponseEntity<List<Car>> getQueryByCarName(@PathVariable String carName)
  {
	  return ResponseEntity.status(200).body(carservice.getQueryByCarName(carName));
  }
  
  @GetMapping("/getQueryOwner/{owners}")
  public ResponseEntity<List<Car>> getQueryByOwners(@PathVariable int owners)
  {
	  return ResponseEntity.status(200).body(carservice.getQueryByOwner(owners));
  }
  
  @GetMapping("/getQueryAddress/{address}")
  public ResponseEntity<List<Car>> getQueryByAddress(@PathVariable String address)
  {
	  return ResponseEntity.status(200).body(carservice.getQueryByAddress(address));
  }
  
  @GetMapping("/getQueryAddress1/{address}/getQueryOwner1/{owners}")
  public ResponseEntity<List<Car>> getQueryByBoth(@PathVariable String address,@PathVariable int owners)
  {
	  return ResponseEntity.status(200).body(carservice.getByBoth(owners, address));
  }
  
}
