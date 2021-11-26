import java.util.*;

class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the n:");
        int n = scan.nextInt();

        Deque<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i<= n; i++) {
            queue.add(i);
        }

        System.out.println("Enter the k:");
        int k = scan.nextInt();

        while (queue.size() > 1) {
            for (int i = 0; i< k; i++) {
                queue.add(queue.pop());
            }
            queue.pop();
        }
        System.out.println("ans:" + queue.peek());
    }
}
