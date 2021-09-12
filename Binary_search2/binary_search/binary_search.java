import java.util.*;

/* 
 * Given the array of sorted numbers.
 * we need to return the index of searched_element
 */

class search_elem {
    static int[] array;
    static int search_elem;
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
            System.out.println("Enter the search elem:");
            search_elem = scan.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       int start = 0;
       int last  = array.length - 1;
       int mid   = 0;
       int found = -1;

       for (int len = last/2; len >= 0; len /= 2) {
           mid = start + len;

           if (array[mid] < search_elem){
               start = mid + 1;
           } else if (array[mid] == search_elem){
               found = mid;
               break;
           }
       }

       if (found >= 0) {
           System.out.println("Found " + search_elem + " at " + found);
       } else {
           System.out.println("not found " + search_elem);
       }

       int search_index = 0;
       last  = array.length - 1;
       for (int len = last/2; len>0; len/=2) {
           while (search_index+len < array.length && array[search_index+len] < search_elem) search_index+=len;
       }
       if (array[search_index] == search_elem) {
           System.out.println("efficient method element found " + array[search_index] + " at "  + search_index);
       }
    }
}
