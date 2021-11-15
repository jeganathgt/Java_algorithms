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
    static tree_node build_tree(int[] postorder, int[] inorder, int n, int start, int end) {
        tree_node curr_node = null;
        if (start <= end) {
            curr_node = new tree_node(postorder[n]);
            for (int i = start; i<=end; i++) {
                if (inorder[i] == postorder[n]) {
                    curr_node.right = build_tree(postorder, inorder, n-1, i+1, end);
                    curr_node.left  = build_tree(postorder, inorder, n-(i - start + 1), start, i-1);
                    break;
                }
            }
        }
        return curr_node;
    }

    static void print_inorder(tree_node root) {
        if (root != null) {
            print_inorder(root.left);
            System.out.println(" " + root.value);
            print_inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        int len = scan.nextInt();

        System.out.println("Enter the inorder array:");
        int []inorder = new int[len];
        for (int i=0;i<len; i++) {
            inorder[i] = scan.nextInt();
        }
 
        System.out.println("Enter the postorder array:");
        int []postorder = new int[len];

        for (int i=0;i<len; i++) {
            postorder[i] = scan.nextInt();
        }

        tree_node root =  build_tree(postorder, inorder, len-1, 0, len-1);
        print_inorder(root);
    }
}
