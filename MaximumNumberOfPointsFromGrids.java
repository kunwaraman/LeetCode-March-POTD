import java.util.*;

public class MaximumNumberOfPointsFromGrids {

        int direct[][]={{0,1},{0,-1},{1,0},{-1,0}};
        public int[] maxPoints(int[][] grid, int[] queries) {
            int m = grid.length;
            int n = grid[0].length;
            int q = queries.length;
            int ans[] = new int[q];
            for(int i=0;i<q;i++){
                ans[i]=bfs(grid,queries[i],m,n);
            }
            return ans;
        }
        public int bfs(int[][] grid,int val,int m,int n){
            m=grid.length;
            n=grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            boolean vis[][] = new boolean[m][n];
            vis[0][0]=true;
            int count=0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0;i<size;i++){
                    int curr[] = queue.remove();
                    int k=curr[0];
                    int j=curr[1];
                    if(grid[k][j]>val){
                        continue;
                    }
                    count++;
                    for(int dir[]:direct){
                        int i_=k+dir[0];
                        int j_=j+dir[1];
                        if(i_>=0 && i_<m && j_>=0 && j_<n && !vis[i_][j_] && grid[i_][j_]<val){
                            queue.add(new int[]{i_,j_});
                            vis[i_][j_]=true;
                        }
                    }

                }

            }
            return count;
        }
        /*
        optimised

         */
        class Solution {


            public int[] maxPoints(int[][] grid, int[] queries) {
                int m = grid.length;
                int n = grid[0].length;
                int q = queries.length;
                int ans[] = new int[q];

                int[][] sq = new int[q][2];
                for (int i = 0; i < q; i++) {
                    sq[i][0] = queries[i];
                    sq[i][1] = i;
                }
                Arrays.sort(sq, Comparator.comparingInt(a -> a[0]));

                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
                boolean[][] visited = new boolean[m][n];
                int points = 0;

                pq.offer(new int[]{grid[0][0], 0, 0});
                visited[0][0] = true;

                for (int i = 0; i < q; i++) {
                    int qv = sq[i][0];
                    int idx = sq[i][1];

                    while (!pq.isEmpty() && pq.peek()[0] < qv) {
                        int[] top = pq.poll();
                        int x = top[1], y = top[2];
                        points++;

                        for (int[] dir : direct) {
                            int i_ = x + dir[0];
                            int j_ = y + dir[1];
                            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                                pq.offer(new int[]{grid[i_][j_], i_, j_});
                                visited[i_][j_] = true;
                            }
                        }
                    }
                    ans[idx] = points;
                }

                return ans;
            }
        }

}
