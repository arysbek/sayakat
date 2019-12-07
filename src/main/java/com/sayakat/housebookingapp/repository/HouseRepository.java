package com.sayakat.housebookingapp.repository;

import com.sayakat.housebookingapp.model.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
}