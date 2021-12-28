package cs1302.example;
import cs1302.utility.MyMethods;

public class Hello{
    public static void main(String[] args){
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.println("Enter two integers to find the max: ");
	System.out.print("Number 1: ");
	int num1 = sc.nextInt();
	System.out.print("Number 2: ");
	int num2 = sc.nextInt();
	System.out.println("Maximum: " + MyMethods.max(num1, num2));
    }
}
