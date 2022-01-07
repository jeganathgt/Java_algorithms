import java.util.*;

class Solution {
    static int find_minimum(int[][] dp, int[][] array, int i, int j)
    {
        if (i == 0 && j == 0) { dp[0][0] = 0; return 0;}

        int upper_cost = Integer.MAX_VALUE;
        int left_cost  = Integer.MAX_VALUE;

        if (i >= 0 && j >= 0 && dp[i][j] != -1) return dp[i][j];

        if (i > 0 && j >= 0) 
            upper_cost = find_minimum(dp, array, i-1, j) + array[i-1][j];
        
        if (j > 0 && i >= 0) 
            left_cost  = find_minimum(dp, array, i, j-1) + array[i][j-1];

        dp[i][j] = Math.min(upper_cost, left_cost);
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[3][3];

        int [][]dp = new int[array.length][array[0].length];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
        }

        int cost = find_minimum(dp, array, array.length-1, array[0].length-1);

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("Total cost:" + cost);
    }
}
