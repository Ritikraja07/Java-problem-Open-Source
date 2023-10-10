// Radix Sort implementation

import java.util.Arrays;

public class RadixSort {
    private static final int BASE = 10;
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, -456, 803, 1000, -2033, -9, 0, 10};
        long startTime = System.currentTimeMillis();
        System.out.println("Original Array: " + Arrays.toString(arr));
        radixSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted Array: " + Arrays.toString(arr) + "\nTime taken: " +
                ((endTime-startTime)*0.001)+" seconds");
    }
    private static void radixSort(int[] arr){
        if(arr.length==0)
            return;
        // Initialising these arrays for sorting the negative and the positive elements separately.
        int[] positive = Arrays.stream(arr).filter(i -> i>=0).toArray();
        int[] negative = Arrays.stream(arr).filter(i -> i<0).toArray();
        if(positive.length>0){
            int max = positive[0];
            // Find the maximum value present
            for (int j : positive) {
                max = Math.max(max, j);
            }
            // Looping through the elements and applying Counting Sort based on the number of digits
            // present in the maximum element
            for(int exp=1; max/exp>0; exp*=10){
                countingSort(positive, positive.length, exp);
            }
        }
        if(negative.length>0){
            // Converting the negative elements in the array to positive for sorting purpose
            for(int i=0; i<negative.length; i++){
                negative[i] *= -1;
            }
            // Find the maximum value present
            int max = negative[0];
            for (int j : negative) {
                max = Math.max(max, j);
            }
            // Looping through the elements and applying Counting Sort based on the number of digits
            // present in the maximum element
            for(int exp=1; max/exp>0; exp*=BASE){
                countingSort(negative, negative.length, exp);
            }
        }
        int index = 0;
        // Including the negative elements in the reverse order since (-9 < -1) &
        // the negative elements were sorted based on the absolute values of the elements in the array
        for (int i= negative.length-1; i>=0; i--) {
            arr[index++] = -negative[i];
        }
        // Appending the positive elements after the negative elements in the array
        for (int j : positive) {
            arr[index++] = j;
        }
    }
    private static void countingSort(int[] arr, int n, int exp){
        // Initialising the count array with size = BASE
        int[] count = new int[BASE];
        // Initialising the output array with size = number of elements in positive or negative array
        int[] output = new int[n];
        // Counting the frequency of the numbers < BASE i.e. from [0..9] in this case
        for (int j : arr) {
            count[(j / exp) % BASE]++;
        }
        // Calculate cumulative count
        for(int i=1; i<BASE; i++){
            count[i] += count[i-1];
        }
        // Building the output array
        for(int i=n-1; i>=0; i--){
            output[count[(arr[i]/exp)%BASE]-1] = arr[i];
            count[(arr[i]/exp)%BASE]--;
        }
        // Copying the array elements present in output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}

/*
Time Complexity: O(d*(n+b)), d = number of digits
                             n = number of elements in the array
                             b = the base of the number system being used which is 10 here,
                                 this can be taken as 20, 30 anything based on the range of elements present,
                                 but the larger the base the more space will be required.
Auxiliary Space Complexity: O(n+b), n = number of elements
                                    b = base of the number system being used which is 10 here
*/