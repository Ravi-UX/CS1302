package cs1302.exceptions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/** 
 * A simpler version of the Unix <code>cat</code> command.
 */
public class MyCat {

    /**
     * Entry point for the application. Exactly zero or one command-line arguments are expected.
     * If a filename is given as an argument, then the program should print the contents of that
     * file to standard output. If a single dash (i.e., "-") is given as an argument, then
     * the program should print the contents of standard input. If multiple file names are given
     * as arguments, they should be delimited by commas and the contents of each file will be 
     * printed.
     *
     * @param args  the command-line arguments
     */
    public static void main(String[] args) {
	try{
	    Scanner input = null;
	    String filename = args[0];
	    for(int i = 0; i < args.length; i++){
		filename = args[i];
		if(filename.equals("-")){
		    Printer.printStdInLines();
		}else{
		    try{
			File file = new File(filename);
			Printer.printFileLines(file);
		    } catch(FileNotFoundException e2){
			System.out.println("Cat: " + e2.getMessage());
		    }//try
		}//if		
		System.out.println("======================================================================================");
	    }//for
	}catch(IndexOutOfBoundsException e1){
	    System.out.println("Cat: " + e1.getMessage());
	}
    } // main

} // MyCat

