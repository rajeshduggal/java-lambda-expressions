package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;

public class PersonFinder {

    static public List<Person> findPeopleOlderThan(List<Person> roster, int age) {
        return findPeopleWithinAgeRange(roster, age, -1);
    }

    static public List<Person> findPeopleWithinAgeRange(List<Person> roster, int min, int max) {
        List<Person> retval = new ArrayList();
        if (max == -1) max = 999;
        for (Person p : roster) {
            if (min <= p.age && p.age < max) {
                retval.add(p);
            }
        }
        return retval;
    }
}
