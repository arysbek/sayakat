package com.sayakat.housebookingapp.repository;

import com.sayakat.housebookingapp.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {
}
