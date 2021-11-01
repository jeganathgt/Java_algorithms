import java.util.*;

class solution {
    static void tower_of_hanoi(int n, char A, char B, char E) {
        if (n > 0) {
            tower_of_hanoi(n-1, A, E, B);
            System.out.printf("swift %d %c - %c\n", n, A, B);
            tower_of_hanoi(n-1, E, B, A);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= scan.nextInt();
        tower_of_hanoi(n, 'A', 'B', 'E');
    }
}
