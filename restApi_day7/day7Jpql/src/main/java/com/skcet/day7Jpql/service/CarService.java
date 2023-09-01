package com.skcet.day7Jpql.service;

import java.util.List;

import com.skcet.day7Jpql.model.Car;

public interface CarService {
      boolean addValues(Car car);
      List<Car> getQuery();
      List<Car> getQueryByOwner(int owners);
      List<Car> getQueryByAddress(String address);
      List<Car> getQueryByCarName(String carName);
      List<Car> getByBoth(int owners,String address);
}
