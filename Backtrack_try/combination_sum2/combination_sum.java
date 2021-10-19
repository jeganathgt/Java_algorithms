import java.util.*;

class combination_sum {
    static void combinations(LinkedList<String> result, ArrayList<Integer> int_arr, Integer index, Integer char_index, Integer[] array, Integer target) {
        if (target == 0) {
            result.add(int_arr.subList(0, char_index).toString());
            return;
        }

        if (target < 0) return;

        for (Integer i = index; i < array.length; i++) {
            if ((i > index) && (array[i] == array[i-1])) continue;

            if(int_arr.size() > char_index)
                int_arr.set(char_index, array[i]);
            else
                int_arr.add(array[i]);
            
            combinations(result, int_arr, i+1, char_index+1, array, target - array[i]);
        }

        return;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the target sum:");
        Integer target = scan.nextInt();

        System.out.println("Enter the len of array:");
        Integer len = scan.nextInt();

        System.out.println("Enter the array:");
        Integer[] array = new Integer[len];

        for (Integer i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }

        LinkedList<String> result = new LinkedList<String>();
        ArrayList<Integer> int_arr = new ArrayList<Integer>();

        //Arrays.sort(array);
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1-i2;
            }
        });

        combinations(result, int_arr, 0, 0, array, target);
        System.out.println(result);
    }
}
