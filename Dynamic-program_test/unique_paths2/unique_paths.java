import java.util.*;

/* unique paths in a matrix 
 * [0, 0, 0]
 * [0, 1, 0]
 * [0, 0, 0]
 */

class unique_paths {
    static int recursive(int row, int column, int [][] matrix) {
        if (row == 0 && column == 0) {
            return (matrix[0][0] == 0)? 1 : 0;
        }

        if (matrix[row][column] == 1) 
            return 0;


        int val = 0;
        if (column > 0) 
            val += recursive(row, column-1, matrix);

        if (row > 0)
            val += recursive(row-1, column, matrix);

        return val;
    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int [][]matrix = new int[num][num];

        for (int i = 0; i< num; i++) {
            for (int j = 0; j < num; j++) {
               matrix[i][j] = scan.nextInt(); 
            }
        }
        System.out.println("result: " + recursive(num-1, num-1, matrix));
    }
}
