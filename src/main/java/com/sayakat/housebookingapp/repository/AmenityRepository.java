package com.sayakat.housebookingapp.repository;

import com.sayakat.housebookingapp.model.Amenity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends CrudRepository<Amenity, Long> {
}
