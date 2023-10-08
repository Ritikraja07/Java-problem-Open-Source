package java.solution;

class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i=0, j=0;
        int idx =0;
        double[] arr = new double[n +m];
        
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                arr[idx++] = nums1[i++];
            }
            else {
                arr[idx++] = nums2[j++];
            }
        }
        while(i < n) {
            arr[idx++] = nums1[i++];
        }
        while(j < m) {
            arr[idx++] = nums2[j++];
        }
        int len = arr.length;
        int mid = len/2;
        return len%2 == 1 ? arr[mid] : (arr[mid] + arr[mid -1]) /2;
    }
}






