class Solution {
    private static int[] fact = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    private String getPermutation(int n, int k, boolean[] nums, char[] str, int index) {
        int i = 0, m = nums.length;
        if(n == 1) {
            while(i < m && nums[i]) ++i;
            str[index++]=(char)('0'+i+1);
            return String.valueOf(str);
        }
        if(k == 0) {
            while(i < m) {
                if(!nums[i]) str[index++]=(char)('0'+i+1);
                ++i;
            }
            return String.valueOf(str);
        }
        
        int div = k/fact[n-1], mod = k%fact[n-1], j = -1;
        while(i < m-1 && div != j) {
            if(!nums[i]) ++j;
            if(j == div) break;
            ++i;
        }
        str[index++]=(char)('0'+i+1);
        if(i < m) nums[i]=true;
        return getPermutation(n-1, mod, nums, str, index); 
    }

    public String getPermutation(int n, int k) {
        boolean[] nums = new boolean[n];
        char[] charArr = new char[n];
        return getPermutation(n, k-1, nums, charArr, 0);
    }
}
