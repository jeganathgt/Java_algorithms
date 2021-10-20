import java.util.*;

class solution {
    static void swap(int[] array, int dest, int source) {
        int temp      = array[dest];
        array[dest]   = array[source];
        array[source] = temp;
    }

    static void quick_sort(int[] array, int start, int end) {
        if (start<end) {
            int i = start-1;
            int j = start;
            int pivot = end;
            for (j = start; j<end; j++) {
                if (array[j] <= array[pivot]) {
                    i++;
                    swap(array, i, j);
                }
            }
            i++;
            swap(array, i, pivot);
            pivot = i;

            quick_sort(array, start, pivot-1);
            quick_sort(array, pivot+1, end);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        int[] array = new int[len];
        System.out.println("Enter the array:");

        for (int i = 0; i< len; i++) {
            array[i] = scan.nextInt();
        }

        quick_sort(array, 0, len-1);

        System.out.println(Arrays.toString(array));
    }
}
