import java.util.*;

class roman_to_integer {
    static String input;
    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    static {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
    }


    public static void main(String[] args) {
        char [] array = input.toCharArray();
        map.put("I", 1);    
        map.put("IV", 4);    
        map.put("V", 5);    
        map.put("IX", 9);    
        map.put("X", 10);    
        map.put("XL", 40);    
        map.put("L", 50);    
        map.put("XC", 90);    
        map.put("C", 100);    
        map.put("CD", 400);    
        map.put("D", 500);    
        map.put("M", 1000);    

        int sum = 0;
        int prev_index = -1;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i<array.length; i++) {
            if ((prev_index >= 0) && (map.get(Character.toString(array[prev_index])) < map.get(Character.toString(array[i])))) {
                temp.delete(0, temp.length());
                temp.append(array[prev_index]);
                temp.append(array[i]);

                sum -= map.get(Character.toString(array[i-1]));
                sum += map.get(temp.toString());
            } else {
                sum += map.get(Character.toString(array[i]));
            }
            prev_index = i;
        }
        System.out.println("sum " + sum);
    }
}
