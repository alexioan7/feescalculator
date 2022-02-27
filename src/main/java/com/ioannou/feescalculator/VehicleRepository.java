package com.ioannou.feescalculator;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Iterable<Vehicle> findAll();

}
