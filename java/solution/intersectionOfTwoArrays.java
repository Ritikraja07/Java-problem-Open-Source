//QUESTION:
//find intersection between this to arrays:
//  arr1={7,3,9};
// arr2={6,3,9,2,9,4};

import java.util.*;

public class intersectionOfTwoArrays {
    public static HashSet<Integer> intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            set2.add(arr2[j]);
        }
        for (Integer num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> intersectionSet = intersection(arr1, arr2);

        System.out.println("Intersection of the two arrays:");
        for (Integer num : intersectionSet) {
            System.out.print(num + " ");
        }
    }
}
