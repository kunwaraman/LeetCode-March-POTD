import java.util.*;
/*
time complexity: O(nlogn)
space complexity: O(n)
 */
public class PutMarblesInBag {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int pair[] = new int[n-1];
        int m= pair.length;
        for(int i=0;i<m;i++){
            pair[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(pair);
        long maxm=0;
        long minm=0;
        for(int i=0;i<k-1;i++){
            minm+=pair[i];
            maxm+=pair[m-1-i];
        }
        return maxm-minm;

    }
}
