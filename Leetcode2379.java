/*
time complexity: O(n)
space complexity: O(1)
 */

public class Leetcode2379 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int i=0;
        int j=0;
        int mini=Integer.MAX_VALUE;
        int count=0;
        while(j<n){
            if(blocks.charAt(j)=='W'){
                count++;
            }
            if(j-i+1==k){
                mini=Math.min(mini,count);
                if(blocks.charAt(i)=='W'){
                    count--;
                }
                i++;
            }
            j++;
        }
        return mini;
    }
}
