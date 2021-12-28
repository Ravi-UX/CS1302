# ce04 From Exceptional to Enhanced Cat

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

This class exercise is designed to familiarize students with exceptions and file I/O in Java.

## Prerequisite Knowledge

* Basic knowledge of Java exceptions, including checked exceptions, unchecked exceptions, and
  the use of `try`-`catch`, `throw`, and `throws`.
* Familiarity with program command-line arguments in Java.

## Course-Specific Learning Outcomes

* **LO2.b:** Define, throw, and propagate exceptions appropriately in a software solution.

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

## Exercise Steps

### Checkpoint 1 Steps

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce04`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce04.git
   ```

1. Change into the `cs1302-ce04` directory that was just created and look around. There should be
   multiple Java files somewhere in the directory structure. You may want to execute the `find` command
   on the `src` directory for a quick, easy-to-read view of the directory contents.

   * What are the fully qualified names for the classes contained in the Java files?
   * What is the path to the default package for _source code_ relative to the `cs1302-ce04`
     directory?

1. The directory you downloaded contains a Java implementation of the Unix `cat` utility. Remember, the commands
   you have been executing in Unix are just programs that were installed by the system administrators. `MyCat.java`
   works similarly to `cat` but was written by your instructors and will be compiled by you. Before compiling, use 
   the Unix `cat` utility to print the contents of `MyCat.java` to the terminal. Write the command you used to do 
   this in your notes.

1. Read through the Java code in `MyCat.java` and `Printer.java`. Note, there is a dependency between the two files.
   Based on the dependencies, which `.java` file must be compiled first?

1. From the `cs1302-ce04` directory, try to compile each Java file separately, specifying `bin`
   as the default package for _compiled code_. 

   **Note** In this step, you may encounter a compile-time (syntax) error. **Hint**: the error should not be 
   a "cannot find symbol" error. If it is, you will need to adjust your compilation command.
   
   Answer the following in your notes about the compile-time error:

   * In what file is the error?
   * On what line in the source code is the error?
   * How does Java describe the error?
   * Fix that specific compile-time error. There may be logical errors with the code--do not fix them at this time.
   * Briefly describe your fix.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps - Using and Enhancing Your Cat

1. From the `cs1302-ce04` directory, use your freshly compiled `MyCat` program to display the contents of
   `Printer.java` by passing the relative path to `Printer.java` as a command-line argument. 
   **HINT:** When a program interacts with files, it is relative to the current working directory in
   which the program is being run. That is, the directory you are in when you type the `java` command.
   For a Java program, relative paths are relative to that directory. 
   
1. Take a moment to note the similarties between using `MyCat` and the Unix `cat` utility.

1. From the `cs1302-ce04` directory, use the `MyCat` program to display the contents of standard input.
   **HINT:** Read through the code to see what command-line argument you might use to read from standard 
   input.
   This may seem weird at first, but the program should allow you to type in lines of text to standard
   input. When you complete a line by hitting return, the program will print the line to standard input.
   The program will terminate once it reaches the end of the file. What does that mean for standard
   input? You can trigger the end of file (a.k.a. the `EOF`) by pressing `C-d`.

1. From the `cs1302-ce04` directory, run the `MyCat` program with no command-line arguments. A run-time
   exception should occur. Answer the following questions about the exception in your notes:
   
   * What is the name of the exception?
   * Why did the exception occur?
   * Is this exception a checked or an unchecked exception? How can you tell?

1. There are multiple ways to fix the run-time exception that you encountered in the last step.
   Fix the problem in such a way that the following criteria are met whenever the exception occurs:
   
   * The program does not crash.
   * The exception message is stil displayed to standard error. To do this, you will need to call the
   `toString()` method on the exception object reference given in the `catch` statement.

   When displaying the exception message, something like the following will suffice 
   (replacing `<message>` with the actual exception message):

   ```
   MyCat: <message>
   ```

1. From the `cs1302-ce04` directory, run the `MyCat` program with no command-line arguments. What's the
   difference between this execution of the program and the one performed two steps earlier?

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps - Further Enhancing Your Cat

1. Now, let's add some more functionality to the `MyCat` program. Change the code so that one or more
   command-line arguments are accepted. The expected behavor is that `MyCat` should print the files, in
   order, to standard output, effectively con<b>cat</b>enating the contents of the supplied files.

1. From the `cs1302-ce04` directory, use your enhanced `MyCat` program to display the contents of the 
   following three files all passed in at once:`Printer.java`, standard input ("-"), and `MyCat.java` 
   in that order! If your program does not currently allow "-" to be specified for arbitrary file names 
   in the list of command-line arguments, then modify it to accomodate that feature.

1. Run your enhanced `MyCat` program by passing in two filenames as command-line arguments. Make sure
   the first file does not exist in the file system. Your program should catch the `FileNotFoundException`,
   print the appropriate message, and still print the contents of the second file (assuming it exists).
   
1. Update the comments in the source code to reflect any functionality that has been added since
   the beginning of this exercise.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>


### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce04`
   directory with the following information:

   1. Your name and UGA ID number; and
   1. Collaborator names, if any. 
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   ```

1. Change directories to the parent of `cs1302-ce04` (e.g., `cd ..` from `cs1302-ce04`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce04 csci-1302
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
