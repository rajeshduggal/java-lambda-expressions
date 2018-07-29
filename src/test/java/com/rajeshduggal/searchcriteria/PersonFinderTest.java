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
        result = PersonFinder.findPeople(roster, new MeetsTargetAgeDemographicCriteria());
        assertEquals(expResult, result);
    }

    static class MeetsTargetAgeDemographicCriteria implements PersonFinder.Criteria {

        @Override
        public boolean test(Person p) {
            return p.age >= 20 && p.age <= 30;
        }
    }

}
