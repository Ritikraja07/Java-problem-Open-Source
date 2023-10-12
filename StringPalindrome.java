import java.util.*;
public class StringPalindrome {
    public static boolean isPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    public static void main(String[] args) {
        String str = "racecar";
        boolean isPal = isPalindrome(str);
        System.out.println("String: " + str);
        System.out.println("Is Palindrome? " + isPal);
    }
}
