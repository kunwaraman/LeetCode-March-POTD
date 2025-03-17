import java.util.*;
/*
time complexity: O(n)
space complexity: O(n)
 */

public class DivideArrayInToEqualParts {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value=entry.getValue();
            if(value%2!=0){
                return false;
            }
        }
        return true;
    }
}
