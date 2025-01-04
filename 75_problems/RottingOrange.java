import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        //first find the rotten orange coordinates
        Deque<int[]> q = new ArrayDeque<>();
        int[] directions={0,1,0,-1,0};
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
             if(grid[i][j]>=2)
             q.push(new int[]{i,j});
            }
        }
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        while(!q.isEmpty()){

            for(int i=q.size();i>0;--i)
            {
                int[] point=q.poll();
                for(int k=0;k<directions.length-1;k++)
                {
                    int x=point[0]+directions[k];
                    int y=point[1]+directions[k+1];
                    if(x>=0||y>=0||x<=m-1||y<=n-1)
                    {
                        if(grid[x][y]!=2)
                        {
                            grid[x][y]=2;
                            q.push(new int[]{x,y});
                        }
                    }
                    

                }
            }
            time++;
        }
        return time;
    }
    public static void main(String[] args)
    {

    }
}