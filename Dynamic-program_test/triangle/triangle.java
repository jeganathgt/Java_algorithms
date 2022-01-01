import java.util.*;

class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the height of triangle:");
        int rows = scan.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<Integer>());
            System.out.println("Enter the numbers:");
            for (int j = 0; j<=i; j++) {
                list.get(i).add(scan.nextInt());
            }
            System.out.println(list.get(i));
        }

        int min    = Integer.MAX_VALUE;
        int result = 0;
        for (int i = rows-1; i>=0; i--) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j<=i; j++) {
                min = Math.min(list.get(i).get(j), min);
            }
            result += min;
        }
        System.out.println("Answer: " + result);
    }
}
