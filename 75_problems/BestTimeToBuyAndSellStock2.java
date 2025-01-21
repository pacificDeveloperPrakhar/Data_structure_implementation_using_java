public class BestTimeToBuyAndSellStock2 {
    public int maxProfitRec(int[] prices, int start, int end, int[][] pairs) {
        int res = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) { // Adjusted condition to avoid index out of bounds
                if (prices[j - 1] > prices[i - 1]) { // Adjusted to ensure valid indexing
                    if (i - 1 >= 0 && pairs[start][i - 1] == 0) {
                        pairs[start][i - 1] = maxProfitRec(prices, start, i - 1, pairs);
                    }
                    if (j + 1 <= end && pairs[j + 1][end] == 0) {
                        pairs[j + 1][end] = maxProfitRec(prices, j + 1, end, pairs);
                    }
                    pairs[i][j] = prices[j - 1] - prices[i - 1] + 
                                  (i - 1 >= 0 ? pairs[start][i - 1] : 0) + 
                                  (j + 1 <= end ? pairs[j + 1][end] : 0);
                    res = Math.max(pairs[i][j], res);
                }
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int[][] pairs = new int[prices.length + 1][prices.length + 1];
        return maxProfitRec(prices, 1, prices.length, pairs);
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
    }
}
