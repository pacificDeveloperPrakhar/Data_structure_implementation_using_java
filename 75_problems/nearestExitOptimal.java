import java.util.*;
class Solution
{
    public int nearestExit(char[][] maze,int[] entrance){
        int m=maze.length;
        int n=maze[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int[] directions={0,-1,0,+1,0};
        int ans=0;
        while(!q.isEmpty()){
            ans++;
            for(int k=q.size();k>0;--k){
              int[] point=q.poll();
              for(int l=0;l<directions.length-1;l++)
              {
                int y=point[0]+directions[l];int x=point[1]+directions[l+1];
                if(x>=0&&y>=0&&y<m&&x<n&&maze[y][x]=='.')
                if(x==0||y==0||y==m-1||x==n-1){
                    return ans;
                }
                else
                {
                    q.offer(new int[]{y,x});
                    maze[y][x]='+';
                }
              }
              
            }
        }
return -1;
    }
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        char[][] maze = {
            {'+', '.', '+', '+', '+', '+', '+'},
            {'+', '.', '+', '.', '.', '.', '+'},
            {'+', '.', '+', '.', '+', '.', '+'},
            {'+', '.', '.', '.', '+', '.', '+'},
            {'+', '+', '+', '+', '+', '.', '+'}
        };
        int[] entrance = {0, 1}; // Entrance at maze[0][1]
        int result = solution.nearestExit(maze, entrance);

        System.out.println("The nearest exit is at a distance of: " + result);
    }
}