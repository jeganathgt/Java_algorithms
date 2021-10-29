import java.util.*;

class Solution {

    static void add_cache(LinkedList<String> ll, Queue<Integer> q) {
        StringBuilder str = new StringBuilder();

        for (Integer data : q) {
            str.append(data.toString());
        }
        ll.add(str.toString());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the len:");

        int len = scan.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();

        System.out.println("Enter the arr:");
        for (int i = 0; i < len; i++) {
            q.add(scan.nextInt());
        }

        LinkedList<String> ll = new LinkedList<String>();
        int op = 0;

        add_cache(ll, q);
        while(true) {
            System.out.println("Enter the operation:");
            System.out.println("1)Add\n2)delete\n3)print nth order");
            op = scan.nextInt();
            if (op == 1) {
                q.add(scan.nextInt());
                add_cache(ll, q);
            } else if (op == 2) {
                q.remove(scan.nextInt());
                add_cache(ll, q);
            } else if (op == 3) {
                int pos = 0;
                pos = scan.nextInt();
                for (String s : ll) {
                    if (pos == 0) {
                        System.out.println("output:" + s);
                        break;
                    }
                    pos--;
                }
            }
        }
    }
}
