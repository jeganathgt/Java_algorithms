import java.util.*;

/*
Given following three values, the task is to find the total number of maximum chocolates you can eat.
•money : Money you have to buy chocolates
•price : Price of a chocolate
•wrap : Number of wrappers to be returned for getting one extra chocolate.
It may be assumed that all given values are positive integers and greater than 1.
•Examples:
•Input :   money = 16, price = 2, wrap = 2
•Output :   15
•Price of a chocolate is 2. You can buy 8 chocolates from amount 16. You can return 8 wrappers back and 
get 4 more Chocolates. Then you can return 4 wrappers and get 2 more chocolates. Finally you can 
return 2 wrappers to get 1 more chocolate.
*/

class chocolate_puzzle {
    static int money;
    static int prize_per_chocolate;
    static int wrap_per_chocolate;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the money in hand:");
            money = scan.nextInt();
            System.out.println("Enter the prize per chocolate:");
            prize_per_chocolate = scan.nextInt();
            System.out.println("Enter the wrap per chocolate:");
            wrap_per_chocolate = scan.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int total_chocolate(int value) {
        int total_cnt = 0;
        if (value > 0) {
            total_cnt = value + total_chocolate(value/wrap_per_chocolate);
        }
        return total_cnt;
    }

    public static void main(String[] args) 
    {
       System.out.println(total_chocolate(money/prize_per_chocolate)); 
    }
}
