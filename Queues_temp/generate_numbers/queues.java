import java.util.*;

class Solution {

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<String>();

        Scanner scan = new Scanner(System.in);
 
        System.out.println("Enter the number:");
        int num = scan.nextInt();

        q.add("1");

        StringBuilder str_buff = new StringBuilder();
        String str = null;

        for (int i = 0; i< num; i++) {
            str = q.remove();

            System.out.println(str);
            str_buff.setLength(0);
            str_buff.append(str);
            str_buff.append("0");
            q.add(str_buff.toString());

            str_buff.setLength(0);
            str_buff.append(str);
            str_buff.append("1");
            q.add(str_buff.toString());
        }
    }
}
