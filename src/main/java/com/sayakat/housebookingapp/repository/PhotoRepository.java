package com.sayakat.housebookingapp.repository;

import com.sayakat.housebookingapp.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
