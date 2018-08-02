package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonFinder {

    //interface java.util.function.Predicate<T> {
    //    boolean test(T t);
    //}

    //interface java.util.function.Consumer<T> {
    //    void accept(T t);
    //}

    //interface java.util.function.Function<T, R> {
    //    R apply(T t);
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

    static public String getFormattedNames(
            List<Person> roster,
            Predicate<Person> testCriteria) {
        String retval = roster
            .stream()
            .filter(testCriteria)
            .map(p -> p.name)
            .collect(joining(", ","", "."));
        return retval;
    }

    static public <X, Y> List<X> updatePeople(
            List<X> roster,
            Predicate<X> testCriteria,
            Function<X, Y> mapper,
            Consumer<X> block) {
        List<X> retval = roster
            .stream()
            .map((p) -> {
                    if (testCriteria.test(p)) {
                        Y data = mapper.apply(p);
                        block.accept(p);
                    }
                    return p;
                })
            .collect(toList());
        return retval;
    }
}
