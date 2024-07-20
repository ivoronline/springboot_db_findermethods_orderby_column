package com.ivoronline.springboot_db_findermethods_orderby_column.repositories;

import com.ivoronline.springboot_db_findermethods_orderby_column.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
  List<Person> findListByAgeLessThan(Integer age);
}
