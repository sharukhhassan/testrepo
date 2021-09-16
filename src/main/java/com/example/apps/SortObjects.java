package com.example.apps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortObjects {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Alex", 20));
        persons.add(new Person("Chad", 30));
        persons.add(new Person("Ben", 20));
        persons.add(new Person("Ben", 50));


        System.out.println(persons);
        Collections.sort(persons);

        System.out.println(persons);

        DescCompare desc = new DescCompare();
        Collections.sort(persons, desc);

        System.out.println(persons);

        Collections.reverse(persons);
        System.out.println(persons);
    }
}

class DescCompare implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
        if(o1.age < o2.age)
            return 1;
        else if(o1.age > o2.age)
            return -1;
        else
            return o2.name.compareTo(o1.name);
    }
}

class Person implements Comparable<Person> {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person o) {
        if (this.age > o.age)
            return 1;
        else if (this.age < o.age)
            return -1;
        else {
            return this.name.compareTo(o.name);
        }
    }

    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}
