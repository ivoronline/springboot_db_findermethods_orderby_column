package com.ivoronline.springboot_db_findermethods_orderby_column.repository;

import com.ivoronline.springboot_db_findermethods_orderby_column.entity.Person;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
  List<Person> findByAgeGreaterThanOrderByNameAsc(Integer age);
  List<Person> findByIdGreaterThanOrderByNameAsc(Integer id);
}
