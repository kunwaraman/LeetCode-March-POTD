import java.util.*;
/*
time complexity O(nlonn)
space complexity O(1)
 */

public class CountDaysWithoutMeeting {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;

        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int end=0;
        for(int met[]:meetings){
            if(met[0]>end){
                count+=met[0]-end-1;
            }
            end=Math.max(end,met[1]);
        }
        if(days>end){
            count+=days-end;
        }
        return count;
    }
}
