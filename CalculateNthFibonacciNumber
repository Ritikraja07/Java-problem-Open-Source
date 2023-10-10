public class FibonacciCalculator {

  public static int calculateFibonacci(int n) {
    // Base case: Fibonacci numbers at positions 0 and 1 are 0 and 1, respectively
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    // Recursive case: sum of the previous two Fibonacci numbers
    return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
  }

  public static void main(String[] args) {
    int position = 0;
    int fibonacciNumber = calculateFibonacci(position);
    System.out.println("The Fibonacci number at position " + position + " is: " + fibonacciNumber);
    position = 3;
    fibonacciNumber = calculateFibonacci(position);
    System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
    position = 9;
    fibonacciNumber = calculateFibonacci(position);
    System.out.println("\nThe Fibonacci number at position " + position + " is: " + fibonacciNumber);
  }
}
