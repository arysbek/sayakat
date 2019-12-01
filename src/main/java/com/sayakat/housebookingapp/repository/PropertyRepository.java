package com.sayakat.housebookingapp.repository;

import com.sayakat.housebookingapp.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
}
