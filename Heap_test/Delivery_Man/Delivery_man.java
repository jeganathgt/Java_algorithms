import java.util.*;

class solution {
    static void swap(int[] array, int start, int dest) {
        int temp = array[start];
        array[start] = array[dest];

        array[dest] = temp;
    }

    static void heapify(int[] array, int start, int last) {
            int max  = start;
            int left  = (2 * start) + 1;
            int right = (2 * start) + 2;

            if ((left < last) && (array[max] < array[left])) {
                max = left;
            }

            if ((right < last) && (array[max] < array[right])) {
                max = right;
            }

            if (max != start) {
                swap(array, max, start);
                heapify(array, max, last);
            }
   }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int len   = scan.nextInt();
        int max_delivery_for_Andy = scan.nextInt();
        int max_delivery_for_bob = scan.nextInt();
        
        int[] tip_for_Andy = new int[len];
        for (int i=0; i<len; i++) {
            tip_for_Andy[i] = scan.nextInt();
        }

        int[] tip_for_bob = new int[len];
        for (int i=0; i<len; i++) {
            tip_for_bob[i] = scan.nextInt();
        }

        for (int i = (len/2)-1; i>=0; i--) {
            heapify(tip_for_Andy, i, len);
            heapify(tip_for_bob, i, len);
        }

        System.out.println(Arrays.toString(tip_for_Andy));
        System.out.println(Arrays.toString(tip_for_bob));

        int sum = 0;
        int andy_delivery_count = 0;
        int bob_delivery_count = 0;
        int total_delivery_count = 0;

        while ((total_delivery_count < len) && (andy_delivery_count < max_delivery_for_Andy) && (bob_delivery_count < max_delivery_for_bob)) {
            if (tip_for_Andy[0] > tip_for_bob[0]) {
                sum += tip_for_Andy[0];
                andy_delivery_count++;
                swap(tip_for_Andy, 0, len-andy_delivery_count);
                heapify(tip_for_Andy, 0, len-andy_delivery_count);

            } else {
                sum += tip_for_bob[0];
                bob_delivery_count++;
                swap(tip_for_bob, 0, len-bob_delivery_count);
                heapify(tip_for_bob, 0, len-bob_delivery_count);
            }
            total_delivery_count = andy_delivery_count + bob_delivery_count;
        }

        while ((total_delivery_count < len) && (andy_delivery_count < max_delivery_for_Andy)) {
                sum += tip_for_Andy[0];
                andy_delivery_count++;
                total_delivery_count++;
                swap(tip_for_Andy, 0, len-andy_delivery_count);
                heapify(tip_for_Andy, 0, len-andy_delivery_count);
        }

        while((total_delivery_count < len) && (bob_delivery_count < max_delivery_for_bob)) {
                sum += tip_for_bob[0];
                bob_delivery_count++;
                total_delivery_count++;
                swap(tip_for_bob, 0, len-bob_delivery_count);
                heapify(tip_for_bob, 0, len-bob_delivery_count);
        }

        System.out.println(sum);
    }
}
