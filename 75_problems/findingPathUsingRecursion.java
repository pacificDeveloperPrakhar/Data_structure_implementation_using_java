class Solution {
    public int findPath(int[][] arr, int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (arr[m][n] != 0) {
            return arr[m][n];
        }

        int paths = 0;

        if (m > 0) {
            paths += findPath(arr, m - 1, n);
        }

        if (n > 0) {
            paths += findPath(arr, m, n - 1);
        }

        arr[m][n] = paths;

        return arr[m][n];
    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        return findPath(arr, m - 1, n - 1);
    }
}
