import java.util.*;

/*
Print a pattern without using any loop
Given a number n, print following pattern without using 
any loop.
Input: n = 16
Output: 16, 11, 6, 1, -4, 1, 6, 11, 16
Input: n = 10
Output: 10, 5, 0, 5, 10
*/

class print_pattern {
    static int value;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the value:");
            value = scan.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void print_pattern(int value) {
        System.out.println(value);
        if (value > 0) {
            print_pattern(value-5);
            System.out.println(value);
        }
    }

    public static void main(String[] args) 
    {
       print_pattern(value); 
    }
}
