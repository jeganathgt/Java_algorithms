import java.util.*;

/* 
 * Given the array of n natural integers.
 * we need to return peak element in the array
 */

class find_peak_element {
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

    public static boolean is_peak_element(int[] array, int search_elem) {

        if (((search_elem + 1) < array.length) && 
            ((search_elem - 1) >= 0)) {
            if ((array[search_elem] > array[search_elem + 1]) && 
                (array[search_elem] > array[search_elem - 1])) 
                return true;

            if (array[search_elem - 1] > array[search_elem])
               return false;

        }
        return true;
    }

    public static void main(String[] args) {
       int start = 0;
       int last  = array.length - 1;
       int mid = 0;

       int search_index = 0;
       for (int len = last/2; len>0; len/=2) {
           while (search_index+len < array.length && is_peak_element(array, search_index+len)) search_index+=len;
       }

       //search_index++;
       System.out.println("peak_elem " + array[search_index] + " found at "  + (search_index));
    }
}
