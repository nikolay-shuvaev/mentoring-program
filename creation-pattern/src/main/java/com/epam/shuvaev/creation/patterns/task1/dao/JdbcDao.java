package com.epam.shuvaev.creation.patterns.task1.dao;

import com.epam.shuvaev.creation.patterns.task1.dto.Person;
import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

/**
 * Created by macbook on 09.03.17
 */
public class JdbcDao implements PersonDao {
    private final Connection con;
    private Interceptor interceptor;

    public JdbcDao(Initializer initializer, Interceptor interceptor) {
        this.con = (Connection) initializer.init();
        this.interceptor = interceptor;
    }

    @Override
    public List<Person> readPersons() {
        System.out.println("JDBC: Get all records from DB");
        Person person = (Person) interceptor.inputProcess("");
        return Collections.singletonList(person);
    }

    @Override
    public List<Person> readPersons(String name) {
        System.out.println("JDBC: Get records by name from DB. Name: " + name);
        Person person = (Person) interceptor.inputProcess("");
        return Collections.singletonList(person);
    }

    @Override
    public boolean writePerson(Person person) {
        interceptor.outputProcess(person);
        System.out.println("JDBC: Write person to DB");
        return true;
    }

}
