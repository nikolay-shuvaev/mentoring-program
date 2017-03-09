package com.epam.shuvaev.creation.patterns.task1.dao;

import com.epam.shuvaev.creation.patterns.task1.dto.Person;

import java.util.List;

/**
 * Created by macbook on 09.03.17.
 */
public interface PersonDao {
    List<Person> readPersons();

    List<Person> readPersons(String name);

    boolean writePerson(Person person);
}
