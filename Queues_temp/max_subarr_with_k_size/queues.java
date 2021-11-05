import java.util.*;

class Solution {

    public static void main(String[] args) {
        int max_size = Integer.MIN_VALUE;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the len:");
        Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                                              public int compare(Integer i1, Integer i2) {
                                                  return i2 - i1;
                                              }
        });

        int len = scan.nextInt();
        int[] arr = new int[len];

        System.out.println("Enter the arr:");
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the subarr len:");
        int sub_len = scan.nextInt();
        int j = -1;
        int val = 0;
        for (int i = 0; i<len; i++) {
            q.add(arr[i]);
            if (i >= sub_len) {
                j++;
                q.remove(arr[j]);
                System.out.print(q.peek());
            }
            System.out.println(q);
        }
    }
}
