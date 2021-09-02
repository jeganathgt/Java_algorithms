import java.util.*;

/* 
 * Given the array of n natural integers.
 * we need to return repeating elemnt in the array
 */

class find_repeating_elem {
    static int[] array;
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

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       int start = 0;
       int last  = array.length - 1;
       int mid = 0;
       while (start < last) {
           if (array[start] == array[last]) {
               System.out.println(" " + array[last]);
               break;
           }
           if ((start + 1) == last) break;
           mid = (start + last)/2;
           if (array[mid] < (mid+1)) {
               last = mid;
           } else {
               start = mid;
           }
       }
    }
}
