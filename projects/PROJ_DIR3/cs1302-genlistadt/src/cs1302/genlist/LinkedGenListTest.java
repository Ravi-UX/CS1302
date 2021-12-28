package cs1302.genlist;

import cs1302.genlistadt.GenList;
import java.util.*;
import java.util.function.*;

/**
 * Test class to test LinkedGenList and to demo methods.
 */
public class LinkedGenListTest {
    /**
     * Main method to test the class.
     * @param args the provided command line arguments
     */
    public static void main (String[] args) {
        //Create a string LinkedGenList and add strings
        LinkedGenList<String> strings = new LinkedGenList<String>();
        strings.add("Lambda");
        strings.add("Expressions");
        strings.add("are");
        strings.add("a");
        strings.add("very");
        strings.add("unique");
        strings.add("java");
        strings.add("functionality");

        //Create a Double LinkedGenList and add Doubles
        LinkedGenList<Double> doubles = new LinkedGenList<Double>();
        doubles.add(4.8);
        doubles.add(6.7);
        doubles.add(103.2);
        doubles.add(10.1);

        //Function that returns the size of a string
        Function<String, Integer> f1 = (String s) -> {
            return s.length();
        };
        /*Demo for the map method. Creates a new LinkedList of type Integer
        which contains the lengths of the corresponding strings by transforming
        the strings to Integers*/
        GenList<Integer> transformed = strings.map(f1);
        System.out.println(transformed.makeString(", "));

        //Function that returns the product of two doubles
        BinaryOperator<Double> bo = (Double d1, Double d2) ->  d1 * d2;

        //Demo for the reduce method which repeatedly multiplies the contents of bo
        Double result = doubles.reduce(-28.35, bo);
        System.out.println(result);

        //Predicate which returns true if the length of the string is between 4 and 9
        Predicate<String> p1 = (String s) -> s.length() <= 4 || s.length() >= 9;
        /*Demo for filter method which returns a new GenList that contains strings of lengths
          between 4 and 9.*/
        GenList<String> filtered = strings.filter(p1);
        System.out.println(filtered.makeString(", "));

        //Comparator which compares the lengths of two strings
        Comparator<String> c1 = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };
        //Demo for min method which returns the shortest string in the strings list
        String s = strings.min(c1);
        System.out.println(s);

        /*Demo for the allMatch method which returns true if all strings are between
        the lengths of 4 and 9*/
        boolean b = strings.allMatch(p1);
        System.out.println(b);

        /*LinkedGenList<String> strings2 = new LinkedGenList<String>();
        strings2.add("Hello");
        strings2.add("World");

        strings2.add(strings2);
        IntFunction<String[]> gen = len -> new String[len];
        String[] a = strings2.toArray(gen);

        System.out.println(Arrays.toString(a));*/


    }
}
