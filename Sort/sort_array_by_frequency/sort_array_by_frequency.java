import java.util.*;

class sort_array_by_frequency {
    static int[] array;

    sort_array_by_frequency() {
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

        sort_array_by_frequency obj = new sort_array_by_frequency();

        HashMap<Integer, Integer> map       = new LinkedHashMap<Integer, Integer>();
        //HashMap<Integer, Integer> map_index = new HashMap<Integer, Integer>();

        for (int j = 0; j < array.length; j++) {
            if (map.containsKey(array[j])) {
                map.put(array[j], map.get(array[j]) + 1);
            } else {
                map.put(array[j], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> ll = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        System.out.println("interim : " + ll);

        Collections.sort(ll, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int first = o1.getValue();
                int second = o2.getValue();
                int first_key  = o1.getKey();
                int second_key = o2.getKey();
                return second - first;
            }
        });

        System.out.println("Output : ");
        for (Map.Entry<Integer, Integer> list : ll) {
            for (int i = 0; i < list.getValue(); i++) { 
                System.out.print(list.getKey() + " ");
            }
        }
        //for (int j = 0; j<= i; j++) {
        //    System.out.println(" " + array[j]);
        //}
    }
}
