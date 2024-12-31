import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] level=new int[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);

        while (!q.isEmpty()) {
            int[] point = q.remove();
            maze[point[0]][point[1]]='+';
            int ans = checkForEntrance(q, maze, point, level);
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    public boolean checkEntrance(char[][] maze, int[] point) {
        if (maze[point[0]][point[1]] == '.') {
            if (point[0] == 0 || point[1] == 0 || point[0] == maze.length - 1 || point[1] == maze[0].length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean availablePoint(char[][] maze, int[] point) {
        if (point[0] >= 0 && point[1] >= 0 && point[0] < maze.length && point[1] < maze[0].length) {
            if (maze[point[0]][point[1]] == '.') {
                return true;
            }
        }
        return false;
    }

    public int checkForEntrance(Queue<int[]> q, char[][] maze, int[] point, int[][] level) {
        if (availablePoint(maze, new int[]{point[0] - 1, point[1]})) {
            level[point[0]-1][point[1]]=level[point[0]][point[1]]+1;
            if (checkEntrance(maze, new int[]{point[0] - 1, point[1]})) {
                System.out.println(""+(point[0]-1)+point[1]);
                return level[point[0]-1][point[1]];
            } else {
                q.add(new int[]{point[0] - 1, point[1]});
                System.out.println("inserting");
            }
        }
        if (availablePoint(maze, new int[]{point[0], point[1] - 1})) {
            level[point[0]][point[1]-1]=level[point[0]][point[1]]+1;
            if (checkEntrance(maze, new int[]{point[0], point[1] - 1})) {
                System.out.println(""+(point[0])+(point[1]-1));
                return level[point[0]][point[1]-1];
            } else {
                q.add(new int[]{point[0], point[1] - 1});
                System.out.println("inserting");
            }
        }
        if (availablePoint(maze, new int[]{point[0] + 1, point[1]})) {
            level[point[0]+1][point[1]]=level[point[0]][point[1]]+1;
            if (checkEntrance(maze, new int[]{point[0] + 1, point[1]})) {
        System.out.println(""+(point[0]+1)+(point[1]));
        return level[point[0]+1][point[1]];
    } else {
        q.add(new int[]{point[0] + 1, point[1]});
        System.out.println("inserting");
    }
}
if (availablePoint(maze, new int[]{point[0], point[1] + 1})) {
    level[point[0]][point[1]+1]=level[point[0]][point[1]]+1;
    if (checkEntrance(maze, new int[]{point[0], point[1] + 1})) {
        System.out.println(""+(point[0])+(point[1]+1));
        return level[point[0]][point[1]+1];
    } else {    level[point[0]][point[1]-1]=level[point[0]][point[1]]+1;
                q.add(new int[]{point[0], point[1] + 1});
                System.out.println("inserting");
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
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
