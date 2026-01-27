class Solution {
    public int maxProfit(int[] prices) {
        // This variable stores the total profit we can make
        // by summing all profitable price increases.
        int profit = 0;

        // Start from index 1 because we compare each day
        // with the previous day (i - 1).
        for (int i = 1; i < prices.length; i++) {

            // If today's price is higher than yesterday's,
            // we take the profit from this upward movement.
            // This represents buying yesterday and selling today.
            if (prices[i] > prices[i - 1]) {
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }

        // Return the maximum profit after all transactions.
        return profit;
    }
}
