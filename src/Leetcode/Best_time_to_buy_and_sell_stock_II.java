package Leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Best_time_to_buy_and_sell_stock_II {

    /* Solution :-
        1. Always thinking from Selling perspective that's why starting from first index
        2. Don't think earn profit from complete ending - complete beginning */
    // prices = [1, 3, 5, 9] (2 + 2 + 4) == (9 - 1)  ((9 - 1) is bad solution)
    // prices = [2, 3, 1, 9] (1 + 8) = 9 != (9 - 2)  ((9 - 2) is bad solution)
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        Best_time_to_buy_and_sell_stock_II s = new Best_time_to_buy_and_sell_stock_II();
        System.out.println(s.maxProfit(new int[]{2, 3, 1, 9}));
    }
}
