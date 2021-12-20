import java.util.*;

class closest_sum {
    static int findTargetSum(int[] array1, int[] array2, int i, int j, int target)
    {
        if (i < array1.length && j < array1.length) {
            int diff = Math.abs(array1[i] + array2[j] - target);
            if (diff < 3)
                System.out.println(""+(array1[i] + array2[j]) + " i=" + i + ", j=" + j);
        }

        if (i < array1.length && j < array1.length)
            findTargetSum(array1, array2, i, j+1, target);

        if (i < array1.length && j < array1.length)
            findTargetSum(array1, array2, i+1, j, target);

        return 0;
    }

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the input1:");
            String input1 = scan.next();
            System.out.println("Enter the input2:");
            String input2 = scan.next();

            int[] array1 = new int[input1.length()];
            int[] array2 = new int[input2.length()];

            for (int i = 0; i < input1.length(); i++) {
                array1[i] = Integer.valueOf(input1.charAt(i)) - 48;
            }

            for (int i = 0; i < input2.length(); i++) {
                array2[i] = Integer.valueOf(input2.charAt(i)) - 48;
            }

            System.out.println("input1: " + Arrays.toString(array1));
            System.out.println("input2: " + Arrays.toString(array2));

            System.out.println("Enter the target:");
            int target = scan.nextInt();

            findTargetSum(array1, array2, 0, 0, target);
     }
}
