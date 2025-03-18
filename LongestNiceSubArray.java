/*
time complexity: O(n^2)
space complexity: O(1)
 */

public class LongestNiceSubArray {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            int mask=0;
            for(int j=i;j<n;j++){
                if((mask & nums[j])!=0){
                    break;
                }
                res=Math.max(res,j-i+1);
                mask=(mask | nums[j]);
            }
        }
        return res;
    }
}
