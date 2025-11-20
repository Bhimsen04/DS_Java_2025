package Leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class Best_time_to_buy_and_sell_stock {

    /* Solution :-
        1. Always thinking from Selling perspective that's why starting from first index
        2. Once we get the less value i.e immediately update less price
        3. If we get the higher value, then definitely have to check prices[i] - lowestPrice > maxProfit if true then updated
           lowestPrice we are using if false then may be earlier we already earned more profit */

    // [3,15,1,10]  (Best Example to analyze)
    // [7,6,4,3,1]
    public int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
            else if (prices[i] - lowestPrice > maxProfit) {
                maxProfit = prices[i] - lowestPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Best_time_to_buy_and_sell_stock s = new Best_time_to_buy_and_sell_stock();
        System.out.println(s.maxProfit(new int[]{3, 15, 1, 10}));
    }
}
