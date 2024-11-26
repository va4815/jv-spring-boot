package com.northcoders.demospringbootapp.controller;

import model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String greeting(){

     return "Hello!";
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){

        Person personOne = new Person("Vincent", 30, "Vincent@LeungEnterprises.com", "Hong Kong", "Lots of Food!");
        Person personTwo = new Person ("Will", 33, "Will@helpmelearntocode.com", "Manchester", "Pizza");

        ArrayList<Person> personArray = new ArrayList<>();

        personArray.add(personOne);
        personArray.add(personTwo);

        return personArray;
    }
}
