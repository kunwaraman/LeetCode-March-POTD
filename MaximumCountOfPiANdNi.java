/*
time complexity: O(n)
space complexity: O(1)
 */
public class MaximumCountOfPiANdNi {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int pi=0;
        int ni=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ni++;
            }else if(nums[i]>0){
                pi++;
            }
            maxi=Math.max(maxi,Math.max(ni,pi));
        }
        return maxi;

    }
}
