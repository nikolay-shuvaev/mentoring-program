package com.epam.shuvaev.creation.patterns.task1;

import com.epam.shuvaev.creation.patterns.task1.dao.PersonDao;
import com.epam.shuvaev.creation.patterns.task1.dto.Person;
import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;
import com.epam.shuvaev.creation.patterns.task1.factory.StorageFactory;
import com.epam.shuvaev.creation.patterns.task1.factory.jdbc.JdbcStorageFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by macbook on 09.03.17
 */
public class MainTask1 {


//  Person Write a program that supports writing and reading from files and DB (Access DB using JDBC.ODBC)
//  Writing to a file includes these features:
//  1. Defining the file name to write or read from
//  2. Wrapping with a buffer
//  3. Writing/Reading Persons
// Writing to the DB is also done in three steps:
//  1. Loading driver and creating connection
//  2. Person to DB serializer which breaks Objects into Record and vise versa
//  3. Writing/Reading Persons
// Client chooses to work with files or DB but once the choice was made – client
// code is identical in both cases.
// This means that and beside specifying the source (File/DB) working with the actual
// resource should be transparent and includes the following operations:
//  - void writePerson (Person)
//  - Person readPerson()
//  - Person readPerson (String name)

    public static void main(String[] args) {
        String PERSON_NAME = "Testov Test Testovich";

//        StorageFactory factory = new FileStorageFactory();
        StorageFactory factory = new JdbcStorageFactory();
        Initializer initializer = factory.createtInitializer();
        Interceptor interceptor = factory.createInterceptors();
        PersonDao personDao = factory.createPersonDao(initializer, interceptor);
        boolean result = personDao.writePerson(
                Person.of(PERSON_NAME, LocalDate.of(1990, 11, 23))
                        .setAddress("Country, City, Street 55")
                        .setEmail("test@test.com")
                        .setTelephone("00000000")
        );
        System.out.println("Is person was written: " + result);

        List<Person> allPersons = personDao.readPersons();
        allPersons.forEach(System.out::println);

        List<Person> personsByName = personDao.readPersons(PERSON_NAME);
        personsByName.forEach(System.out::println);

    }
}
