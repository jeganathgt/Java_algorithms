import java.util.*;

/* 
 * Given the array of n natural integers.
 * we need to return repeating elemnt in the array
 */

class find_elem_that_appear_once {
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
       int found = -1;
       int duplicate_elem = 0;
       while (start <= last) {
           mid = (start + last)/2;

           if ((mid == array.length - 1) &&
               (array[mid] != array[mid-1])) {
               found = mid;
               break;
           }

           if ((mid == 0) && 
               (array[mid] != array[mid+1])) {
               found = mid;
               break;
           }

           if ((array[mid] != array[mid+1]) && 
               (array[mid] != array[mid-1])) {
               found = mid;
               break;
           }

           if (mid % 2 == 0) { 
              //even
              duplicate_elem = array[Integer.min(mid+1, last)];
           } else {
              //odd
              duplicate_elem = array[Integer.max(mid-1, start)];
           }

           if (array[mid] == duplicate_elem) {
               /* go left */
                   start = mid+1;
           } else {
               /* go right */
                   last = mid-1;
           } 
       }

       if (found >= 0) 
           System.out.println("Found at array[" + found + "] = " + array[found]);
       else
           System.out.println("single element not found");
    }
}
