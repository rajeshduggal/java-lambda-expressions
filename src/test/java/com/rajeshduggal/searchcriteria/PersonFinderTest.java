package com.rajeshduggal.searchcriteria;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;

public class PersonFinderTest {

    private List<Person> roster;

    @Before
    public void setUp() {
        roster = new ArrayList<>();
        roster.add(new Person("John", 15));
        roster.add(new Person("Jane", 25));
    }

    @org.junit.Test
    public void testFindPeopleWithinAgeRange() {
        Person jane = new Person("Jane", 25);
        List<Person> expResult = new ArrayList<Person>();
        expResult.add(jane);

        List<Person> result;
        result = PersonFinder.findPeople(roster,
                (Person p) -> p.age >= 20 && p.age <= 30);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testsetEligibleFlagforPeopleWithinAgeRange() {
        Person john = new Person("John", 15, false);
        Person jane = new Person("Jane", 25, true);
        List<Person> expResult = new ArrayList<Person>();
        expResult.add(john);
        expResult.add(jane);

        List<Person> result;
        result = PersonFinder.updatePeople(roster,
                (Person p) -> p.age >= 20 && p.age <= 30,
                p -> p.name,
                p -> {System.out.println(p.name + " is eligible!");
                      p.eligible = true;}
                );

        assertEquals(expResult, result);
    }
}
