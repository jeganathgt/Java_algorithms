import java.util.*;

class Solution {
    static int find_decoding_ways(int[] dp, int[] array, int n) {
        if (n == 0) {
             dp[n] = (array[n] <= 26 && array[n] > 0)? 1 : 0;
             return dp[n];
        }

        if (n < 0) { 
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ways  = find_decoding_ways(dp, array, n-1);
        int value = Integer.parseInt("" + array[n-1] + array[n]);
        if (value <= 26) 
            ways += find_decoding_ways(dp, array, n-2);

        dp[n] = ways;
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the array of Integers:");
        String string = scan.next();
        int [] array = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            array[i] = string.charAt(i) - 48;
        }

        int []dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = -1;
        }

        int ways = find_decoding_ways(dp, array, array.length-1);
        System.out.println("ways : " + ways);
    }
}
