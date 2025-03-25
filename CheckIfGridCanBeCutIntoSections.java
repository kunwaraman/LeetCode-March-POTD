/*
time complexity: O(nlogn)
space complexity: O(n)
 */
import java.util.*;
public class CheckIfGridCanBeCutIntoSections {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> horiz=new ArrayList<>();
        List<int[]> vert= new ArrayList<>();
        for(int rect[]:rectangles){
            int x1=rect[0];
            int y1=rect[1];
            int x2=rect[2];
            int y2=rect[3];

            horiz.add(new int[]{x1,x2});
            vert.add(new int[]{y1,y2});
        }
        int arrayhorix[][]=horiz.toArray(new int[horiz.size()][]);
        int arrayvert[][] = vert.toArray(new int[vert.size()][]);

        int res1[][]=merge(arrayhorix);
        if(res1.length>=3){
            return true;
        }
        int res2[][]=merge(arrayvert);
        return res2.length>=3;

    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans= new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int cs=intervals[i][0];
            int ce=intervals[i][1];
            if(cs>=ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }else{
                // there is an overlapp
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],ce);
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
