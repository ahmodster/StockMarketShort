/**
 * Created by Ahmad Usmani on 12/25/2017.
 *
 * This program creates an object stock,
 * then determines the profit if it were to be sold at a particular quote,
 * or it determines the quote if a particular profit point is desired
 *
 *NOTE: This program does not consider short-term and long-term capital taxes.
 */

import java.text.DecimalFormat;

public class Stock {
    double quantity;
    double marketValue;
    String name;
    //The cost per trade is $6.95
    final double costPerTrade = 6.95;

    //constructor accepting only fixed variables
    Stock (String name, double quantity, double marketValue){
        this.name = name;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }

    /**
     *
     * This method accepts a quote, and prints the profit at the quote.
     *
     */

    public void profitAt(double quote) {
        DecimalFormat df2 = new DecimalFormat(".##");
        double profit = marketValue - (quantity * quote) - (costPerTrade*2);
        System.out.println("If you were to sell " +name +" at the current market value,");
        System.out.println("and buy at $" + quote +", you would profit: " + df2.format(profit));
    }

    /**
     *
     * This method accepts the desired profit, and prints the quote at which that can be made.
     *
     */

    public void profitReq (double profit){
        DecimalFormat df2 = new DecimalFormat(".##");
        double quote = (marketValue - (costPerTrade*2) - profit) / quantity;
        System.out.println("If you want to make $" + profit + ",");
        System.out.println("After selling it at the current market value,");
        System.out.println("you will have to buy " + name +" at this quote: $" + df2.format(quote) + ".");

    }

    public static void main(String args[]){

        //Example with Facebook
        Stock Fb = new Stock("Facebook", 31, 5744.61);
        Fb.profitAt(182);
        System.out.println("");
        Fb.profitReq(70);

    }



}