package Leetcode.Array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int low = prices[0];
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < low){
                low = prices[i];
            }
            else{
                if(prices[i] - low > sum){
                    sum = prices[i] - low;
                }
            }
        }
        return sum;
    }
}
