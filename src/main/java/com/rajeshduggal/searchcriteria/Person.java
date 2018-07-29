package com.rajeshduggal.searchcriteria;

import java.util.Objects;

public class Person {

    public String name;
    public int age;
    public boolean eligible;

    Person(String name, int age, boolean eligible) {
        this.name = name;
        this.age = age;
        this.eligible = eligible;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.eligible = false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + this.age;
        hash = 73 * hash + (this.eligible ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", eligible=" + eligible + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.eligible != other.eligible) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
