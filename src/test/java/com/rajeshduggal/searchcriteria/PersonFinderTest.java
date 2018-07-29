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
    public void testFindPeopleOlderThan() {
        Person jane = new Person("Jane", 25);
        List<Person> expResult = new ArrayList<Person>();
        expResult.add(jane);

        List<Person> result = PersonFinder.findPeopleOlderThan(roster, 20);
        assertEquals(expResult, result);
    }
}
