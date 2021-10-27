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
        int[] petrol   = new int[len];
        int[] distance = new int[len];

        Queue<Integer> q = new LinkedList<Integer>();

        System.out.println("Enter the petrol in each bunk:");
        for (int i = 0; i < len; i++) {
            petrol[i] = scan.nextInt();
        }

        System.out.println("Enter the distance in each bunk:");
        for (int i = 0; i < len; i++) {
            distance[i] = scan.nextInt();
            q.add(i);
        }

        while (true) {

        }
    }
}
