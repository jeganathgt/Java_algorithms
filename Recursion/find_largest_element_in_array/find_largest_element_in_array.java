import java.util.*;

/*
Find the largest element in array
*/

class find_array_element {
    static int[] array;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the len:");
            int len = scan.nextInt();
            array = new int[len];
            System.out.println("Enter the array:");
            for (int i = 0; i<len; i++) {
                array[i] = scan.nextInt();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int find_biggest(int[] array, int n)
    {
        if (n == 0) {
            return array[n];
        }

        int biggest = find_biggest(array, n-1);
        if (biggest < array[n]) {
            biggest = array[n];
        }
        return biggest;
    }

    static int find_smallest(int[] array, int n)
    {
        if (n == 0) {
            return array[n];
        }

        int smallest = find_smallest(array, n-1);
        if (smallest > array[n]) {
            smallest = array[n];
        }
        return smallest;
    }

    public static void main(String[] args) {
        int biggest   = find_biggest(array, array.length-1);
        int smallest  = find_smallest(array, array.length-1);
        System.out.println("Biggest " + biggest + ", smallest " + smallest);
    }
}
