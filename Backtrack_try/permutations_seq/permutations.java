import java.util.*;

class permutations {
    static void permutuate(LinkedList<String> samp_output, ArrayList<Integer> curr_op, int curr_index, HashSet<Integer> set, ArrayList<Integer> array) {
        if (curr_index >= array.size()) {
            samp_output.add(curr_op.toString());
            System.out.println(samp_output.size() + curr_op.toString());
            return ;
        }

        for (int i = 0; i< array.size(); i++) {
            if (set.contains(i)) continue;

            if (curr_index < curr_op.size())
                curr_op.set(curr_index, array.get(i));
            else
                curr_op.add(array.get(i));

            set.add(i);
            permutuate(samp_output, curr_op, curr_index+1, set, array);
            set.remove(i);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the len of array:");
        int len = scan.nextInt();

        System.out.println("Enter the kth permutation:");
        int k = scan.nextInt();

        ArrayList<Integer> array = new ArrayList<Integer>();
        int[] fact = new int[len+1];

        fact[0] = 1;
        for (int i= 1; i<= len; i++) {
            array.add(i);
            fact[i] = fact[i-1] * i;
        }


        int n = len;
        int result = 0;
        StringBuilder output = new StringBuilder();

        LinkedList<String> samp_output = new LinkedList<String>();

        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> curr_op = new ArrayList<Integer>();

        permutuate(samp_output, curr_op, 0, set, array);

        while(n > 0) {
            result = (((k-1)<0)?0:(k-1))/fact[n-1];
            output.append(""+array.get(result));
            array.remove(result);
            k = (((k-1)<0)?0:(k-1))% fact[n-1];
            n--;
        }

        //output.append(""+array.get(k));
        System.out.println(output);
    }
}
