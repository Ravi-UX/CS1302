package cs1302.ce16;

import cs1302.util.ArrayUtility;
import java.util.Arrays;

/**
 * A simple driver program to introduce students to {@code Comparable},
 * {@code Comparator}, and lambda expressions.
 * @author Brad Barnes and Supa' Mike
 */
public class Driver {

    public static void printArr(Student[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i].getName() + " " + s[i].getGPA() + " ");
        }
        System.out.println();
    }
    /**
     * The entry point for the program
     */
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student(810_105_999, "Brad", 2.1),
            new Student(810_106_999, "Mike", 4.0),
            new Student(810_107_999, "Sally", 3.1),
            new Student(811_108_999, "Joe", 1.1),
        };

        Course[] courses = new Course[] {
            new Course(23455, "CSCI", 1301, "Introduction to Programming"),
            new Course(87232, "HONS", 1000, "Intro to Honors"),
            new Course(32133, "CSCI", 1302, "Software Development"),
            new Course(12455, "CSCI", 4720, "Software Architecture"),
            new Course(75825, "PHYS", 1211, "Physics 1"),
            new Course(52385, "MATH", 2610, "Calc II"),
        };


        Driver.printArr(students);
        //System.out.println(ArrayUtility.<Course>max(courses));
        //ArrayUtility.<Course>sort(courses);
        //ArrayUtility.<Student>sort(students, new NameComparator());
        /*ArrayUtility.<Course>sort(
            courses,
            (Course c1, Course c2) -> c1.getPrefix().compareTo(c2.getPrefix())

        );
        Driver.printArr(courses);
        ArrayUtility.<Course>sort(
            courses,
            (Course c1, Course c2) -> Integer.compare(c1.getNumber(), c2.getNumber())
        );*/
        /*System.out.println(ArrayUtility.<Student>max(
            students,
            (Student s1, Student s2) -> Double.compare(s1.getGPA(), s2.getGPA())
        ));
        System.out.println(ArrayUtility.<Student>max(
            students,
            (Student s1, Student s2) -> s2.getName().substring(1, 2).
            compareTo(s1.getName().substring(1, 2))
        ));*/
        ArrayUtility.<Student>sort(
            students,
            (Student s1, Student s2) -> Double.compare(s1.getGPA(), s2.getGPA())
        );
        Driver.printArr(students);


    } // main
} // Driver
