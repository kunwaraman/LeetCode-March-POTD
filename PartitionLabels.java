import java.util.*;
/*
time complexity: O(n)
space complexity: O(1)
 */

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        while(i<n){
            int end=map.get(s.charAt(i));
            int j=i;
            while(j<end){
                end=Math.max(end,map.get(s.charAt(j)));
                j++;
            }
            list.add(j-i+1);
            i=j+1;
        }
        return list;
    }
}
