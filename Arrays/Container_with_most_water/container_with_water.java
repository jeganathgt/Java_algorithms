import java.util.*;

class container_with_most_water {
    int len = 0;
    int [] array;

    container_with_most_water() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the arr len:\n");
        len = scan.nextInt();
        array = new int[len];
        System.out.println("Enter the arr elements:\n");
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
    }

    public static void main(String[] args) {
        container_with_most_water container = new container_with_most_water();

        /*
         * O(n) - time 
         * O(2n) - space
         */
        int[] left_height = new int[container.len];
        int[] right_height = new int[container.len];
        int volume = 0;

        for (int i = 0; i<container.len; i++) {
            left_height[i] = Math.max(container.array[i], left_height[Math.max(i-1, 0)]);
        }

        for (int i = container.len-1; i>=0; i--) {
            right_height[i] = Math.max(container.array[i], right_height[Math.min(i+1, container.len-1)]);
        }

        for (int i = 0; i<container.len; i++) {
            volume += (Math.min(left_height[i], right_height[i]) - container.array[i]);
        }

        System.out.println("Volume output 1:" + volume);


        /*
         * O(n) - time 
         * O(1) - space
         */
        
        for (int i = 0; i < container.len; i++) {

        }
    }
}
