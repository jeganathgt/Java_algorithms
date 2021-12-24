import java.util.*;

class wild_card {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the input:");
            String input = scan.next();
            System.out.println("Enter the pattern:");
            String pattern = scan.next();
            int partern_index = 0;
            char patern_char = 0;
            boolean ret = false;
            for (int i = 0; i < input.length(); i++) {
                patern_char = pattern.charAt(partern_index);

                if ((patern_char == '?') || (patern_char == '*')) {
                    ret = true;
                    partern_index++;
                    if (pattern.length() <= partern_index) break;
                } else if (input.charAt(i) == patern_char) {
                    ret = true;
                    partern_index++;
                    if (pattern.length() <= partern_index) break;
                } else {
                    if (pattern.length() <= partern_index) break;
                    ret = false;
                }
            }
            System.out.println(ret);
     }
}
