import java.util.*;

class gen_subsets {
    static void gen_subsets_using_queue(int n) {

        Queue<String> queue = new LinkedList<String>();
        for (int i=1; i<=n; i++) {
            queue.add(String.valueOf(i));
        }

        Integer num = 0;
        while(queue.size() != 0) {
            num = Integer.valueOf(queue.remove());
            System.out.println(num);
            if ((num%10) < n) {
                for (int i = (num%10)+1; i<=n; i++) {
                    queue.add(String.valueOf(num) + i);
                }
            }
        }
    }

    static void gen_subsets_using_recursion(LinkedHashSet<Integer>q, int n, int len) {
        if (n > len) {
            System.out.println(q);
            return;
        }

        gen_subsets_using_recursion(q, n+1, len);
        q.add(n);
        gen_subsets_using_recursion(q, n+1, len);
        q.remove(n);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = 0;

        System.out.println("Enter the length of array:");
        len = scan.nextInt();

        gen_subsets_using_queue(len);

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        gen_subsets_using_recursion(set, 1, len);
    }
}
