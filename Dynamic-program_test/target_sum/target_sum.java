import java.util.*;

class target_sum {
    static int recursive( ArrayList<String> output, int index, int[] array, int sum, int i, int target)
    {
        if (sum == target) {
            System.out.println(output.subList(0, index));
            //return 1;
        }

        if (i >= array.length) {
            return 0;
        }

        if (index >= output.size()) {
            output.add("" + "+"+array[i]);
        } else {
            output.set(index, "" + "+"+array[i]);
        }

        int val = 0;
        val += recursive(output, index + 1, array, sum + array[i], i + 1, target);


        if (index >= output.size()) {
            output.add("" + "-"+array[i]);
        } else {
            output.set(index, "" + "-"+array[i]);
        }
        val += recursive(output, index+1, array, sum - array[i], i + 1, target);
        return val;
    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the int array:");
        String sample = scan.next();
        int []array = new int[sample.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sample.charAt(i) - 48;
        }

        System.out.println(Arrays.toString(array));

        System.out.println("Enter the int target:");
        int target = scan.nextInt();

        ArrayList<String> output = new ArrayList<String>();

        int ans = recursive(output, 0, array, 0, 0, target);
        System.out.println("Ans:" + ans);
    }
}
