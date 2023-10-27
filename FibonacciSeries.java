public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10;  // Change this value to generate a different number of Fibonacci numbers
        generateFibonacciSeries(n);
    }

    public static void generateFibonacciSeries(int n) {
        long first = 0, second = 1;

        System.out.println("Fibonacci Series of " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");

            long next = first + second;
            first = second;
            second = next;
        }
    }
}
