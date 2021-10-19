import java.util.*;

class Solution {


    static void permutuate(char[] output, String[] map, int[] array, LinkedList<String>list, int current_index) {
        if (array.length == current_index) {
            list.add(new String(output));
            return;
        }

        String char_set = map[array[current_index]];
        for (Character ch : char_set.toCharArray()) {
            output[current_index] = ch;
            permutuate(output, map, array, list, current_index+1);
        }
        return;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the numbers len:");
        int len = scan.nextInt();

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char [] output = new char[len];
        LinkedList <String> list = new LinkedList<String>();

      permutuate(output, map, array, list, 0);
        System.out.println(list);
    }
}
