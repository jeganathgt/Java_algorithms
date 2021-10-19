import java.util.*;

class combination_sum {
    static void backtrack(ArrayList<Integer> result, int target, int[] array, int current_index, int current_sum) {
        if (current_sum >= target) {
            if (current_sum == target) {
                System.out.println(result.subList(0, current_index).toString());
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (current_index >= result.size())
                result.add(array[i]);
            else
                result.set(current_index, array[i]);

            backtrack(result, target, array, current_index + 1, current_sum + array[i]);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the target:");
        int target = scan.nextInt();

        System.out.println("Enter the array len:");
        int len = scan.nextInt();

        int[] array = new int[len];

        for(int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        backtrack(result, target, array, 0, 0);
    }
}
