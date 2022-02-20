import java.util.*;

class house_robber {
    static int findMaxLoot(int []dp, int[] array, int n) {
        if (n == 0) {
            dp[0] = array[0];
            return dp[0];
        }

        if (n == 1) {
            dp[1] = array[1];
            return dp[1];
        }

        if (dp[n] != -1) return dp[n];

        dp[n] = Math.max(findMaxLoot(dp, array, n-2) + array[n], findMaxLoot(dp, array, n-1));
        return dp[n];
    }

    static int findMaxLootIterative(int [] array) {
        int [] dp= new int[array.length];

        for (int i = 0; i<array.length; i++) {
            dp[i] = -1;
        }

        dp[0] = array[0];
        dp[1] = array[1];
        for (int i = 2; i<array.length; i++) {
            dp[i] = Math.max(dp[i-2] + array[i], dp[i-1]);
        }

        return dp[array.length-1];
    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length:");

        int len = scan.nextInt();
        int[] array = new int[len];

        for (int i=0; i<len; i++) {
            array[i] = scan.nextInt();
        }

        int []dp = new int[len];
        for (int i=0; i< len; i++) {
            dp[i] = -1;
        }

        int loot = findMaxLoot(dp, array, len-1);
        System.out.println("Max_recursive=" + loot);
        
        loot = findMaxLootIterative(array);
        System.out.println("Max_iterative=" + loot);
    }
}
