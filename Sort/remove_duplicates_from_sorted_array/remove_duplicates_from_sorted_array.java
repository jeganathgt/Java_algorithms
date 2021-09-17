import java.util.*;

class remove_duplicates_from_sorted_array {
    static int[] array;

    remove_duplicates_from_sorted_array() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of input array :");
        int len = scan.nextInt();
        array = new int[len];
        System.out.println("Enter the array elem:");
        for (int i = 0; i<len; i++) {
            array[i] = scan.nextInt();
        }
    }

    static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    static void split(int[] array, int start, int end) {
        if (start < end) {
            int pivot_index = end;
            int i = start -1;
            int j = start;
            for (j = start; j < end; j++) {
                if (array[j] <= array[pivot_index]) {
                    i++;
                    swap(array, i, j);
                }
            }
            i++;
            swap(array, i, pivot_index);
            pivot_index = i;
            split(array, start, pivot_index-1);
            split(array, pivot_index+1, end);
        }
    }

    static void merge(int[] array, int first_array_start, int second_array_start, int end) {
        int[] temp = new int[end - first_array_start + 1];

        int k = 0;
        int i = first_array_start;
        int i_last = second_array_start - 1;
        int j = second_array_start;

        while (i <= i_last && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= i_last) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, first_array_start, end - first_array_start + 1);
    }

    static void msort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (end - start)/2 + start;
            msort(array, start, mid);
            msort(array, mid+1, end);
            merge(array, start, mid+1, end);
        }
    }

    static void qsort(int[] array) {
        split(array, 0, array.length-1);
        return;
    }

    static void merge_sort(int[] array) {
        msort(array, 0, array.length-1);
    }

    public static void main(String[] arg) {

        remove_duplicates_from_sorted_array obj = new remove_duplicates_from_sorted_array();

        merge_sort(array);

        int i        = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i++;
                swap(array, i, j);
            }
        }

        System.out.println("Output : ");
        for (int j = 0; j<= i; j++) {
            System.out.println(" " + array[j]);
        }
    }
}
