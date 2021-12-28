package cs1302.ce17;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * This class contains methods related to {@code cs1302-ce17}.
 */
public class LambdaFun {

    /** Standard Input scanner. */
    private static Scanner input = new Scanner(System.in);

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        String[] myStrings = new String[] {
            "CSCI",        "1302",    "is", "an", "awesome", "course!",
            "Lambda", "expressions", "scare", "me",     "but",       "I",
            "will",   "persevere"
        };
        Email[] inbox = new Email[] {
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 4), "Go GA Tech!"),
            new Email("bjb211@uga.edu", "mom@aol.com",
                      LocalDate.of(2019, 2, 5), "Have a good day!"),
            new Email("bjb211@uga.edu", "steve@anyotherschool.edu",
                      LocalDate.of(2019, 2, 6), "I wish I would've chosen UGA"),
            new Email("bjb211@uga.edu", "student1@uga.edu",
                      LocalDate.of(2019, 2, 7), "Thanks for teaching us!"),
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 8), "Go GA Tech!")
        };
        Predicate<String> p1 = (String s) -> s.contains("a");
        Predicate<String> p2 = (String s) -> s.length() > 4;
        Predicate<String> p3 = (String s) -> s.length() <= 2;
        Predicate<String> p4 = (String s) -> s.startsWith("c") || s.startsWith("C");
        System.out.println("Prints strings that contain the letter a");
        LambdaFun.printlnMatches(myStrings, p1);
        System.out.println("Prints strings that have a length greater than 4");
        LambdaFun.printlnMatches(myStrings, p2);
        System.out.println("Prints strings that have a length less than or equal to 2");
        LambdaFun.printlnMatches(myStrings, p3);
        System.out.println("Prints strings that start with the letter c (not case sensitive)");
        LambdaFun.printlnMatches(myStrings, p4);
        Predicate<Email> pe = (Email e) -> !e.getSender().contains("gatech.edu");
        Function<Email, String> f1 = (Email e) -> {
            return "Sender: " + e.getSender() +
                "\nRecipient: " + e.getRecipient() +
                "\nDate: " + e.getDateSent() +
                "\nContents: " + e.getContents() +
                "\n_________________________________________\n";
        };
        Function<Email, String> f2 = e -> {
            return e.getSender() + " sent: " +
                   e.getContents() + " on " + e.getDateSent() +
                   "\n\n------------------------------------------------\n";
        };
        Function<Email, String> f3 = e -> {
            return "Message from " + e.getSender() +
                   " says " + e.getContents() +
                   "\n\n************************************************\n";
        };
        System.out.println("______________________________________________________");
        System.out.println("Filter for spam messages in indbox.\n");
        System.out.println("Format 1");
        LambdaFun.printlnMappedMatches(inbox, pe, f1);
        System.out.println("Format 2");
        LambdaFun.printlnMappedMatches(inbox, pe, f2);
        System.out.println("Format 3");
        LambdaFun.printlnMappedMatches(inbox, pe, f3);

    } // main

    /**
     * Prints the elements of the array that pass the test specified by the given predicate.
     * More formally, this method prints all elements {@code e} in the array referred to by
     * {@code t} such that {@code p.test(e)}. Each element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @throws NullPointerException if the specified predicate is {@code null}
     */
    private static <T> void printlnMatches(T[] t, Predicate<T> p) {
        for (int i = 0; i < t.length; i++) {
            if (p.test(t[i])) {
                System.out.println(t[i]);
            }
        }
    } // printlnMatches

    /**
     * Prints the elements of the array that pass the test specified by the given predicate
     * using a string mapper. More formally, this method prints the string mapped elements
     * {@code f.apply(e)} in the array referred to by {@code t} for each {@code e} such that
     * {@code p.test(e)}. Each string mapped element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @param f the specified string mapper
     * @throws NullPointerException if the specified predicate or string mapper is {@code null}
     */
    private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f) {
        for (int i = 0; i < t.length; i++) {
            if (p.test(t[i])) {
                System.out.println(f.apply(t[i]));
            }
        }
    } // printlnMappedMatches

} // LambdaFun
