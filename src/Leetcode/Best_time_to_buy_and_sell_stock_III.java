package Leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class Best_time_to_buy_and_sell_stock_III {

    public int maxProfit(int[] prices) {

        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);           // Best price to buy first
            sell1 = Math.max(sell1, buy1 + price);   // Best profit after first sell
            buy2 = Math.max(buy2, sell1 - price);    // Best second buy using profit1
            sell2 = Math.max(sell2, buy2 + price);   // Best profit after second sell
        }
        return sell2;

    }

    public static void main(String[] args) {
        Best_time_to_buy_and_sell_stock_III s = new Best_time_to_buy_and_sell_stock_III();
        System.out.println(s.maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0})); // 3 , 5, 7 ,
    }
}
