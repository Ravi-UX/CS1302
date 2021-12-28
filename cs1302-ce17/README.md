
# cs1302-ce17 Generic Method Implementation

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> ```java
> String notSecret = "VUdBIGlzIGJldHRlciB0aGFuIEdBIFRlY2g=";
> String decoded = new String(java.util.Base64.getDecoder().decode(notSecret));
> System.out.println(decoded);
> ```
> **-- Proven Fact**

This class exercise explores functional interfaces and lambda expressions in
conjunction with generic methods and interfaces. In this exercise, only the generic
method signatures will be provided. Implementation details are left to the student.

## Course-Specific Learning Outcomes

* **LO2.d:** (Partial) Implement new generic methods, interfaces, and classes in a software solution.
* **LO2.e:** (Partial) Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO4.a:** (Partial) Design, create and use interfaces in a software solution.
* **LO4.b:** (Partial) Utilize interface-based polymorphism in a software solution.

## References and Prerequisites

* [The Java™ Tutorials: Generic Methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html)
* [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
* [`java.util.function.Predicate` Interface Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html)
* [`java.util.function.Function` Interface Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Function.html)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce17`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce17.git
   ```

1. Change into the `cs1302-ce17` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```
1. **NOTE:** In this exercise, you will be referring to multiple generic interfaces, some of which
   have two generic type parameters. It's very important that you keep keep parameter composition 
   in mind when referring to the API documentation. For example, consider the following code snippets
   that illustrate type parameter composition:
   
   ```java
   public interface SomeInterface<A> {
       A foo();
   } // SomeInterface
   ```
   
   ```java
   public static <T> void bar(SomeInterface<T> si) {
       T var = si.foo(); // foo returns T, because A is replaced with T
   } // bar
   ```

## Exercise Steps

### Checkpoint 1 Steps

1. `LambdaFun.java` contains method signatures and documentation for three generic methods. We will implement
    and test these methods in the order that they appear in the Java program, starting with `printlnMatches`. 
    The exact signature for this method is:
    ```java
    private static <T> void printlnMatches(T[] t, Predicate<T> p)
    ```
    Answer the following questions about this method in your notes:
    1. What is the generic type parameter?
    1. Specifically, what reference types can replace `T`?
    1. In order to call this method, we need a reference to an object of a class that implements 
       [`Predicate<T>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html). 
       `Predicate<T>` is a functional interface. **Write the full method signature of the single, abstract method
       of this class in your notes.** Pay careful attention to the return type and the type of the formal parameter.
      
1. Implement the `printlnMatches` method in `LambdaFun.java`. **You do not need to use a lambda for this step.**
   You will only need to use the object of type `Predicate<T>` referred to by `p` to call the appropriate method.
   If you did the previous step, then you know what method(s) can be called with `p`. Implement this `printlnMatches`
   method using some code that, uses `p`.
   
1. At the end of the `main` method of `LambdaFun` class:
   1. Declare a variable of type `Predicate<String>`.
   1. Initialize the variable using a lambda expression which provides an implementation for the single, abstract
      method of the `Predicate<String>` interface. See the 
      [Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax)
      if you're still unsure about the syntax. Use your answer for **1.iii.** to help you write this lambda.
   1. This lambda should return `true` if the string argument contains the letter `"a"` (case sensitive).
      You may wish to refer to the documentation for `java.lang.String`, provided
      [here](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html).
   
1. Variable `p` now references an object of type `Predicate<String>`. **HOLD THE FRONT DOOR!** That one line of code
   created a class that implemented an interface and created an object of that class! It must be the case since
   `p` is a reference variable of an interface type and the code compiles. This object contains a specific implementation
   of the single abstract method in the interface.
   
1. Call `printlnMatches` by passing in array `myStrings` along with your newly created `Predicate<String>` variable.

1. Compile and run your code. You will know if everything is working correctly if the method only prints strings 
   containing the letter `"a"`.

1. Stage and commit all changes.
   
1. Create three additional `Predicate<String>` objects to further test your `printlnMatches` method on the same
   array. **Try to make them interesting!** Make sure to provide sufficient output so that it will be easy to 
   convince your TA or instructor that everything is working properly.
   
1. Make sure your code passes `checkstyle` then stage and commit all changes.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Take a close look at the `printlnMappedMatches` method and its associated Javadoc in `LambdaFun.java`. 
   The exact signature for this method is:
   ```java
   private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f)
   ```
   Answer the following questions about this method in your notes:
   * What is the generic type parameter?
   * Specifically, what reference types can replace `T`?
   * In order to call this method, we need a reference to an object of a class that implements 
     [`Function<T, String>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Function.html)
     and a reference to an object of a class that implements `Predicate<T>`. Similar to `Predicate<T>`,
     `Function<T, R>` is a functional interface. Write the full method signature of the single, abstract method
     of `Function<T, R>` in your notes. Pay careful attention to the return type and the type of the formal parameter.
     **Note**: The method *can* (but doesn't have to) return a datatype that is different from the datatype of the 
     parameter.
     
1. Implement the `printlnMappedMatches` method in `LambdaFun.java`. You do not need to use a lambda for this step.
   You will only need to use the `Function<T, R>` and `Predicate<T>` references to call the appropriate methods.
   
1. At the end of the `main` method of `LambdaFun` class:
   * Declare a variable of type `Predicate<Email>` and assign to it, using a lambda expression, a referene to
     an object that tests if the sender of the email does not have a `"gatech.edu"` email address 
     (we'll "pretend" that they go to the spam filter). Remember, you can always refer to the API documentation
     for the associated interface when trying to determine the layout of your lambda.
   * Declare a variable of type `Function<Email, String>` and assign to it, using a lambda expression, a reference
     to an object that takes an `Email` object as a parameter and return the contents of the email as some
     nicely formatted `String`. Remember, you can always refer to the API documentation
     for the associated interface when trying to determine the layout of your lambda.
   
1. Call the `printlnMappedMatches` using your newly created variables to filter out emails in the array referred
   to by `inbox` from our rival school. Make sure to provide sufficient output so that it will be easy to 
   convince your TA or instructor that everything is working properly.
   
1. Stage and commit all changes.
   
1. Create two additional `Function<Email, String>` objects to further test your `printlnMappedMatches` method on the same
   array with the same predicate. In other words, you can provide different ways to print out the emails. 
   Make sure to provide sufficient output so that it will be easy to convince your TA or instructor that 
   everything is working properly.
   
1. Make sure your code passes `checkstyle` then stage and commit all changes.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce17`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. If you created the API website, include the full link to the site you generated.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce17-doc
   ```

1. Change directories to the parent of `cs1302-ce17` (e.g., `cd ..` from `cs1302-ce17`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce17 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the submit command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/) [![License: CC BY-NC 4.0](https://img.shields.io/badge/Instructor%20License-CC%20BY--NC%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Bradley J. Barnes, and the University of Georgia.
This work is licensed under 
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public and licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a> to instructors at institutions of higher education.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
