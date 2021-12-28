# cs1302-ce14 Genericize is a Real Word

![Approved for: Fall 2020](https://img.shields.io/badge/Approved%20for-Fall%202020-blueviolet)

> Moon's haunted. 
> **--Astronaut**

This class exercise covers introduces the reader to generic methods.
It also provides a small demonstration of branching and merging using Git.

## Course-Specific Learning Outcomes

* **LO2.d:** (Partial) Implement new generic methods, interfaces, and classes in a software solution.
* **LO5.a:** (Partial) Utilize a version control tool such as Git or Subversion to store and
update source code in a multi-programmer software solution.

## References and Prerequisites

* [1302 Generic Classes Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/generics/generic-classes/generic-classes.md)
* [1302 Generic Methods Reading](https://github.com/cs1302uga/cs1302-tutorials/blob/master/generics/generic-methods/generic-methods.md)
* [Oracle: Generic Methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

## Exercise Steps

### Checkpoint 1 Steps

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-ce14`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce14.git
   ```

1. Change into the `cs1302-ce14` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

1. **Compile all of the supplied code,** specifiying `bin` as the default package for
   compiled code.
   
1. Create and checkout a branch called `genericize` to perform
   the work related to this checkpoint. You can do this using
   the following command:
   
   ```
   $ git checkout -b genericize
   ```
   
   **EXPLANATION:** When you create a branch, it is as if Git makes a copy of the current
   branch without the `cp` command! If you checkout the branch, then stage
   and commit changes, then those commits do not affect the `master` (main)
   branch. In this way, you can work on adding new features or fixing bugs
   until you are confident that they work. Towards the end of this checkpoint,
   you will checkout the `master` branch, and it will appear as it did when
   branched earlier in the checkpoint. Then, you will merge changes from the
   `genericize` branch into the currently checked out branch. You can do the
   same kind of thing in your projects: i) branch to work on a new feature;
   ii) stage and commit as you test that feature; then iii) once confident,
   checkout `master` and merge your branch commits into `master`. This way,
   your `master` branch is always in a good state. 
   
1. Confirm that you are on the desired branch using `git status` and/or
   `git branch`. What command did you use? How do you know you're on the
   the desired branch?
   
1. In `Driver.java` implement the following generic method:

   ```java
   /**
    * Given a reference to an array specified by {@code array}, fill each
    * element by assigning it the value specified by {@code val}. 
    *
    * @param <T>    element type
    * @param array  array to fill
    * @param val    value to assign to each element
    */
   public static <T> void fill(T[] array, T val) {
       ...
   } // fill
   ```
   
1. In the `main` method, write a few lines of code to test your method.
   In your notes, write how you know it is properly working. Try an example
   where you think the types of the actual parameters will work and one where
   you expect it not to work.

1. **Compile all of the code, then run it.** If you run into any issues,
   then revisit either your `fill` implementation or the test code you
   included in your `main` method. **Be sure that everything compiles
   and runs as expected before continuing.**

1. Make sure that all of the code you wrote passes `checkstyle`.

1. Now that everything on this branch compiles, ensure that all changes 
   in the current branch have been staged and committed. After that, 
   checkout the `master` branch using the following command:
   
   ```
   $ git checkout master
   ```

1. Take a look at `Driver.java`. Notice that you have reverted back to the
   original code. The new, updated, code is on the other branch. To incorporate
   the changes (merge the changes) from the `genericize` branch into the current 
   (`master`) branch, use the following command:
   
   ```
   $ git merge genericize
   ```

   Did the merge work? How do you know?
   
1. **All Group Members** In a previous exercise, you combined the `--all`, `--decorate`,
   `--oneline`, and `--graph` options with `git log` to produce
   a condensed, graphical version of the Git log. While you
   **are expected to remember these options**, it is tiresome to
   write them out each time. Instead, create a `git adog` command
   by setting up a Git alias:

   ```
   $ git config --global alias.adog "log --all --decorate --oneline --graph"
   ```
   
1. View the condensed, graphical version of your Git log using `git adog`.
   What is the entire line of output for the most recent entry produced
   by your new `git adog` command?
   
1. Create a file called `NOTES.md`. In this file, write a sentence or
   two about your thoughts concerning this exercise. Once done,
   save the file, then stage and commit the changes. You log message
   can be something like `"added notes"`. Finally, view the condensed, 
   graphical version of your Git log using `git adog`.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Checkout the existing branch called `genericize` you created in the
   previous checkpoint to perform the work related to this checkpoint. 
   
   ```
   $ git checkout genericize
   ``` 
   
   Confirm that you are on the desired branch using `git status` and/or
   `git branch`.
   
1. In `Driver.java`, delete the test code that you wrote in the body of the `main` method
   (leave the arrays). Don't worry, it's in your repository's history if you want to see it later. 
   Save, then commit your change.
   
1. In this step, you will test a series of code snippets. **After each test,** ensure that all changes 
   in the current branch have been staged and committed (one commit per snippet). The instructors and 
   PLAs will check your Git log. Also, for each of the snippets below, indicate the following in your notes as
   you try them:
   1. **Guess:** Would `Driver.java` compile if that snippet is the only code inside of the `main` method?
   1. **Test:** Does `Driver.java` compile if that snippet is the only code inside of the `main` method?
   1. **Runtime:** If the program compiled, does the program work as intended? If the program won't compile,
      write `No` for this entry.
   1. **Why:** Why does it compile or not work?
   
   We recommend you make a table in your notes:
   
   | Snippet # | Guess | Test | Runtime | Why |
   |-----------|-------|------|---------|-----|
   |-----------|-------|------|---------|-----|
   
   1. **Snippet 1:**
   
      ```java
      String[] strings = new String[] { "a", "b" };
      fill(strings, "c");
      System.out.println(Arrays.toString(strings));
      ```
   
   1. **Snippet 2:**
   
      ```java
      String[] strings = new String[] { "c", "d" };
      Driver.<String>fill(strings, "e");
      System.out.println(Arrays.toString(strings));
      ```
   
   1. **Snippet 3:**
   
      ```java
      Ellipse[] ellipses = new Ellipse[] { null, null };
      Driver.<Ellipse>fill(ellipses, new Circle(1.0));
      System.out.println(Arrays.toString(ellipses));
      ```
1. Now that your table is complete for this checkpoint,
   make sure that everything on this branch compiles. After that,
   ensure that all changes in the current branch have been staged and committed, 
   then checkout the `master` branch.
   
1. Merge changes from the `genericize` branch into the current branch
   (`master`).

1. View the condensed, graphical version of your Git log using `git adog`
   What is the entire line of output for the most recent entry produced
   by your new `git adog` command?

1. Looking at the graphical version of your Git log, can you tell which branch
   you were on when you committed the `NOTES.md` file? How can you tell?
   
1. Consider the following method signatures:

   ```java
   public static <T> void fill(T[] array, T val) 
   public static void fill(Object[] array, Object val)
   ```
   
   In `NOTES.md`: 
      1. Clearly and thoroughly describe the differences between these two
         signatures. 
      1. Explain why the non-generic version is more error-prone.

   Once done, save the file, then stage and commit the changes. 
   
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Checkout the existing branch called `genericize` you created earlier 
   to perform the work related to this checkpoint. 
   
   ```
   $ git checkout genericize
   ``` 
   
   Confirm that you are on the desired branch using `git status` and/or
   `git branch`.
   
1. In `Driver.java`, delete any remaining test code that you wrote in the body of the `main` 
   method (leave the arrays). Don't worry, it's in your repository's history if you want to 
   see it later. Save, then commit your change.
   
1. Now, for each of the code snippets below, indicate the following in your notes as
   you try them:
   1. **Guess:** Would `Driver.java` compile if that snippet is the only code inside of the `main` method?
   1. **Test:** Does `Driver.java` compile if that snippet is the only code inside of the `main` method?
   1. **Runtime:** If the program compiled, does the program work as intended? If the program won't compile,
      write `No` for this entry.
   1. **Why:** Why does it compile or not work?
   
   We recommend you make a table in your notes:
   
   | Snippet # | Guess | Test | Runtime | Why |
   |-----------|-------|------|---------|-----|
   |-----------|-------|------|---------|-----|

   **After each test,** ensure that all changes in the current branch have been staged 
   and committed. The instructors and PLAs will check your Git log. Here are the snippets: 
   
   1. **Snippet 4:**
   
      ```java
      Ellipse[] ellipses = new Ellipse[] { null, null };
      Driver.<Shape>fill(ellipses, new Square(1.0));
      System.out.println(Arrays.toString(ellipses));
      ```
   
   1. **Snippet 5:**
   
      ```java
      String[] strings = new String[] { "i", "j" };
      Driver.<String>fill(strings, 2.0);
      System.out.println(Arrays.toString(strings));
      ```
      
   1. **Snippet 6:**
   
      ```java
      String[] strings = new String[] { "i", "j" };
      Driver.<Object>fill(strings, 2.0);
      System.out.println(Arrays.toString(strings));
      ```

1. Now that your table is complete for this checkpoint,
   make sure that everything on this branch compiles. After that,
   ensure that all changes in the current branch have been staged and committed, 
   then checkout the `master` branch.
   
1. Merge changes from the `genericize` branch into the current branch
   (`master`).
   
1. Modify `NOTES.md` to include some more thoughts concerning this exercise. 
   Once done, save the file, then stage and commit the changes. You log message
   can be something like `"added even more notes"`.

1. View the condensed, graphical version of your Git log using `git adog`
   What is the entire line of output for the most recent entry produced
   by your new `git adog` command?
  
1. If you do not intend to revisit the `genericize` branch by name, then
   you can safely delete it using `git branch -d` followed by the branch
   name. The changes have already been merged into `master`.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-ce14`
   directory with the following information.

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. If you generated the API documentation website, include the full link to the site.
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. https://webwork.cs.uga.edu/~user/cs1302-ce14-doc
   ```

1. Change directories to the parent of `cs1302-ce14` (e.g., `cd ..` from `cs1302-ce14`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [ce02](https://github.com/cs1302uga/cs1302-ce02).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-ce14 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the submit command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

### Bonus

1. The combination of options for the `git adog` command that you created earlier
   was popularized by a StackOverflow user named [Patoshi パトシ](https://stackoverflow.com/users/1642231/patoshi-パトシ)
   in their [reply to another user's post](https://stackoverflow.com/a/35075021).  
   
   ![ADOG](https://i.stack.imgur.com/ElVkf.jpg)
   
1. The StackOverflow user [fracz](https://stackoverflow.com/users/878514/fracz) suggested the `adog` alias
   that you setup earlier in their reply to Patoshi's reply.

**NOT A CHECKPOINT**

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/) [![License: CC BY-NC 4.0](https://img.shields.io/badge/Instructor%20License-CC%20BY--NC%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Bradley J. Barnes, and the University of Georgia.
This work is licensed under 
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public and licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a> to instructors at institutions of higher education.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
