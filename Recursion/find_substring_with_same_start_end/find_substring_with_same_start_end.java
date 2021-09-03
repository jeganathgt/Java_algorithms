import java.util.*;

/*
Find the largest element in array
*/

class find_array_element {
    static char[] array;
    static int output;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the array:");
            String scan_s = scan.next();
            array = new char[scan_s.length()];
            for (int i = 0; i<scan_s.length(); i++) {
                array[i] = scan_s.charAt(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void find_substring(char[] array, int start, int end)
    {
        if (start > end) {
            return;
        }

        for (int i = start; i<=end; i++) {
            if (array[start] == array[i]) {
                output++;
            }
        }
        find_substring(array, (start+1), end);
    }

    public static void main(String[] args) {
        find_substring(array, 0, array.length -1);
        System.out.println(" " + output);
    }
}
