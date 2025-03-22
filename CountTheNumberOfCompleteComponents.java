import java.util.*;
/*
time complexity: O(v+e);
space complexity: O(n);
 */

public class CountTheNumberOfCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int res=0;

        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==true){
                continue;
            }
            int v[] = new int[1];
            int e[] = new int[1];
            dfs(i,list,vis,v,e);
            if((v[0]*(v[0]-1))==e[0]){
                res++;
            }
        }
        return res;
    }
    public void dfs(int curr,ArrayList<ArrayList<Integer>>list,boolean vis[],int v[],int e[]){
        vis[curr]=true;
        v[0]++;
        e[0]+=list.get(curr).size();
        for(int k:list.get(curr)){
            if(vis[k]==false){
                dfs(k,list,vis,v,e);
                vis[k]=true;
            }
        }
    }
}
