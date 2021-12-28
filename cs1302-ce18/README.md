
# cs1302-ce18 Generic Method Implementation

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> ```java
> String notSecret = "RmFsbCBCcmVhayE=";
> String decoded = new String(java.util.Base64.getDecoder().decode(notSecret));
> System.out.println(decoded);
> ```
> **-- Age Old Saying**

This class exercise explores functional interfaces, lambda expressions, and method
references in conjunction with generic methods and interfaces. In this exercise, 
only the generic method signatures will be provided. Implementation details are left 
to the student.

## Course-Specific Learning Outcomes

* **LO2.d:** (Partial) Implement new generic methods, interfaces, and classes in a software solution.
* **LO2.e:** (Partial) Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO4.a:** (Partial) Design, create and use interfaces in a software solution.
* **LO4.b:** (Partial) Utilize interface-based polymorphism in a software solution.

## Prerequisites

* [The Java™ Tutorials:  Generic Methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html)
* [The Java™ Tutorials:  Lambda Expression](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
* [The Java™ Tutorials:  Method References](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)

## References

* [`java.util.function.Predicate` Interface Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html)
* [`java.util.function.Function` Interface Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Function.html)
* [`java.util.function.IntFunction` Interface Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/IntFunction.html)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce18`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce18.git
   ```

1. Change into the `cs1302-ce18` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

## Exercise Steps

### Checkpoint 1 Steps

1. Take a close look at the `printlnMappedMatches` method and its associated Javadoc in `MoreLambdaFun.java`. 
   The exact signature for this method is:
   ```java
   private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f)
   ```
   Implement the `printlnMappedMatches` method in `MoreLambdaFun.java`. You do not need to use a lambda for this step.
   You will only need to use the 
   [`Function<T, R>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Function.html) 
   and 
   [`Predicate<T>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html)
   references to call the appropriate methods.
   
1. At the end of the `main` method of `MoreLambdaFun` class:

   1. Declare a variable `bonusPred` of type `Predicate<Quiz>` and assign to it, using a lambda expression, a reference to
      an object that tests if the quiz is a bonus quiz. Remember, you can always refer to the API documentation
      for the associated interface when trying to determine the layout of your lambda.

   1. Declare a variable `numberFunc` of type `Function<Quiz, String>` and assign to it, using a lambda expression, 
      a reference to an object that takes a `Quiz` object as a parameter and returns a `String` containing
      the quiz number and at least one other piece of information about the quiz (other than bonus).
      Remember, you can always refer to the API documentation for the associated interface when trying 
      to determine the layout of your lambda.
   
1. Call the `printlnMappedMatches` using your newly created variables.
   Make sure to provide sufficient output so that it will be easy to 
   convince your TA or instructor that everything is working properly.
   
1. Compile your code and run it. Then, stage and commit all changes.
   
1. Using lambdas, write the code to print quiz numbers for all quizes that have a time limit that is under
   twenty minutes. Make sure to provide sufficient output so that it will be easy to 
   convince your TA or instructor that everything is working properly.
   
1. Make sure your code passes the `checkstyle` audit then stage and commit all changes.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Take a close look at the `copyOf` method and its associated Javadoc in `MoreLambdaFun.java`. 
   The exact signature for this method is:
   ```java
   public static <T> T[] copyOf(T[] a, int l, IntFunction<T[]> g)
   ```
   Answer the following questions about this method in your notes:
   
   1. What is the generic type parameter?
   
   1. Specifically, what reference types can replace `T`?
   
   1. In order to call this method, we need a reference to an object of a class that implements 
     `IntFunction<T[]>`. The interface is defined as 
     [`IntFunction<R>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/IntFunction.html). 
     Here, we replace `R` with `T[]`. Keep this in mind when inspecting the API documentation 
     for `IntFunction<R>`.
     
     **Hint:** See the [`toArray` documentation from the `GenList` project](http://csweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#toArray-java.util.function.IntFunction-),
      which also takes an `IntFunction` parameter.
	 
   1. Write the full, expanded method signature (with the replaced types) of the single, abstract method
      of `IntFunction<T[]>` in your notes. Pay careful attention to the return type and the type of the 
      formal parameter.

1. After carefully reading its Javadoc comment, implement the `copyOf` method in `MoreLambdaFun.java`. 
   You do not need to use a lambda for this step.
   
1. Stage and commit all changes.

1. At the end of the `main` method of the `MoreLambdaFun` class:

   1. Declare a variable `lessQuizzes` of type `Quiz[]` and, using your `copyOf` method, assign to it 
      a copy of the array referred to by `quizzes` containing half as many quizzes (containing
      the first half of the quizzes). You should supply the `g` parameter 
      **using a regular lambda expression**.
      
      **Hint:** See the [`toArray` documentation from the `GenList` project](http://csweb.cs.uga.edu/~mec/cs1302-genlistadt-doc/cs1302/genlistadt/GenList.html#toArray-java.util.function.IntFunction-),
      which also takes an `IntFunction` parameter.
      
   1. Using a for-each loop, print the quiz numbers of all `Quiz` references in `lessQuizzes`.

   1. Declare a variable `moreQuizzes` of type `Quiz[]` and, using your `copyOf` method, assign to it 
      a copy of the array referred to by `quizzes` containing four (4) more spots for quizzes
      (all `null`). You should supply the `g` parameter **using an array constructor method reference**. 
      
   1. Using an appropriate loop, print the quiz numbers of all non-null `Quiz` references in `moreQuizzes`. 
      Also, print the length of the array to make sure it is the proper size.

1. Make sure your code passes the `checkstyle` audit then stage and commit all changes.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Create and document a `static` method called `makeQuizArray` that, if written correctly, a method 
   reference for that method can be used to supply the `g` parameter in a call to your
   `copyOf` method. Then, at the end of the `main` method of the `MoreLambdaFun` class:
   
   1. Declare a variable `twentyQuizzes` of type `Quiz[]` and, using your `copyOf`, assign to it 
      a copy of the array referred to by `quizzes` containing twenty spots for quizzes (with 
      trailing `null` values as described in the Javadoc for `copyOf`). You should supply the `g` 
      parameter **using a method reference** to the method you created in the previous step. 
   1. Using an appropriate loop, print the quiz numbers of all non-null `Quiz` references in 
      `twentyQuizzes`. Also, print the length of the array to make sure it is the proper size.
	  
1. Make sure your code passes the `checkstyle` audit then stage and commit all changes.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce18`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. If you created the API website, include the full link to the site you generated.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce18-doc
   ```

1. Change directories to the parent of `cs1302-ce18` (e.g., `cd ..` from `cs1302-ce18`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce18 csci-1302
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
