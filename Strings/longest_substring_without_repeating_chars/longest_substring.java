import java.util.*;

class longest_substring {
    static String input; 
    static {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
    }

    public static void main(String[] args) {
        char [] array = input.toCharArray();

        HashMap <Character, Integer> map = new HashMap<Character, Integer>();

        int k = 0;
        int max_len = 0;
        int start_index = 0;
        int last_index  = 0;
        String substring = "";

        for (int i = 0; i<array.length; i++) {
            if (map.containsKey(array[i])) {
                k = map.get(array[i]) + 1;
            }

            map.put(array[i], i);

            if (max_len < (i - k + 1)) {
                start_index = k;
                last_index  = i;
                substring = input.substring(k, i+1);
                max_len = Math.max(max_len, i - k + 1);
            }
        }

        System.out.println("maxlength " + max_len + " (" + substring + ") ");
    }
}
