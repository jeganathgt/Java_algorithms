import java.util.*;

class longest_valid_parenthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<Integer>();

        String parenthesis = new String();
        parenthesis = scan.next();
        Character ch = 0;
        for (int i = 0; i < parenthesis.length(); i++) {
            ch = parenthesis.charAt(i);
            if (ch == ')') {
                if (stack.size() != 0)
                    stack.pop();
            } else {
                stack.push(i);
            }
        }
        int start_element = (stack.size() != 0) ? stack.pop() : -1;
        System.out.println("Length:" + (parenthesis.length() - start_element - 1));
    }
}
