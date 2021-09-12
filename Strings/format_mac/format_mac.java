import java.util.*;

class format_macg {
    static String input; 
    static {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
    }

    public static void main(String[] args) {
        String formatted_mac = input.replaceAll("(\\d{2})", ":$1").substring(1);
        System.out.println("formatted mac = " + formatted_mac);
    }
}
