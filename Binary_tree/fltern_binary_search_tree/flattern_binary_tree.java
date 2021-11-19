import java.util.*;

class tree_node {
    tree_node right;
    tree_node left;
    int value;
    tree_node(int value) {
        this.right = null;
        this.left  = null;
        this.value = value;
    }
}

class solution {
    static tree_node prevnode = null;
    static void flattern_tree(tree_node root) {
        if (root != null) {
            flattern_tree(root.right);
            flattern_tree(root.left);

            root.right = null;
            root.left = prevnode;


            prevnode = root;
        }
    }

    static tree_node build_binary_tree(int[] array, int index) {
        if (index >= array.length) return null;
        tree_node curr_node = null;
        if (array[index] != -1) {
            curr_node = new tree_node(array[index]);
            curr_node.left  = build_binary_tree(array, (2 * index) + 1);
            curr_node.right = build_binary_tree(array, (2 * index) + 2);
        }
        return curr_node;
    }

    static void print_tree(tree_node root) {
        if (root != null) {
            System.out.println(" " + root.value);
            print_tree(root.left);
            print_tree(root.right);
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

        flattern_tree(root);

        print_tree(root);
    }
}
