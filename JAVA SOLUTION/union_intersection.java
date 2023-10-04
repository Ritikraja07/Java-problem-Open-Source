import java.util.*;
public class union_intersection {
    public static void main(String args[]) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,4};

        HashSet<Integer> set = new HashSet<>();
        //union
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        System.out.println("union : " + set.size());
        System.out.print("{ ");
        for (Integer union: set) {
            System.out.print(union + " ");
            
        }
        System.out.print("}"); 

        //intersection
        set.clear();
        
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
       
        System.out.println();
        System.out.println("Intersection ");
        System.out.print("{ ");
        int count =0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                System.out.print(arr2[i]+ " ");
               set.remove(arr2[i]);
            }
        }
        System.out.print("}");
        System.out.println();
        System.out.println("Intersection : "  + count);
    }
}
