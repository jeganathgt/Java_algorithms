import java.util.*;

class Solution {

    static void swap(int[] array, int dest, int source) {
        System.out.println("swap " + dest + ", " + source);
        int temp = array[dest];
        array[dest] = array[source];
        array[source] = temp;
    }

    static void heapify(int[] array, int root, int len) {
        int left  = (2 * root) + 1;
        int right = (2 * root) + 2;
        int biggest = root;

        if (left < len) {
            if (array[left] > array[biggest]) 
                biggest = left;
        }

        if (right < len) {
            if (array[right] > array[biggest])
                biggest = right;
        }

        if (biggest != root) {
            swap(array, biggest, root);
            heapify(array, biggest, len);
        }
    }

    static void heapSort(int[] array) {
        for (int i = (array.length/2) - 1; i>=0; i--)
            heapify(array, i, array.length);

        for (int i = array.length-1; i>=0; i--) {
            swap(array, i, 0);
            heapify(array, 0, i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int [] array = new int[len];
        for (int i = 0; i< len; i++) {
            array[i] = scan.nextInt();
        }

        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
