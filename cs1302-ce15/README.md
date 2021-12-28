
# cs1302-ce15 Genericize is still a Real Word

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> (Sends Dancing Hot Dog Meme)
> Hotdogs are generic.
> You have: bagel dogs, brat dogs, cheese dogs, chicago dogs, chili dogs, coney dogs, corn dogs (?), etc.
> **--Dr. Supa' Mike, after a 12 hour work day.**

This class exercise continues coverage of generic methods, including some checkpoints related to
upper bounds. 
It also provides a small demonstration of branching and merging using Git.

## Course-Specific Learning Outcomes

* **LO2.d:** (Partial) Implement new generic methods, interfaces, and classes in a software solution.
* **LO5.a:** (Partial) Utilize a version control tool such as Git or Subversion to store and
update source code in a multi-programmer software solution.

## References and Prerequisites

* [1302 Generic Classes Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/generics/generic-classes/generic-classes.md)
* [1302 Generic Methods Reading](https://github.com/cs1302uga/cs1302-tutorials/blob/master/generics/generic-methods/generic-methods.md)
* [Oracle: Generic Methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html)
* [Oracle: Bounded Type Parameters](https://docs.oracle.com/javase/tutorial/java/generics/bounded.html)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce15`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce15.git
   ```

1. Change into the `cs1302-ce15` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

## Exercise Steps

### Checkpoint 1 Steps

Some of the steps below are similar to the steps in the previous exercise. You are expected
to start from scratch at this checkpoint with the starter code provided by this exercise.

1. Examine the generic static `checkNull` method in the `cs1302.Utility` 
   class.

   1. What is the complete signature for this method?
   1. In previous exercises, the `checkNull` method was not generic. Instead, it used `Object` as
      the type of the varargs parameter. How is the generic version different? Feel free to use
      a specific example in your explanation.
   1. Suppose you want to parameterize `T` (i.e., replace it with some specific type). 
      What requirement must that type satisfy?
   
1. Create and checkout a branch called `driver` to perform
   the work related to this checkpoint. You can do this using
   the following command:
   
   ```
   $ git checkout -b driver
   ```
   
1. Confirm that you are on the desired branch using `git status` and/or
   `git branch`.
   
1. **NOTE:** When checking the next step, your instructor or PLA will look 
   at the list of things you tried. You should have a log entry for each. 
   They will not sign off on this checkpoint if you do 
   not do the steps above for each and every error as 
   _errors are expected_ if you perform the steps correctly.

1. **Really, please read the previous step before continuing.**
   Now, open the `Driver` class found in the `cs1302.ce15` package. 
   Write code in the `main` method to demonstrate that the `checkNull` method 
   only accepts references that are all the same type. Since Java
   allows for subtype assignment to parent variables, also check that
   you can supply references to objects that are children of the type 
   you specify. You may make use of the `Shape`, `Ellipse`, and `Circle` 
   classes that are in the same package. Try other types as well (`String`,
   `Object`, etc.).
   
   Try at least 5 statements with various types. Feel free to use the objects that
   are provided in `Driver.java`. Make sure at least two of your calls
   to `checkNull` result in compile-time errors. 

   When you encounter compilation errors:
   
   1. Look at the first error reported by `javac`;
   1. Write down the entire statement (instruction) that caused the error.
   1. Summarize the error message down in your notes;
   1. In your notes, denote whether or not this error is expected;

      1. If **yes**, then keep the line in your code but comment it 
	 out, and include the reason why it's expected in your notes.
	 
      1. If **no**, then fix the error in the code.
	  
   1. Recompile;
   1. Stage and commit your changes using Git; and
   1. Repeat as needed. 

1. Now that everything on this branch compiles, ensure that all changes 
   in the current branch have been staged and committed, then 
   checkout the `master` branch.
   
1. Make sure all of your code passes the `checkstyle` audit.

1. Merge changes from the `driver` branch into the current branch
   (`master`).

1. View the condensed, graphical version of your Git log using `git adog`
   from the previous class exercise.
   What is the entire line of output for the most recent entry produced
   by the `git adog` command?

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Delete all of the code contained in your `Driver` class's `main` method (including what was there in 
   the beginning), then stage and commit this change to your local copy of the exercise repository. Don't 
   worry, you can also checkout what you had before because you committed your earlier changes while working 
   on the previous checkpoint.
   
1. Now add the following code to your `Driver` class's `main` method, make sure it compiles, then 
   commit this change to your local copy of the exercise repository.
   
   ```
   String[] strings = new String[] {
       "bb",
       "aa",
       "dd",
       "cc"
   };
   
   Circle[] circles = new Circle[] {
       new Circle(5.0),
       new Circle(3.3),
       new Circle(4.1),
       new Circle(1.2)
   };
   ```
   
   We will come back to this code in a few steps.

1. You may have noticed `cs1302-ce15.jar` in the `lib` subdirectory. Use the `jar` command along with the `-tf`
   and the relative path to the file to output a list of the file's contents to the terminal. In your notes, 
   write down the name of the class file contained in the jar file. The API documentation for the compiled code 
   contained in this file can be found [here](http://cobweb.cs.uga.edu/~mec/cs1302/cs1302-ce15-api/)
   [[mirror]](https://michaelcotterell.com/cs1302-ce15-api/).
   
1. Examine the [`ArrayUtility.sort(T[])`](http://cobweb.cs.uga.edu/~mec/cs1302/cs1302-ce15-api/cs1302/util/ArrayUtility.html#sort-T:A-)
   [[mirror]](https://michaelcotterell.com/cs1302-ce15-api/cs1302/util/ArrayUtility.html#sort-T:A-)
   method overload in the `cs1302.util.ArrayUtility` API documentation. Read the full paragraph 
   under the "Method Detail" section.
   
   In your notes, answer the following:
   
   1. What is the complete signature for this method?
   1. What is the datatype and purpose/role of each method parameter?
   1. Suppose you want to parameterize `T` (i.e., replace it with some specific type). 
      What requirement must that type satisfy?
   
1. Let's be confident that `ArrayUtility.sort` works as advertised. Modify your `Driver` class 
   to print out the contents of the `strings` array _before_ and _after_ calling
   `ArrayUtility.sort` on it. You may find it helpful to write a generic static method in
   the `Driver` class that prints an array of any type. Also, don't forget to put the
   jar file on your classpath!
   
   * Be sure to compile and run your driver to test it.
   * **As you go, stage and commit your changes using Git.**
     Be sure to include a good log message.

1. Now try to do the same thing with the `circles` array. When printing a `Circle`, print
   its radius. When you get a compile error, please read the **entire** error message and:
   
   1. Summarize the error message in your notes.
   1. Why does the method compile for the `strings` array and not the `circles` array? 
   
1. Comment out the code that caused the error, save, then stage and commit all changes.
   
1. View the condensed, graphical version of your Git log using `git adog`
   from the previous class exercise.
   What is the entire line of output for the most recent entry produced
   by the `git adog` command? 
   
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. **[TRICKY]** _Read this entire step, including substeps, very carefully before attempting it._ 
   Modify the source code for the `Circle` class so that `Circle` satisfies the requirement to 
   replace `T` when calling [`ArrayUtility.sort(T[])`](http://cobweb.cs.uga.edu/~mec/cs1302/cs1302-ce15-api/cs1302/util/ArrayUtility.html#sort-T:A-). 
   Your modification should result in the induced ordering for `Circle` objects to be based on their radius values, in ascending (increasing)
   order. 
   
   * As you attempt this, remember that the goal is to allow the `T` to be replaced with `Circle`
     when calling the `sort` method. This means that you can test whether or not you've done this
     correctly by appropriately calling `ArrayUtility.sort` on the array referred to by `circles`
     in your `Driver` class's `main` method. You will know that you satisfy the type requirement
     when the `Driver` class compiles.
     
   * The method that you need to implement should return an `int` value depending on
     how the calling object's radius relates to the radius of another object referred to by a
     method parameter. You can supply both radius values to the static 
     [`Double.compare`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Double.html#compare(double,double))
     method in a particular order to get the desired `int` value. 
     
   * Once you are sure that the type requirement is being satisfied, you can test that your
     induced ordering is correct by looping through the array referred to by `circles` and 
     printing out the return value of `toString()`. This should be done after your call to `sort`.
	 
   * **As you go, stage and commit your changes using Git.**
     Be sure to include a good log message.
     
1. View the condensed, graphical version of your Git log using `git adog`
   from the previous class exercise.
   What is the entire line of output for the most recent entry produced
   by the `git adog` command?   
   
1. Make sure all code passes `checkstyle`.
   
1. **Food for thought** Could we have modified `Shape` instead of `Circle` to allow the `sort`
   method to sort arrays containing any concrete subclass of `Shape`? If so, would we need to 
   change how we do the comparisons?

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Checkpoint 4 Steps

1. In the previous checkpoint, you were able to modify the `Circle` class so that arrays of
   circles can be sorted using `ArrayUtility.sort`. However, consider what would happen if
   you now wanted to sort according to a different ordering (e.g., area or perimeter). You
   would have to edit `Circle.java` again! This is where the other overload for `sort` 
   comes into play. Examine the 
   [`ArrayUtility.sort(T[], Comparator<T>)`](http://cobweb.cs.uga.edu/~mec/cs1302/cs1302-ce15-api/cs1302/util/ArrayUtility.html#sort-T:A-java.util.Comparator-)
   method overload in the `cs1302.util.ArrayUtility` API documentation 
   [[mirror]](https://michaelcotterell.com/cs1302-ce15-api/cs1302/util/ArrayUtility.html#sort-T:A-java.util.Comparator-).
   Read the full paragraph under the "Method Detail" section.
   In your notes, answer the following:
   
   1. What is the complete signature for this method?
   1. What is the datatype and purpose/role of each method parameter?
   1. Suppose you want to parameterize `T` (i.e., replace it with some specific type). What requirement must that type satisfy?

1. **[TRICKY]** _Read this entire step, including substeps, very carefully before attempting it._ 
   Create a class called `AreaComparator` in the `cs1302.ce15` package that correctly
   implements the comparator required for the overloaded `ArrayUtility.sort` when parameterized 
   to operate on arrays of type `Circle`. The induced ordering for `Circle` objects here should
   be based on their area values, in descending (decreasing) order. 

   * As you attempt this, remember that the goal is to allow you to sort arrays of circles using
     `ArrayUtility.sort` by some other ordering criteria **without** modifying `Circle.java`. This
	 involved creating a proper class for the comparator, then calling the `sort` method with
	 and object of that comparator class. You can test whether or not the comparator class is
	 snytactically correct by calling the overloaded `ArrayUtility.sort` on the array referred to 
	 by `circles` in your `Driver` class's `main` method. You will know that it is syntactically correct 
     	when the `Driver` class compiles.
	 
   * Once you are sure that comparator class is syntactically correct, then you can test that your
	 comparator's induced ordering is correct by looping through the array referred to by `circles` and 
	 printing out the return value of `getArea()`. This should be done after your call to `sort`.

   * **As you go, stage and commit your changes using Git.**
     Be sure to include a good log message.
   
1. View the condensed, graphical version of your Git log using `git adog`
   from the previous class exercise.
   What is the entire line of output for the most recent entry produced
   by the `git adog` command?   
   
1. Make sure all code passes `checkstyle`.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-4-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce15`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. If you created the API website, include the full link to the site you generated.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce15-doc
   ```

1. Change directories to the parent of `cs1302-ce15` (e.g., `cd ..` from `cs1302-ce15`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce15 csci-1302
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
