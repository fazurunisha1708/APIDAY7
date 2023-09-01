package com.skcet.day7Jpql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day7Jpql.model.Car;
import com.skcet.day7Jpql.repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepo;
	@Override
	public boolean addValues(Car car) {
		// TODO Auto-generated method stub
		boolean dataExist=carRepo.existsById(car.getId());
		if(!dataExist)
		{
			carRepo.save(car);
			return true;
		}
		else
		return false;
	}
	@Override
	public List<Car> getQuery() {
		// TODO Auto-generated method stub
		return carRepo.findAllQuery();
	}
	@Override
	public List<Car> getQueryByOwner(int owners) {
		// TODO Auto-generated method stub
		return carRepo.findByOwners(owners);
	}
	@Override
	public List<Car> getQueryByAddress(String address) {
		// TODO Auto-generated method stub
		return carRepo.findByAddress(address);
	}
	@Override
	public List<Car> getQueryByCarName(String carName) {
		// TODO Auto-generated method stub
		return carRepo.findByCarName(carName);
	}
	@Override
	public List<Car> getByBoth(int owners, String address) {
		// TODO Auto-generated method stub
		return carRepo.findByBoth(owners, address);
	}
    
	
}
