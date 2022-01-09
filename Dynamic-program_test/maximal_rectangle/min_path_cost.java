import java.util.*;

class Solution {
    static int findMaxRectangle(int[][] dp, int[][] array) {
        int max = Integer.MIN_VALUE;

        int count = 0;
        for (int i=0; i<array.length; i++) {
            for (int j = 0; j <array[0].length; j++) {
                if ((j-1) < 0) { 
                    dp[i][j] = array[i][j];
                    continue;
                }

                dp[i][j] = (array[i][j] == 1) ? (dp[i][j-1] + 1) : array[i][j];
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        LinkedList<Integer> stack = new LinkedList<Integer>();

        int index = 0;
        for (int j = array.length-1; j >= 0; j--) {

            //System.out.println();
            for (int i = 0; i< array.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }

                index = stack.getFirst();
                if (dp[i][j] < dp[index][j]) {
                    
                    while((!stack.isEmpty()) && dp[i][j] < dp[index][j]) {
                        index = stack.pop();
                        max = Math.max(((i - index) * dp[index][j]), max);
                    }

                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }

            if (!stack.isEmpty()) {
                int i = stack.size();
                while(!stack.isEmpty()) {
                    index = stack.pop();
                    max = Math.max(((i - index) * dp[index][j]), max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the array len:");
        int len = scan.nextInt();
        int[][] array = new int[len][len];

        int max_rectangle_area = 0;
        int [][]dp = new int[array.length][array[0].length];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
            System.out.println(Arrays.toString(array[i]));
        }

        max_rectangle_area = findMaxRectangle(dp, array);
        System.out.println("Max square: " + max_rectangle_area);
    }
}
