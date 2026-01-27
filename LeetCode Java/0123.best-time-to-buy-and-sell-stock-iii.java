class Solution {
    public int maxProfit(int[] prices) {

        // Edge case: no prices
        if (prices.length == 0) return 0;

        // buy1  -> max profit after first buy
        // sell1 -> max profit after first sell
        // buy2  -> max profit after second buy
        // sell2 -> max profit after second sell
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        // Traverse prices starting from day 1
        for (int i = 1; i < prices.length; i++) {

            // Max of continuing previous state or making a new transaction today
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);

            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        // Maximum profit after at most two transactions
        return sell2;
    }
}
