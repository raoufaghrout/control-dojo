package co.unruly.control_dojos.rollercoasters.domain;

import java.util.List;

import static java.util.Arrays.asList;

public class Group {

    private final List<Person> members;

    public Group(Person... members) {
        this.members = asList(members);
    }

    public static Group of(Person... members) {
        return new Group(members);
    }

    public List<Person> members() {
        return members;
    }

    public int size() {
        return members.size();
    }
}
