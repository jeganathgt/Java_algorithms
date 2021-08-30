import java.util.*;

abstract class sort_input {
    int[] array;
    sort_input(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int[] get_sorted_array(){
        return array;
    }
  
    public abstract int[] sort();
}


abstract class merge_utils extends sort_input {
    merge_utils(int[] array) {
        super(array);
    }

    int merge_array(int start_index, int mid_index, int last_index) {
        int i = start_index;
        int j = mid_index + 1;
        int k = 0;
        int[] temp = new int[last_index - start_index + 1];
        while(i <= mid_index && j <= last_index) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid_index) {
            temp[k++] = array[i++];
        }

        while (j <= last_index) {
            temp[k++] = array[j++];
        }

        k = 0;
        i = start_index;
        while (i <= last_index) {
            array[i++] = temp[k++];
        }

        return 0;
    }


}

class merge_sort extends merge_utils {
    merge_sort(int[] array) {
        super(array);
    }

    private int recursive_sort(int start_index, int last_index) {
        if (start_index != last_index) {
            int mid = (start_index + last_index)/2;
            recursive_sort(start_index, mid);
            recursive_sort(mid+1, last_index);
            merge_array(start_index, mid, last_index);
        }
        return 0;
    }

    @Override
    public int[] sort() {
        recursive_sort(0, array.length -1);
        return array;
    } 
}


class merge_sort_iterative extends merge_utils {
    merge_sort_iterative(int[] array) {
        super(array);
    }

    @Override
    public int[] sort() {
        int start_index = 0;
        int last_index  = 0;
        int mid         = 0;

        for (int iter_len = 1; iter_len < array.length; iter_len *= 2) {
            for (int i = 0; i < array.length; i = last_index + 1) {
                start_index   = i;
                mid           = Integer.min(i + iter_len - 1, array.length - 1);
                last_index    = Integer.min(mid + iter_len, array.length - 1);
                merge_array(start_index, mid, last_index);
            }
        }
        return array; 
    }
}

abstract class quick_sort_utils extends sort_input {
    quick_sort_utils(int[] array) {
        super(array);
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int qsort_partition(int start_index, int last_index) {
            int pivot_v = array[last_index];
            int i       = start_index - 1;

            pivot_i = last_index;
            for (int j = start_index; j < last_index; j++) {
                if (array[j] <= pivot_v) {
                    i++;
                    swap(i, j);
                }
            }

            swap(i+1, pivot_i);
            pivot_i = i + 1;
            return pivot_i;
    }

    public void qsort_split(int start_index, int last_index) {
        if (start_index < last_index) {
            int pivot_i = last_index;

            pivot_i = qsort_partition(start_index, last_index);
            qsort_split(start_index, pivot_i -1);
            qsort_split(pivot_i+1, last_index);
        }
    }
}


class quick_sort extends quick_sort_utils {
    quick_sort(int[] array) {
        super(array);
    }

    @Override
    public int[] sort() {
        qsort_split(0, array.length - 1);
        return array;
    }
}


class quick_sort_iterative extends quick_sort_utils {
    quick_sort_iterative(int[] array) {
        super(array);
    }

    @Override
    public int[] sort() {
        int[] stack     = new int[2 * array.length];
        int top         = -1;
        int pivot_i     = -1;
        int start_index = 0;
        int last_index  = array.length-1;

        stack[++top] = start_index; //even index will point to start_index
        stack[++top] = last_index;  //odd index will point to last_index
        while (top >= 0) {
            last_index  = stack[top--];
            start_index = stack[top--];
            if (start_index < last_index) {
                pivot_i = qsort_partition(start_index, last_index);
                stack[++top] = start_index;
                stack[++top] = pivot_i -1;
                stack[++top] = pivot_i +1;
                stack[++top] = last_index;
            }
        }
        return array;
    }
}


abstract class heap_sort_utils extends sort_input {
    heap_sort_utils(int[] array) {
        super(array);
    }

    static 

    int heapify_recursive(int start_index) {
        

    }

}


class sort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of array:");

        int len = scan.nextInt();
        System.out.println("Enter the elements of array:");
        int i   = 0;
        int[] array = new int[len]; 
        while (i < len) {
            array[i++] = scan.nextInt();
        }

        merge_sort msort = new merge_sort(array);
        int[] sort_array = msort.sort();

        i = 0;
        System.out.print("merge sort recursive : ");
        while(i < sort_array.length) {
            System.out.print(sort_array[i++] + " ");
        }

        merge_sort_iterative msort_iter = new merge_sort_iterative(array);
        int[] sort_array_iter = msort_iter.sort();

        
        i = 0;
        System.out.print("\nmerge sort iterative : ");
        while(i < sort_array_iter.length) {
            System.out.print(sort_array_iter[i++] + " ");
        }

        quick_sort qsort = new quick_sort(array);
        int[] qsort_array = qsort.sort();
        i = 0;
        System.out.print("\nquick sort recursive : ");
        while(i < qsort_array.length) {
            System.out.print(qsort_array[i++] + " ");
        }

 
        quick_sort_iterative qsort_iter = new quick_sort_iterative(array);
        int[] qsort_array_iter = qsort_iter.sort();
        i = 0;
        System.out.print("\nquick sort iterative : ");
        while(i < qsort_array_iter.length) {
            System.out.print(qsort_array_iter[i++] + " ");
        }
    }
}
