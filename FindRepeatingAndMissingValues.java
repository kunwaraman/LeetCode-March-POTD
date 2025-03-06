import java.util.*;
/*
time complexity O(n^2)
space complexity o(n)
 */
public class FindRepeatingAndMissingValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n*n;
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        for(int num=1;num<=N;num++){
            if(!map.containsKey(num)){
                ans[1]=num;
            }else if(map.get(num)==2){
                ans[0]=num;
            }
        }
        return ans;
    }
}
