import java.util.*;

class divide_two_nums_without_arithmetic {
    static int divident;
    static int divisor;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the divident:");
            divident = scan.nextInt();
            System.out.println("Enter the divisor:");
            divisor  = scan.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int divide(int divident, int divisor)
    {
        if (divident < divisor) {
            return 0;
        }

        return 1 + divide(divident - divisor, divisor);
    }

    public static void main(String[] args) 
    {
       System.out.println(divide(divident, divisor));
    }
}
