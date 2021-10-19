import java.util.*;

class permutations {
    static void permutate(LinkedList<List<Integer>> output, ArrayList<Integer> result, int[] array, HashSet<Integer> indexset, int current_index) {
        if (current_index == array.length) {
            output.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (indexset.contains(i)) continue;

            if (current_index >= result.size())
                result.add(array[i]);
            else 
                result.set(current_index, array[i]);

            indexset.add(i);
            permutate(output, result, array, indexset, current_index+1);
            indexset.remove(i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = 0;

        System.out.println("Enter the length of array:");
        len = scan.nextInt();

        System.out.println("Enter the array:");
        int[] array = new int[len];
        for (int i = 0; i<len; i++) {
            array[i] = scan.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<List<Integer>> output = new LinkedList<List<Integer>>();
        HashSet<Integer> indexset = new HashSet<Integer>();

        permutate(output, result, array, indexset, 0);
        System.out.println(output);
    }
}
