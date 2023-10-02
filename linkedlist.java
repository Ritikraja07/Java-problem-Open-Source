// Java code to illustrate boolean addLast()
import java.io.*;
import java.util.LinkedList;

public class LinkedListDemo {
public static void main(String args[]) {

	// Creating an empty LinkedList
	LinkedList<String> list = new LinkedList<String>();

	// Use add() method to add elements in the list
	list.add("Geeks");
	list.add("for");
	list.add("Geeks");
	list.add("10");
	list.add("20");

	// Displaying the current list
	System.out.println("The list is:" + list);

	// Adding new elements at the end of list using addLast()
	list.addLast("At");
	list.addLast("Last");

	// Displaying the new list
	System.out.println("The new List is:" + list);
}
}
