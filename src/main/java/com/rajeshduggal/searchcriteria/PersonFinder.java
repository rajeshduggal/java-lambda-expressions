package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PersonFinder {

    //interface java.util.function.Predicate<T> {
    //    boolean test(T t);
    //}

    static public List<Person> findPeople(List<Person> roster, Predicate<Person> testCriteria) {
        List<Person> retval = new ArrayList();
        for (Person p : roster) {
            if (testCriteria.test(p)) {
                retval.add(p);
            }
        }
        return retval;
    }
}
