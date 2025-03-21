import java.util.*;
/*
time complexity: O(n)*(nlog(max))
space complexity: O(1)
 */
public class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max=Arrays.stream(candies).max().getAsInt();
        int tsum=0;
        for(int i=0;i<n;i++){
            tsum+=candies[i];
        }

        int start=1;
        int end = max;
        int res=0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(ispossible(candies,mid,k)==true){
                res=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return res;
    }
    public boolean ispossible(int candies[],int mid,long k){
        int n = candies.length;
        long count=0;
        for(int i=0;i<n;i++){
            count+=candies[i]/mid;
        }
        return count>=k;
    }
}
