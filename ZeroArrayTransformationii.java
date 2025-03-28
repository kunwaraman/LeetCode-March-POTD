import java.util.*;
/*
time complexity: O(QLogQ+N)
space complexity : O(N)
 */
public class ZeroArrayTransformationii {
    int n;
    int q;
    public int minZeroArray(int[] nums, int[][] queries) {
        n=nums.length;
        q=queries.length;
        if(Arrays.stream(nums).allMatch(x->x==0)){ // chekc already nums 0
            return 0;
        }
        int l=0;
        int r=q-1;
        int k=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(diffarray(nums,queries,mid)==true){
                k=mid+1;
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        return k;

    }
    public boolean diffarray(int[]nums,int[][]queries,int k){
        int diff[] = new int[n];
        for(int i=0;i<=k;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int x=queries[i][2];
            diff[l]+=x;
            if(r+1<n){
                diff[r+1]-=x;

            }

        }
        int csum=0;
        for(int i=0;i<n;i++){
            csum+=diff[i];
            diff[i]=csum;

            if(nums[i]-diff[i]>0){
                return false;
            }
        }
        return true;
    }
}
