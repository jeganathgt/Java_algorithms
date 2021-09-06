import java.util.*;

class longest_substring {
    static String input; 
    static int lo = 0, hi = 0;
    static int length = 0;
    static {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
        hi = input.length();
    }

    static int length_of_palindrome_string(char[] array, int mid1, int mid2) {

        for (int i = mid1, j = mid2; i>=0 && j < array.length; i--, j++) {
            if (array[i] != array[j]) {
                break;
            }
            if (length < (j - i + 1)) {
                length = j - i + 1;
                lo = i;
                hi = j + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        char [] array = input.toCharArray();

        for (int i = 0; i<array.length; i++) {
            length_of_palindrome_string(array, i, i);
            length_of_palindrome_string(array, i, Math.min(i+1, array.length));
        }
        System.out.println("max_length " + length + " " + input.substring(lo, hi));
    }
}
