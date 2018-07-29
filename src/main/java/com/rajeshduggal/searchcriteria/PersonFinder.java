package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;

public class PersonFinder {

    interface Criteria {

        boolean test(Person p);
    }

    static public List<Person> findPeople(List<Person> roster, Criteria testCriteria) {
        List<Person> retval = new ArrayList();
        for (Person p : roster) {
            if (testCriteria.test(p)) {
                retval.add(p);
            }
        }
        return retval;
    }
}
