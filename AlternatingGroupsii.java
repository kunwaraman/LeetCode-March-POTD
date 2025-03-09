/*
time complexity: O(n)
space complexity: O(n)
 */

public class AlternatingGroupsii {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n+(k-1);

        int extend[] = new int[N];
        System.arraycopy(colors,0,extend,0,n);
        for(int i=0;i<k-1;i++){
            extend[n+i]=colors[i];
        }
        int count=0;
        int i=0;
        int j=1;
        while(j<N){
            if(extend[j-1]==extend[j]){
                i=j;
                j++;
                continue;
            }
            if(j-i+1==k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
