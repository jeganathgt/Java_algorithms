import java.util.*;

class integer_to_roman {
    static int input;

    static {
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
    }

    static int find_nearest_min(Integer[] Roman_integers, int value_to_find, int last) {
        int start  = 0;
        int mid    = 0;
        int ret    = -1;
        while (start < last) {
            mid = (start + last)/2;

            if (start+1 == last) {
                    ret = start;
                    break;
            }

            if (Roman_integers[mid] > value_to_find) {
                //go left;
                last = mid;
            } else if (Roman_integers[mid] < value_to_find) {
                //go right;
                start = mid;
            } else if (Roman_integers[mid] == value_to_find){
                ret = mid;
                break;
           } 
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder roman = new StringBuilder();

        Integer []Roman_integers = {  1,    4,   5,    9,  10,   40,  50,   90, 100,  400, 500,  900, 1000};
        String  []roman_strings  = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        if (input > 3999) {
            throw new Exception("Invalid input");
        }

        int i = Roman_integers.length - 1;

        while (input > 0) {
            while (i >= 0) {
                if (Roman_integers[i] <= input) {
                    input -= Roman_integers[i];
                    roman.append(roman_strings[i]);
                    break;
                }
                i--;
            }
        }
        System.out.println("Roman letters using O(n)    " + roman );

        i = Roman_integers.length - 1;
        while (input > 0) {
            i = find_nearest_min(Roman_integers, input, i);
            input -= Roman_integers[i];
            roman.append(roman_strings[i]);
        }

        System.out.println("Roman letters using O(logn) " + roman );
    }
}
