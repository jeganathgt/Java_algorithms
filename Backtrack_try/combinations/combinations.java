import java.util.*;

class permutations {
    static void permutuate(LinkedList<String> samp_output, Integer[] array, int curr_index, HashSet<Integer> set, int n, int start_index) {
        if (curr_index >= array.length) {
            samp_output.add(Arrays.toString(array));
            return ;
        }

        for (int i = start_index; i<= n; i++) {
            if (set.contains(i)) continue;

            array[curr_index] = i;
            set.add(i);
            permutuate(samp_output, array, curr_index + 1, set, n, i+1);
            set.remove(i);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the n:");
        int n = scan.nextInt();

        System.out.println("Enter the k combinations:");
        int k = scan.nextInt();

        Integer[] array = new Integer[k];
        LinkedList<String> samp_output = new LinkedList<String>();

        HashSet<Integer> set = new HashSet<Integer>();

        permutuate(samp_output, array, 0, set, n, 1);

       //output.append(""+array.get(k));
        System.out.println(samp_output);
    }
}
