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

    static boolean is_condition_reached(int[] array, int search_index) {
        int duplicate_elem = 0;
        if (search_index % 2 == 0) { 
           //even
           if ((search_index + 1) >= array.length) {
               return false;
           }
           duplicate_elem = array[search_index+1];
        } else {
           //odd
           duplicate_elem = array[search_index-1];
        }

        if (array[search_index] == duplicate_elem) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       int found = -1;
       int search_index = -1;
       int len = 0;
       for (len = (array.length-1)/2; len>0; len/=2) {
           while((search_index + len) < array.length && is_condition_reached(array, search_index + len)) search_index += len;
       }

       search_index++;
       if (search_index < array.length) {
           if (search_index+1 < array.length && search_index-1 >= 0) {
               if ((array[search_index] != array[search_index+1]) &&
                   (array[search_index] != array[search_index-1])) {
                   found = search_index;
               }
           } else if (search_index+1 < array.length) {
               if (array[search_index] != array[search_index+1]) {
                   found = search_index;
               }
           } else {
               if (array[search_index] != array[search_index-1]) {
                   found = search_index;
               }
           }
       }

       if (found >= 0) 
           System.out.println("Found at array[" + found + "] = " + array[found]);
       else
           System.out.println("single element not found");
    }
}
