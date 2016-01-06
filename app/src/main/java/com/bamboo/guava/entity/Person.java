package com.bamboo.guava.entity;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

/**
 * Created by baozhiyuan on 2016/1/6.
 */
public class Person implements Comparable<Person>{
    private String lastName;
    private String firstName;

    public Person(String paramLastName, String paramFirstName) {
        lastName = paramLastName;
        firstName = paramFirstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String paramFirstName) {
        firstName = paramFirstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String paramLastName) {
        lastName = paramLastName;
    }

    @Override
    public int compareTo(Person another) {
        return ComparisonChain.start()
                .compare(this.firstName,another.firstName)
                .compare(this.lastName,another.lastName)
                .result();
    }
}
