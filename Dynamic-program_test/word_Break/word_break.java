import java.util.*;

class wild_card {
    static boolean word_break(Set dictionary, String str) {

        boolean ret = dictionary.contains(str);
        System.out.println("word_break: " + str + " " + ret);
        return ret;
    }

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the dict len:");

            int len = scan.nextInt();
            System.out.println("Enter the keywords:");
            HashSet<String> dictionary = new HashSet<String>();

            for(int i = 0; i < len; i++) {
                dictionary.add(scan.next());
            }
            System.out.println(dictionary);

            System.out.println("Enter the search string:");
            String search_str = scan.next();

            int found = 0;
            for(int i = 0; i < search_str.length(); i++) {
                if (word_break(dictionary, search_str.substring(0, i)) && 
                    word_break(dictionary, search_str.substring(i, search_str.length())))
                    found = 1;
            }
            System.out.println("result:" + found);
    }
}
