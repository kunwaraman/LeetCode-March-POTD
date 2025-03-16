import java.util.*;
/*
time complexity : O(NLog(Max(Nums)))
space complexity : O(1)
 */

public class HouseRobberiv {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int mini=Arrays.stream(nums).min().getAsInt();
        int maxi=Arrays.stream(nums).max().getAsInt();
        int start=mini;
        int end=maxi;
        int res=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(nums,mid,k)==true){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
    public boolean ispossible(int[] nums,int mid,int k){
        int n = nums.length;
        int house=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=mid){
                house++;
                i++;
            }
        }
        if(house>=k){
            return true;
        }
        return false;
    }
}
