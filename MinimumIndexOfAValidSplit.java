import java.util.*;
/*
time complexity: O(n)
space complexity: O(1)
 */
public class MinimumIndexOfAValidSplit {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int candidate=nums.get(0);
        int vote=1;
        int freq=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==candidate){
                vote++;
            }else{
                vote--;
                if(vote==0){
                    candidate=nums.get(i);
                    vote++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(nums.get(i)==candidate){
                freq++;
            }
        }
        int leftFreq = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftFreq++;
            }
            int rightFreq = freq - leftFreq;
            if (leftFreq * 2 > (i + 1) && rightFreq * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;

    }
}
