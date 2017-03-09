package com.epam.shuvaev.creation.patterns.task1.dao;

import com.epam.shuvaev.creation.patterns.task1.dto.Person;
import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;

import java.io.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Created by macbook on 09.03.17
 */
public class FileDao implements PersonDao {
    private static String PERSON_NAME = "Testov Test Testovich";

    private final File file;
    private Interceptor interceptor;

    public FileDao(Initializer initializer, Interceptor interceptor) {
        this.interceptor = interceptor;
        this.file = (File) initializer.init();
    }

    @Override
    public List<Person> readPersons() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE: Failed to open file");
            return Collections.emptyList();
        }
        InputStream in = (InputStream) interceptor.inputProcess(fileInputStream);
        System.out.println("FILE: read all records from file");
        return Collections.singletonList(getTempPerson());
    }

    @Override
    public List<Person> readPersons(String name) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE: Failed to open file");
            return Collections.emptyList();
        }
        InputStream in = (InputStream) interceptor.inputProcess(fileInputStream);
        System.out.println("FILE: read all and filter by " + name);
        return Collections.singletonList(getTempPerson());
    }

    @Override
    public boolean writePerson(Person person) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE: Failed to open file");
            return false;
        }
        OutputStream out = (OutputStream) interceptor.outputProcess(fileOutputStream);
        System.out.println("FILE: write person to file. " + person);
        return true;
    }

    private Person getTempPerson() {
        return Person.of(PERSON_NAME, LocalDate.of(1990, 11, 23))
                .setAddress("Country, City, Street 55")
                .setEmail("test@test.com")
                .setTelephone("00000000");
    }
}
