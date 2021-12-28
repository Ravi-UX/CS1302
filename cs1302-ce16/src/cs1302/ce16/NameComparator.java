package cs1302.ce16;

import java.util.*;

public class NameComparator implements Comparator<Student> {

    public NameComparator() {

    }


    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
