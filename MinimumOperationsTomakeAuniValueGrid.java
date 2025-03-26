import java.util.*;
/*
time complexity O(nlogn)
space complexity O(n)
 */

public class MinimumOperationsTomakeAuniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int m=grid.length;
        int n=grid[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
        }
        int res=0;
        int l=list.size();
        Collections.sort(list);
        int target=list.get(l/2);
        for(int i=0;i<list.size();i++){
            if(list.get(i)%x!=target%x){
                return -1;
            }
            res+=Math.abs(target-list.get(i))/x;
        }
        return res;

    }
}
