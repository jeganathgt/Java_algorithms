import java.util.*;

/*
Implement STring to integer
*/

class String_to_int {
    static String value;
    static {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the value:");
            value = scan.next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int String_to_int(String value, int index) throws Exception {
        int num = 0;
        if (index >= 0) {
            Character a = value.charAt(index);
            if (Character.isDigit(a) == false) {
                throw new Exception("unknown digit at " + index);
            }
            num = Integer.valueOf(value.charAt(index));
            num -= 48;
            num = ((int)Math.pow(10, (value.length() - index - 1)) * num) +  String_to_int(value, index-1);
        }
        return num;
    }

    public static void main(String[] args) 
    {
       try {
           System.out.println(String_to_int(value, value.length()-1));
       } catch (Exception e) {
           System.out.println(e);
       }
    }
}
