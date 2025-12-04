class Solution {
    public int maxProfit(int[] prices) {
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;
       
       for(int price : prices){
        if(price < minPrice){
            minPrice = price;
        }
        else if(price - minPrice > maxProfit){
            maxProfit = price - minPrice;
        }
       } 
       return maxProfit;
    }
}


//2nd Code

class Solution {
    public int maxProfit(int[] prices) {
        int maxpr = 0;
        int currpr = 0;
        int buy = prices[0];
        for(int i = 0; i < prices.length; i++){
            buy = Math.min (buy, prices[i]);
            currpr = prices[i] - buy;
            maxpr = Math.max (currpr, maxpr);

        }
        return maxpr;
    }
}
