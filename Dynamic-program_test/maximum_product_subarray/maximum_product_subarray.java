import java.util.*;

/* 
 * given the array [10, 20, 30, 40]
 * total cost to reach end.
 */

class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        int max = array[0];
        int min = array[0];
        for (int i = 1; i < len; i++ ) {
            max = Math.max(Math.max(array[i] * max, array[i]), array[i] * min);
            min = Math.min(Math.min(array[i] * max, array[i]), array[i] * min);
        }

        System.out.println("Max product: " + max);
    }
}
