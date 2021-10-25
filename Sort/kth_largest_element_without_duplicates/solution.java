import java.util.*;

class solution {
    static void swap(int[] array, int dest, int source) {
        int temp      = array[dest];
        array[dest]   = array[source];
        array[source] = temp;
    }

    static int randomised_selection(int[] array, int k, int start, int n) {
        int element = -1;
        if (start < n) {
            int i = start -1;
            int pivot = n;


            for (int j = start; j<n; j++) {
                if (array[j] < array[pivot]) {
                    i++;
                    swap(array, i, j);
                }
            }
            i++;
            swap(array, i, pivot);
            pivot = i;

            if (k < pivot) {
                element = randomised_selection(array, k, start, pivot-1);
            } else if (k > pivot) {
                element = randomised_selection(array, k, pivot+1, n);
            } else {
                element = array[pivot];
            }
        }
        return element;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the array len:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int [] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println("Enter the kth:");
        int k = scan.nextInt();

        int element = 0;
        element = randomised_selection(array, k-1, 0, len-1);
        System.out.println("kth element:" + element);
    }
}
