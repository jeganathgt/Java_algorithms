import java.util.*;

class tree_node {
    tree_node left;
    tree_node right;
    int value;
    tree_node(int value) {
        this.value = value;
        this.left  =  null;
        this.right =  null;
    }
}

class Solution {
    static void build_tree(tree_node root, int value) {
        if (value < root.value) {
            if (root.left != null) {
               build_tree(root.left, value);
            } else {
               root.left = new tree_node(value);
            }
        } else {
            if (root.right != null) {
                build_tree(root.right, value);
            } else {
                root.right = new tree_node(value);
            }
        }
    }

    static void print_tree(tree_node root) {
        if (root != null) {
            print_tree(root.left);
            System.out.print(" " + root.value);
            print_tree(root.right);
        }
    }

    static tree_node get_tree_node(tree_node root, int value) {
        if (root == null) return null;

        tree_node ret = null;
        if (value != root.value) {
            ret = get_tree_node(root.left, value);
            if (ret == null)
                ret = get_tree_node(root.right, value);
        } else {
            ret = root;
        }
        return ret;
    }


    static void find_validity(List<Integer> values, tree_node root, int min, int max) {
        if (root != null) {
            if ((root.value < min) && (root.value > max)) {
                values.add(root.value);
            } else {
                find_validity(values, root.left,  min, root.value);
                find_validity(values, root.right, root.value, max);
            }
        }
    }

    static void inorder_traversal(List<Integer>list, tree_node root) {
        if (root != null) {
            inorder_traversal(list, root.left);
            list.add(root.value);
            inorder_traversal(list, root.right);
        }
    }

    static void find_swapped_node(tree_node root) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(Integer.MIN_VALUE);
        inorder_traversal(list, root);

        list.add(Integer.MAX_VALUE);
        int first = -1;
        int second = -1;
        for (int i = 1; i<list.size()-1; i++) {
            if ((list.get(i-1) <= list.get(i)) && (list.get(i) <= list.get(i+1))) {
            } else {
                if (first == -1)
                    first  = list.get(i);
                else
                    second = list.get(i);
            }
        }
 
        tree_node temp1 = get_tree_node(root, first);
        tree_node temp2 = get_tree_node(root, second);

        int temp = temp1.value;
        temp1.value = temp2.value;
        temp2.value = temp;
        
        print_tree(root);
        System.out.println(" ");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");

        int []array = new int[len];
        array[0] = scan.nextInt();
        tree_node root = new tree_node(array[0]);

        for (int i = 1; i < len; i++) {
            array[i] = scan.nextInt();
            build_tree(root, array[i]);
        }

        print_tree(root);
    
        System.out.println(" ");
        System.out.println("Enter the nodes to swap:");
        int first  = array[scan.nextInt()];
        int second = array[scan.nextInt()];

        tree_node temp1 = get_tree_node(root, first);
        tree_node temp2 = get_tree_node(root, second);

        int temp = temp1.value;
        temp1.value = temp2.value;
        temp2.value = temp;
        
        print_tree(root);
        System.out.println(" ");

        find_swapped_node(root);

    }
}
