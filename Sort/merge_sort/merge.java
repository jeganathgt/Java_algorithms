import java.util.*;

class solution {
    static void merge(int[] array, int firstArrayStart, int secondArrayStart, int end) {
        int i     = firstArrayStart;
        int i_end = secondArrayStart - 1;
        int j     = secondArrayStart;
        int j_end = end;
        int k     = 0;

        int[] temp = new int[(end - firstArrayStart + 1)];

        while (i <= i_end && j <= j_end) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= i_end) {
            temp[k++] = array[i++];
        }

        while (j <= j_end) {
            temp[k++] = array[j++];
        }

        k = 0;
        i = firstArrayStart;
        for (k = 0; k < (end - firstArrayStart + 1); k++) {
            array[i++] = temp[k];
        }

    }

    static void merge_sort(int[] array, int start, int end) {
        if (start<end) {
            int mid = (end - start)/2 + start;
            merge_sort(array, start, mid);
            merge_sort(array, mid + 1, end);

            merge(array, start, mid + 1, end);
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

        merge_sort(array, 0, len-1);

        System.out.println(Arrays.toString(array));
    }
}
