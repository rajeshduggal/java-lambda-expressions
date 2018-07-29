package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;

public class PersonFinder {

    static public List<Person> findPeopleOlderThan(List<Person> roster, int age) {
        List<Person> retval = new ArrayList();
        for (Person p : roster) {
            if (p.age >= age) {
                retval.add(p);
            }
        }
        return retval;
    }
}
