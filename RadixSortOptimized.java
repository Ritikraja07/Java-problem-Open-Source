import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortOptimized {
    public static void radixSort(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        // Find the maximum value to determine the number of digits
        double max = (double) arr[0];
        for (Object item : arr) {
            if ((double) item > max) {
                max = (double) item;
            }
        }
        
        // Perform counting sort for each digit position
        int exp = 1;
        List<Object>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        while (max / exp >= 1) {
            // Place elements into buckets based on the current digit
            for (Object item : arr) {
                int index = (int) (((double) item / exp) % 10);
                buckets[index].add(item);
            }
            
            // Copy elements from buckets back to the original array
            int currentIndex = 0;
            for (List<Object> bucket : buckets) {
                for (Object item : bucket) {
                    arr[currentIndex++] = item;
                }
                bucket.clear();
            }
            
            // Move to the next digit position
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        // Example usage with both integers and non-integers
        Object[] arr = {5, 2.3, 10.1, 3.7, 8, 1.2, 4.5};
        
        System.out.println("Before sorting: " + Arrays.toString(arr));
        
        radixSort(arr);
        
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
