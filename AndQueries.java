/**
 * Ninja likes performing bitwise AND operations. He is given an array 'ARR'
 * of size 'N' and needs to perform 'N' queries. For each query, 1 <= 'i' <= 'N',
 * he needs to calculate the bitwise AND of all the array elements in the prefix
 * of length 'i'. After that, his task is to print the bitwise AND of all the 'N'
 * query results.
 * Since Ninja leads a busy life, he has asked you to help him complete this task.
 */
public class AndQueries {
    public static int andQueries(int arr[], int n) {
        int op = Integer.MAX_VALUE;
        int series = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            series = series & arr[i];

            op = op & series;
        }

        return op;
    }
}
