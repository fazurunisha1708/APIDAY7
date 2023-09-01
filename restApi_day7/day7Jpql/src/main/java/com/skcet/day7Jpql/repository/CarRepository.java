package com.skcet.day7Jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcet.day7Jpql.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{

	boolean existsById(int id);
	@Query("select c from Car c")
	List<Car> findAllQuery();
	
	@Query("select c from Car c where c.owners= :o")
	List<Car> findByOwners(@Param("o") int owners);
	@Query("select c from Car c where c.address= :a")
	List<Car> findByAddress(@Param("a") String address);
	@Query("select c from Car c where c.carName= :n")
	List<Car> findByCarName(@Param("n") String carName);
	@Query("select c from Car c where c.owners=?1 and c.address=?2")
	List<Car> findByBoth(int owners,String address);
	
}
