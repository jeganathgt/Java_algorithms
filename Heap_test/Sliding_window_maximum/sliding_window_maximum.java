import java.util.*;

class priorityQueueAscending {
    int [] pq  = null;
    int length = 0;
    int maxSize = 0;
    priorityQueueAscending(int queueSize) {
        this.pq = new int[queueSize];
        maxSize = queueSize;
    }

    private void heapify(int root_index, int last_index) {
        int left  = ( 2 * root_index) + 1;
        int right = ( 2 * root_index) + 2;
        int biggest = root_index;
        
        if (left <= last_index) {
            if (pq[left] > pq[biggest])
                biggest = left;
        }

        if (right <= last_index) {
            if (pq[right] > pq[biggest])
                biggest = right;
        }

        if (biggest != root_index) {
            swap(root_index, biggest);
            heapify(biggest, last_index);
        }
    }

    private void swap(int dest, int start) {
        int temp = pq[dest];
        pq[dest] = pq[start];
        pq[start] = temp;
    }

    void add(int value) {
        if (length >= maxSize) return;

        pq[length++] = value;

        for (int i = (length/2)-1; i>=0; i--) 
            heapify(i, length-1);
    }

    void remove(int value) {
        if (length == 0) return;

        for (int i = 0; i< length; i++) {
            if (pq[i] == value) {
                swap(i, length-1);
                length--;
                heapify(i, length-1);
            }
        }
    }

    int getFirst() {
        int ret  = -1;
        if (length > 0) {
            ret = pq[0];
        }
        return ret;
    }

    int size() {
        return length;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int [] array = new int[len];
        for (int i = 0; i< len; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println("Enter the subarray size:");
        int subarraySize = scan.nextInt();

        priorityQueueAscending pq = new priorityQueueAscending(subarraySize);

        int []result = new int[len - subarraySize + 1];

        for (int i = 0; i < subarraySize; i++) {
            pq.add(array[i]);
        }

        int k = 0;
        for (int i = subarraySize; i < len; i ++) {
            result[k] = pq.getFirst();
            pq.remove(array[k++]);
            pq.add(array[i]);
        }
        result[k] = pq.getFirst();

        System.out.println(Arrays.toString(result));
    }
}
