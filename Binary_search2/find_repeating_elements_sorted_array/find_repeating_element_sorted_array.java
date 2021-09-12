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

       int search_index = 0;
       for (int len = last/2; len>0; len/=2) {
           while (search_index+len < array.length && array[search_index+len] == (search_index + len + 1)) search_index+=len;
       }

       if (search_index+1 < array.length && array[search_index+1] != (search_index+2)) {
           System.out.println("repeated element " + array[search_index+1] + " found at "  + (search_index+1));
       }
    }
}
