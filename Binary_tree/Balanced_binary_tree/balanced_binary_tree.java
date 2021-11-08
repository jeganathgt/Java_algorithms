import java.util.*;

class tree_node {
    tree_node right;
    tree_node left;
    int value;
    tree_node(int value) {
        this.value = value;
        this.right = null;
        this.left  = null;
    }

    public String toString() {
        return new String(Integer.toString(this.value));
    }
}

class solution {
    static tree_node build_tree(int[] array, int index) {
        tree_node curr_node = null;
        if (index < array.length) {
            if (array[index] != -1) {
                curr_node = new tree_node(array[index]);
                curr_node.left  = build_tree(array, (2 * index) + 1);
                curr_node.right = build_tree(array, (2 * index) + 2);
            }
        }
        return curr_node;
    }

    static int find_height(int min, tree_node root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        if (min == 1) {
            height = Math.min(find_height(1, root.left), find_height(1, root.right));
        } else {
            height = Math.max(find_height(0, root.left), find_height(0, root.right));
        }

        return height+1;
    }


    static boolean check_balanced(tree_node root) 
    {
        int min_height = Math.min(find_height(1, root.left), find_height(1, root.right));
        int max_height = Math.max(find_height(0, root.left), find_height(0, root.right));

        return ((max_height - min_height) >= 2) ? false : true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");

        int[] array = new int[len];
        for (int i = 0; i<len; i++) {
            array[i] = scan.nextInt();
        }

        tree_node root = build_tree(array, 0);

        System.out.println(check_balanced(root));
    }
}
