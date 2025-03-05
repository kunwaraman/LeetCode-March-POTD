/*
time complexity: O(n)
space complexity: O(1)
 */
public class CountTotalNumberOfColoredCells {
    public long coloredCells(int n) {
        int t = 1;
        long cells=1;
        while(t<=n){
            cells+=(4*(t-1));
            t++;
        }
        return cells;
    }
}
