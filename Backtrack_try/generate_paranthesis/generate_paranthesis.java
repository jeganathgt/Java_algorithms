import java.util.*;

class generate_paranthesis {
    static void backtrack(char[] result, int index, int len, int openbrace_cnt, int closebrace_cnt) {
        if (index >= (len*2)) {
            System.out.println(String.valueOf(result));
            return;
        }

        if (openbrace_cnt < len) {
            result[index] = '(';
            backtrack(result, index+1, len, openbrace_cnt+1, closebrace_cnt);
        }

        if (closebrace_cnt < openbrace_cnt) {
            result[index] = ')';
            backtrack(result, index+1, len, openbrace_cnt, closebrace_cnt+1);
        }

        return;
    }

    public static void main(String[] args) {
        int len;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        len = scan.nextInt();
        char[] result = new char[len*2];

        backtrack(result, 0, len, 0, 0);
    }
}
