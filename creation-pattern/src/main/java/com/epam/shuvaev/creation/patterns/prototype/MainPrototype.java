package com.epam.shuvaev.creation.patterns.prototype;

import com.epam.shuvaev.creation.patterns.prototype.dto.Address;
import com.epam.shuvaev.creation.patterns.prototype.dto.Contact;
import com.epam.shuvaev.creation.patterns.prototype.dto.Person;

/**
 * Created by macbook on 07.03.17
 */
public class MainPrototype {
    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();

        Address prototypeAddress1 = prototypeManager.getPrototype(Address.class);
        Address prototypeAddress2 = prototypeManager.getPrototype(Address.class);
        System.out.println("Is different objects: " + (prototypeAddress1 != prototypeAddress2));
        Contact prototypeContact1 = prototypeManager.getPrototype(Contact.class);
        Contact prototypeContact2 = prototypeManager.getPrototype(Contact.class);
        System.out.println("Is different objects: " + (prototypeContact1 != prototypeContact2));
        Person prototypePerson1 = prototypeManager.getPrototype(Person.class);
        Person prototypePerson2 = prototypeManager.getPrototype(Person.class);
        System.out.println("Is different objects: " + (prototypePerson1 != prototypePerson2));
    }
}
