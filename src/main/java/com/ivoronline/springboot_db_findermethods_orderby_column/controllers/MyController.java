package com.ivoronline.springboot_db_findermethods_orderby_column.controllers;

import com.ivoronline.springboot_db_findermethods_orderby_column.entity.Person;
import com.ivoronline.springboot_db_findermethods_orderby_column.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MyController {

  //PROPERTIES
  @Autowired PersonRepository repository;

  //====================================================================================
  // GET BY AGE
  //====================================================================================
  @ResponseBody
  @RequestMapping("getByAge")
  List<Person> getByAge() {
    return repository.findByAgeGreaterThanOrderByNameAsc(0);
  }
  
  //====================================================================================
  // GET BY ID
  //====================================================================================
  @ResponseBody
  @RequestMapping("getById")
  List<Person> getByName() {
    return repository.findByIdGreaterThanOrderByNameAsc(0);
  }
  
  //====================================================================================
  // GET BY ID List
  //====================================================================================
  @ResponseBody
  @RequestMapping("getByIdList")
  List<Person> getByIdList() {
  
    //COLLECT IDS
    List<Integer> ids = new ArrayList<>();
                  ids.add(1);
                  ids.add(2);
                  ids.add(3);
                  
    //GET & SORT RECORDS
    List<Person> persons = (List<Person>) repository.findAllById(ids);
    Collections.sort(persons, new PersonComparator());
    
    //RETURN SORTED RECORDS
    return persons;
  }

}

//====================================================================================
// CLASS: PERSON COMPARATOR
//====================================================================================
class PersonComparator implements Comparator<Person> {
  @Override
  public int compare(Person a, Person b) {
    return a.getAge() - b.getAge();
  }
}
