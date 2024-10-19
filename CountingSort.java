public class CountingSort {
    static void countSortNaive(int arr[], int k, int n) {
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void countSortEfficient(int arr[], int k, int n) {
        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // res[count[arr[i]] - 1] = arr[i];
            // count[arr[i]]--;
            // res[--count[arr[i]]];

            res[--count[arr[i]]] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 5, 6, 5, 2 };
        int n = 4;
        int k = 7;
        countSortEfficient(arr, k, n);
    }
}
