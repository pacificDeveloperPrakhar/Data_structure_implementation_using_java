class Solution {
    public int maxxProfitRec(int[] prices, int[][] profits, int start, int end) {
        if (start >= end) {
            return 0; // Base case: No profit can be made if there's no range.
        }

        // If the result is already computed, return it.
        if (profits[start][end] != -1) {
            return profits[start][end];
        }

        int maxProfit = 0;

        // Iterate over all possible buy-sell pairs.
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                int currentProfit = prices[j] - prices[i];

                if(currentProfit<0)
                currentProfit=0;

                // Add profits from the left and right subproblems.
                int leftProfit = 0;
                if (i > start) {
                    if (profits[start][i - 1] == -1) {
                        profits[start][i - 1] = maxxProfitRec(prices, profits, start, i - 1);
                    }
                    leftProfit = profits[start][i - 1];
                }

                int rightProfit = 0;
                if (j < end) {
                    if (profits[j + 1][end] == -1) {
                        profits[j + 1][end] = maxxProfitRec(prices, profits, j + 1, end);
                    }
                    rightProfit = profits[j + 1][end];
                }

                // Total profit for this transaction configuration.
                int totalProfit = currentProfit + leftProfit + rightProfit;

                // Update the maximum profit.
                maxProfit = Math.max(maxProfit, totalProfit);
            }
        }

        // Store the result in the memoization table.
        profits[start][end] = maxProfit;

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0; // No profit can be made with less than 2 prices.
        }

        // Initialize the memoization table with -1.
        int[][] profits = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                profits[i][j] = -1;
            }
        }

        // Solve the problem using the recursive function.
        return maxxProfitRec(prices, profits, 0, n - 1);
    }

    public static void main(String[] args) {
        // Example test case
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Calculate and print the maximum profit
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
