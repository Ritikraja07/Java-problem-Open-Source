/**
 * In this implementation, the fibonacci function takes an integer n as input and returns the n-th Fibonacci number.
 * The function uses recursion to calculate the Fibonacci number by summing the two preceding numbers in the sequence.
 */

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i  =0; i <= n; i++) {
            System.out.println(fibonacci(i) + " ");
        }
    }
}
