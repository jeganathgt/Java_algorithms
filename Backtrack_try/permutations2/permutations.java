import java.util.*;

class permutations {
    static void permutuate(LinkedList<ArrayList<Integer>> output, ArrayList<Integer> result, int []array, int current_index, HashSet<Integer> indexset) {
        if (current_index >= array.length) {
            output.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = 0; i<array.length; i++) {
            if (indexset.contains(i)) continue;

            if (i> 0 && array[i-1] == array[i] && indexset.contains(i-1)==false) continue;

            if (current_index >= result.size()) {
                result.add(array[i]);
            } else {
                result.set(current_index, array[i]);
            }

            indexset.add(i);
            permutuate(output, result, array, current_index+1, indexset);
            indexset.remove(i);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the len of array:");
        int len = scan.nextInt();
        int []array = new int[len];
        System.out.println("Enter the array:");
        for (int i = 0; i< len; i++) {
            array[i] = scan.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<ArrayList<Integer>> output= new LinkedList<ArrayList<Integer>>();
        HashSet<Integer> indexset = new HashSet<Integer>();

        permutuate(output, result, array, 0, indexset);
        System.out.println(output);
    }
}
