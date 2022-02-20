import java.util.*;

class Solution {
    static boolean findConsecutiveOnesInUpward(int[][] array, int i, int j, int count) {
        if (count == 0) {
            return false;
        }

        for (int k = 1; k <= count; k++) {
            if ((i-k) < 0)
                return false;

            if (array[i-k][j] == 0)
                return false;
        }
        return true;
    }

    static boolean findConsecutiveOnesInLeftward(int[][] array, int i, int j, int count) {
        if (count == 0) {
            return false;
        }

        for (int k = 1; k <= count; k++) {
            if ((j-k) < 0)
                return false;

            if (array[i][j-k] == 0)
                return false;
        }
        return true;
    }

    static int findMaxSquare(int[][] dp, int[][] array) {
        int max = Integer.MIN_VALUE;

        int count = 0;
        for (int i=0; i<array.length; i++) {
            for (int j = 0; j <array[0].length; j++) {
                count = 0;
                if (i > 0 && j > 0) {
                    count = dp[i-1][j-1];
                }
                dp[i][j] = (findConsecutiveOnesInUpward(array, i, j, count)
                            && findConsecutiveOnesInLeftward(array, i, j, count)) ? (count + 1) : array[i][j];

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the array len:");
        int len = scan.nextInt();
        int[][] array = new int[len][len];

        int max_square = 0;
        int [][]dp = new int[array.length][array[0].length];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
            System.out.println(Arrays.toString(array[i]));
        }

        max_square = findMaxSquare(dp, array);
        System.out.println("Max square: " + (max_square * max_square));
    }
}
