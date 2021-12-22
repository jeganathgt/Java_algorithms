import java.util.*;

/* 
 * given the array [10, 20, 30, 40]
 * total cost to reach end.
 */

class solution {
    static int find_cost_iterative(int [] array) {
        int []dp = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = array[1] - array[0];

        int first_jump = 0, second_jump = 0;
        for (int i = 2; i<array.length; i++) {
            first_jump  = dp[i-2] + Math.abs(array[i] - array[i - 2]);    // cost of i-2 + ||
            second_jump = dp[i-1] + Math.abs(array[i] - array[i - 1]);
            dp[i] = Math.min(first_jump, second_jump);
        }
        return dp[array.length-1];
    }

    static int find_cost(int[] dp, int[] array, int n) {
        if (n == 1) {
            dp[1] = array[n] - array[n-1];
            return array[n] - array[n-1];
        }

        if (n == 0) {
            dp[0] = 0;
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }


        int min = Integer.MAX_VALUE;
        for (int i = 1; i<=n; i++) {
            min = Math.min(min, find_cost(dp, array, n-i) + Math.abs(array[n] - array[n-i]));
        }
/*
        int first_jump  = find_cost(dp, array, n-1) + Math.abs(array[n] - array[n-1]);
        int second_jump = find_cost(dp, array, n-2) + Math.abs(array[n] - array[n-2]);
 */       
        dp[n] = min;
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = -1;
        }

        int cost = find_cost(dp, array, len-1);
        System.out.println("COst:" + cost);
    }
}
