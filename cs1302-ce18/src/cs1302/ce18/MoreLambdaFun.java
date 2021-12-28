package cs1302.ce18;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * This class contains methods related to {@code cs1302-ce18}.
 */
public class MoreLambdaFun {

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        Quiz[] quizzes = new Quiz[] {
            new Quiz(1,  20, false, 100),
            new Quiz(2,  20, false, 100),
            new Quiz(3,  10,  true,  10),
            new Quiz(4,  10, false,  20),
            new Quiz(5, 100,  true, 100), // 100 pt. bonus quiz?!?
        };

        Predicate<Quiz> bonusPred = (Quiz q) -> q.isBonus();
        Function<Quiz, String> numberFunc = (Quiz q) -> {
            return "Quiz number: " + q.getNumber() + "\nPoints: " + q.getPoints();
        };
        System.out.println("Bounus Quizzes: ");
        MoreLambdaFun.printlnMappedMatches(quizzes, bonusPred, numberFunc);

        Predicate<Quiz> timePred = (Quiz q) -> q.getTimeLimit() < 20;
        Function<Quiz, String> numberFunc2 = (Quiz q) -> {
            return "Quiz number: " + q.getNumber();
        };
        System.out.println("Quizzes shorter than 20 minutes: ");
        MoreLambdaFun.printlnMappedMatches(quizzes, timePred, numberFunc2);

        Quiz[] lessQuizzes = copyOf(quizzes, quizzes.length / 2,
            (int n) -> {
                return new Quiz[n];
            }
        );
        System.out.println("First half of Quizzes: ");
        for (Quiz q : lessQuizzes) {
            System.out.println("Quiz Number: " + q.getNumber());
        }

        Quiz[] moreQuizzes = copyOf(quizzes, quizzes.length + 4,
            (int n) -> {
                return new Quiz[n];
            }
        );
        System.out.println();
        System.out.println("More Quizzes: ");
        System.out.println("Length of copy: " + moreQuizzes.length);
        for (int i = 0; i < quizzes.length; i++) {
            System.out.println("Quiz Number: " + moreQuizzes[i].getNumber());
        }

        Quiz[] twentyQuizzes = copyOf(quizzes, 20, MoreLambdaFun::makeQuizArray);
        System.out.println();
        System.out.println("Twenty Quizzes: ");
        System.out.println("Length of copy: " + twentyQuizzes.length);
        for (int i = 0; i < quizzes.length; i++) {
            System.out.println("Quiz Number: " + twentyQuizzes[i].getNumber());
        }

    } // main

    /**
     * Prints the elements of the array that pass the test specified by the
     * given predicate using a string mapper. More formally, this method prints
     * the string mapped elements {@code f.apply(e)} in the array referred to by
     * {@code t} for each {@code e} such that {@code p.test(e)}. Each string
     * mapped element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @param f the specified string mapper
     * @throws NullPointerException if the specified predicate or string mapper
     *                              is {@code null}
     */
    private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f) {
        for (int i = 0; i < t.length; i++) {
            if (p.test(t[i])) {
                System.out.println(f.apply(t[i]));
                System.out.println();
            }
        }
    } // printlnMappedMatches

    /**
     * Returns a copy of the specified array, truncating or padding with nulls
     * (if necessary) so that the copy has the specified length. For all
     * indices that are valid in both the original array and the copy, the two
     * arrays will contain identical values. For any indices that are valid in
     * the copy but not the original, the copy will contain {@code null}. Such
     * indices will exist if, and only if, {@code l} is greater than
     * {@code a.length}. The resulting array is created using {@code g}.
     *
     * @param <T> the type of the array elements.
     * @param a the array to be copied
     * @param l the length of the copy to be returned
     * @param g a function which produces a new array of the desired type and length
     * @return a copy of the original array with the specified length
     * @throws NegativeArraySizeException if {@code l} is negative
     * @throws NullPointerException if {@code a} or {@code g} is {@code null}
     */
    public static <T> T[] copyOf(T[] a, int l, IntFunction<T[]> g) {
        T[] t = g.apply(l);
        for (int i = 0; i < l; i++) {
            if (i < a.length) {
                t[i] = a[i];
            } else {
                break;
            }
        }
        return t;
    } // copyOf

    /**
     * Creates and returns a new array of type {@code Quiz} and of length {@code n}.
     * @param n the desired size of the new array
     * @return a new array of type Quiz and length n
     */
    public static Quiz[] makeQuizArray(int n) {
        return new Quiz[n];
    }

} // MoreLambdaFun
