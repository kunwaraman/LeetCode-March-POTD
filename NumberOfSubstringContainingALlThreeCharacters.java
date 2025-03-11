import java.util.*;
/*
time complexity: O(n)
space complexity: O(1)
 */
public class NumberOfSubstringContainingALlThreeCharacters {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int arr[] = new int[3];
        Arrays.fill(arr,0);
        int i=0;
        int j=0;
        int res=0;
        while(j<n){
            char ch=s.charAt(j);
            arr[ch-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                res+=n-j;
                arr[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return res;
    }
}
