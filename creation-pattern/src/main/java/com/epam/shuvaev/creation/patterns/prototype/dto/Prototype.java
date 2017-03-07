package com.epam.shuvaev.creation.patterns.prototype.dto;

/**
 * Created by macbook on 07.03.17.
 */
public interface Prototype<T> extends Cloneable {
    T clone() throws CloneNotSupportedException;
}
