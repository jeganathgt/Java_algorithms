import java.util.*;

class tree_node {
    tree_node right;
    tree_node left;
    tree_node next;
    int value;
    tree_node(int value) {
        this.right = null;
        this.left  = null;
        this.next = null;
        this.value = value;
    }
}

class solution {
    static tree_node build_binary_tree(int[] array, int index) {
        tree_node curr_node = null;
        if (index < array.length) {
            if (array[index] != -1) {
                curr_node = new tree_node(array[index]);
                curr_node.left  = build_binary_tree(array, (2 * index) + 1);
                curr_node.right = build_binary_tree(array, (2 * index) + 2);
            }
        }
        return curr_node;
    }

    static void build_list_each_level(tree_node root) {
        Deque <tree_node> list = new LinkedList<tree_node>();

        tree_node curr_node = null;
        int curr_len = 0;
        list.add(root);
        tree_node prev = null;
        tree_node temp = null;
        while(list.isEmpty() == false) {
            curr_len = list.size();
            prev = null;
            temp = list.peek();
            for (int i = 0; i<curr_len; i++) {
                curr_node = list.pop();

                if (curr_node.left != null) 
                    list.add(curr_node.left);

                if (curr_node.right != null) 
                    list.add(curr_node.right);

                if (prev != null) {
                    prev.next = curr_node;
                }
                prev = curr_node;
            }
        }
    }

    static void print_tree(tree_node root) {
        if (root != null) {
            System.out.print(" " + root.value);
            print_tree(root.left);
            print_tree(root.right);
        }
    }

    static void print_tree_each_level(tree_node root, int level) {
        if (root != null) {
            System.out.print(" level " + level + " ");
            tree_node temp = root;
            while(root != null) {
                System.out.print(" " + root.value);
                root = root.next;
            }
            System.out.println("");
            print_tree_each_level(temp.left, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");

        int [] array = new int[len];
        for (int i = 0; i<len; i++) {
            array[i] = scan.nextInt();
        }

        tree_node root = build_binary_tree(array, 0);

        build_list_each_level(root);

        print_tree_each_level(root, 1);
    }
 }
