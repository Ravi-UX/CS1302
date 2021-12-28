# cs1302-ce13 Java Generics

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> Be careful what you wish for, lest it come true.
> **--Chinese Proverb**

This class exercise covers introduces the reader to Java Generics, a powerful way to write classes,
interfaces, and methods using a type parameter. It also introduces students to time travel using Git.

Generics are used when you want to apply the exact same implementation (code) to various types.
Contrast this with inheritance which is used when you need common functionality to be implemented
in different ways. Think of a `getPerimeter()` method that can be applied to references to objects
of type `Circle` and `Square`. These classes both contain the `getPerimeter()` method but the
implementations depend on the type.

## Prerequisite Knowledge

* Basic knowledge of [Java Generics](https://github.com/cs1302uga/cs1302-tutorials/blob/master/generics/generic-classes/generic-classes.md)
* [Git Glossary](https://mirrors.edge.kernel.org/pub/software/scm/git/docs/gitglossary.html)

## Course-Specific Learning Outcomes

* **LO2.d:** (Partial) Implement new generic methods, interfaces, and classes in a software solution.
* **LO5.a:** (Partial) Utilize a version control tool such as Git or Subversion to store and
update source code in a multi-programmer software solution.

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

## Exercise Steps

### Checkpoint 1 Steps - Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce13`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce13.git
   ```

1. Change into the `cs1302-ce13` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

   A UML diagram for the classes contained in this directory (excluding the `Driver`) can be seen below:
   
   ![UML Diagram](res/ce13.png)
      
1. For each line in the `createStringList` method in `Driver.java`, draw a diagram that illustrates any objects
   (you may think of them as nodes) that have been created along with their associated `content` values
   values and `next` values. For reference types, you would either need to denote it as `null` or draw an 
   arrow to the object it references. If a reference variable refers to a `String` object, then you may 
   represent the object as a literal within the `ObjectContainer` object.
   * **Redraw the entire picture after each line.**
   * Number each step in your notes. 
   * Reference variables that are not contained in
     `ObjectContainer` objects should also be included in the diagram.

1. Compile the starter code using `bin` as the default package for compiled code. Make sure you compile
   the classes in the proper order considering the dependencies.
   
1. Run `Driver`. If you counter an exception, then detail the following in your notes:
   1. The complete output of the JVM;
   1. Why the exception was thrown;
   1. Fix the code without changing the datatype of the `lastDouble` variable;
   1. Recompile;
   1. Note the attempted fix; then
   1. Repeat as needed.

1. Commit the changes to your local copy of the exercise repository. Be sure to include a good log message.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Now that you have that working, let's use Git to go back in time to what the exercise
   directory looked like when you first cloned the repository so that we can fix the code
   using generics. The following steps make use of Git-related jargon. You may find the
   [official glossary](https://mirrors.edge.kernel.org/pub/software/scm/git/docs/gitglossary.html)
   useful when new terms are used.

   1. Use the following command to view a condensed, graphical version of the Git log:

      ```
      $ git log --all --decorate --oneline --graph
      ```

      The oldest commit in the log is displayed last. In this condensed version, each
      line displays a commit with its associated log message as well as other important
      pieces of information. Here is an example of a similar commit entry in a log (yours
      may differ):
      
      ```
      * d70a020 (HEAD, origin/master, origin/HEAD, master) updated description      
      ```
      
      In this example:
      * `d70a020` is a hexadecimal number that serves as a checksum/identifier for the commit;
      * `(HEAD, origin/master, origin/HEAD, master)` denotes branch names for the commit;
      * `HEAD` indicates that this commit is currently checked out; and
      * the rest of the lines is the associated log message.
      
   1. In your notes, write down the complete line for the most recent commit displayed in your log.
   
   1. Now, use the following command to check out the oldest commit in your log and give
      it a branch name called `restart`, replacing `IDNUM` with the hexadecimal
      identifier for that commit:

      ```
      $ git checkout IDNUM -b restart
      ```
      
   1. Confirm that you traveled through time by inspecting the contents of the `Driver.java`
      file. The original bug should now be present in your code. In your notes, mark today's 
      date as the day that you became a time traveler!

1. **Please read this bullet and all sub-bullets before continuing.** 
   Let's create a new generic version of the `ObjectContainer` class called
   `cs1302.ce13.Container` with a type parameter called `ContentType` or just `T`. 
   
   1. Use the `cp` command to copy and rename the `ObjectContainer.java`
      to `Container.java`.
      
   1. To help you get started with the new class, open `Container.java` in Emacs, then 
      use `M-x` followed by the complete word `replace-string` (usually abbreviated as 
      `M-x replace-string`) to help you replace `ObjectContainer` with `Container`. 
      **If you mess up, remember that you can undo. If you mess up a lot, you can delete
      the file and make another copy of the original `ObjectContainer.java` file.**
   
   1. Tell Git to track changes on `Container.java`, then commit your recent changes to 
      your local copy of the exercise repository. Be sure to include a good log message.

   1. Before you continue to write / modify the code further, draw a UML diagram in your 
      notes to illustrate what the class will look like after you make it generic. You may 
      denote any type parameters next to the class name in your diagram similar to how you would 
      write them in the class's signature in the `.java` file. Your type parameter can have
      any name you choose. You've probably seen us use `<ContentType>` but the Java convention
      is to use `<T>`.
      
      **Except for the constructor names (which should be written simply as `Container`),**
      any use of the datatype `Container` needs to be fully parameterized. That is, we are 
      explicitly requiring that you not use the raw type version of `Container` when updating 
      your code for this step.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Now update the source code and documentation for the generic `cs1302.ce13.Container` class.
   Since your class will have a type parameter, be sure to include an `@param` for `<ContentType>`
   or `<T>` in your Javadoc comment for the class -- something that you've likely not had to do in
   the past. 
   
   * **NOTE:** The FQN for this class is `cs1302.ce13.Container`. Note carefully that the generic
     type parameter is not included in the FQN. 

1. Compile your new `Container` code using `bin` as the default package for compiled code.
   If you encounter any compilation errors:
   
   1. Look at the first error reported by `javac`;
   1. Write the error down in your notes;
   1. Fix the error in the code using type casting;
   1. Recompile;
   1. Note the fix in your notes; then
   1. Repeat as needed.

1. Make sure your code passes the `checkstyle` audit.

1. Generate the API documentation website for all of the code in the `cs1302` package
   into the `doc` directory. What is the URL for the `Container` class on your website?

1. Commit the changes to your local copy of the exercise repository.
   Be sure to include a good log message.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Checkpoint 4 Steps

1. Update and document the `Driver` class to use your generic `Container` class instead of
   `ObjectContainer`. At this time, **do not fix the bug that you found in the first checkpoint**.
   Also, do not change the datatypes of any non-container local variables
   (i.e., do not change the types for `lastString` and `lastDouble`). Whenever you refer to
   the type for your container class, it must be fully parameterized. That is, we are explicitly
   requiring you not to use the raw type version of `Container` for this step.

1. Run the code. If you encounter any compile-time error, then
   detail the following in your notes:
   1. The complete output of the compiler;
   1. Why the exception was thrown;
   1. Fix the code;
   1. Recompile;
   1. Note the attempted fix; then
   1. Repeat as needed.

1. Commit the changes to your local copy of the exercise repository.
   Be sure to include a good log message.

1. Consider the errors you encountered in the last step compared the errors you encountered
   in the previous checkpoint with your old version of the code. Were there any errors that you
   encountered at compile time instead of run-time? If so, **what and why?**

1. In your notes, write down the full statements for each of the following
   variable declarations in the `Driver` class:
   * `stringHead`
   * `lastString`
   * `doubleHead`
   * `lastDouble`

1. View the output of a condensed, graphical version of the Git log.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-4-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce13`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. The full link to the website generated in this exercise.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce13-doc
   ```

1. Change directories to the parent of `cs1302-ce13` (e.g., `cd ..` from `cs1302-ce13`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce13 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the submit command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
