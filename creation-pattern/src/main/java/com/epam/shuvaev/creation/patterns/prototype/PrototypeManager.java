package com.epam.shuvaev.creation.patterns.prototype;

import com.epam.shuvaev.creation.patterns.prototype.dto.Address;
import com.epam.shuvaev.creation.patterns.prototype.dto.Contact;
import com.epam.shuvaev.creation.patterns.prototype.dto.Person;
import com.epam.shuvaev.creation.patterns.prototype.dto.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macbook on 07.03.17
 */
public class PrototypeManager {
    private Map<Class, Prototype> cache = new HashMap<>();

    public PrototypeManager() {
        cache.put(Address.class, new Address());
        cache.put(Contact.class, new Contact());
        cache.put(Person.class, new Person());
    }

    public <T extends Prototype> T getPrototype(Class<T> clazz) {
        try {
            return (T) cache.get(clazz).clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone error! Return null.");
            return null;
        }
    }
}
