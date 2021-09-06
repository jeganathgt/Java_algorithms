import java.util.*;

class print_zigzag {
    static String input; 
    static int row_numbers = 0;
    static {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
        row_numbers = scan.nextInt();
    }

    public static void main(String[] args) {
        char [] array = input.toCharArray();
        StringBuffer []zigzag = new StringBuffer[row_numbers];

        for (int i = 0; i < row_numbers; i++) {
            zigzag[i] = new StringBuffer();
        }

        int k = 0;
        int ascending = 1;
        for (int i = 0; i<array.length; i++) {
            zigzag[k].append(array[i]);

            if (k >= (row_numbers-1)) {
                ascending = 0;
            } else if (k <= 0) {
                ascending = 1;
            }

            if (ascending == 1) {
                k++;
            } else {  
                k--;
            }
        }

        System.out.println("string [0] " + zigzag[0] + ", [1]" + zigzag[1] + ", [2]" + zigzag[2]);
        for (int i = 1; i<row_numbers; i++) {
            zigzag[0].append(zigzag[i]);
        }
        System.out.println(zigzag[0]);
    }
}
