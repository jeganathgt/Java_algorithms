import java.util.*;

/* 
 * Given the array of integers.
 * we need to return array indices such that they add up to the sum
 */

class two_sum {
    static int[] array;
    static int target;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the array len:");
            int len = scan.nextInt();
            array = new int[len];
            System.out.println("Enter the array elem:");
            for (int i = 0 ; i < len; i++) {
                array[i] = scan.nextInt();
            }
            System.out.println("Enter the target:");
            target = scan.nextInt();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Arrays.sort(array);
        int j = 0;
        int mid = (array.length-1)/2;;

        for (j = array.length-1; j > mid; j--) {
            for (int i = 0; i <= mid; i++) {
                if (i != j) {
                    if ( (array[i] + array[j]) == target ) {
                        System.out.println("(" + array[i] + "," + array[j] + ")");
                    } else if ((array[i] + array[j]) > target) {
                        break;
                    } 
                }
            }
        }
    }
}
