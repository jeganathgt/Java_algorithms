import java.util.*;

class solution {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<Integer>();

        HashMap<Character, Integer>hash = new HashMap<Character, Integer>();

        hash.put('C', 12);
        hash.put('O', 16);
        hash.put('H', 1);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the molecular compound:");
        String molecule = scan.next();

        for (int i = 0; i<molecule.length(); i++) {

            if (molecule.charAt(i) == ')') {
                if (stack.isEmpty() == false) {
                    int cum = 0;
                    while(stack.peek() != Integer.valueOf('(')) {
                        cum += stack.pop();
                        if (stack.isEmpty() == true) break;
                    }
                    stack.pop(); //pop "("
                    stack.push(cum);
                }
                continue;
            }

            if (((molecule.charAt(i) - 48) <= 9) && ((molecule.charAt(i) - 48) > 0)) {
                Integer peek = stack.pop();

                stack.push(peek * (molecule.charAt(i) - 48));
                continue;
            }

            if (molecule.charAt(i) == '(') {
                stack.push(Integer.valueOf(molecule.charAt(i)));
                continue;
            }


            stack.push(hash.get(molecule.charAt(i)));
        }

        int ans = 0;

        while(stack.isEmpty() == false) {
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}
