// Java Program to demonstrate use of Method Overloading 
import java.io.*; 
class GFG { 
	static int multiply(int a, int b) { return a * b; } 
	static int multiply(int a, int b, int c) 
	{ 
		return a * b * c; 
	} 
	static int multiply(int a, int b, int c, int d) 
	{ 
		return a * b * c * d; 
	} 
	public static void main(String[] args) 
	{ 
		System.out.println("multiply() with 2 parameters"); 
		System.out.println(multiply(4, 5)); 
		System.out.println("multiply() with 3 parameters"); 
		System.out.println(multiply(2, 3, 4)); 
		System.out.println("multiply() with 4 parameters"); 
		System.out.println(multiply(2, 3, 4, 1)); 
	} 
}
