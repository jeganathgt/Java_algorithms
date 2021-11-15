import java.util.*;

class tree_node {
    tree_node left;
    tree_node right;
    int value;
    tree_node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class solution {
    static tree_node build_tree(int[] preorder, int[] inorder, int n, int start, int end) {
        tree_node curr_node = null;

        if (start <= end) {
            curr_node = new tree_node(preorder[n]);
            int i = start;
            for (i = start; i<=end; i++) {
                if (inorder[i] == preorder[n]) {
                    curr_node.left  = build_tree(preorder, inorder, n+1, start, i-1);
                    curr_node.right = build_tree(preorder, inorder, n+(i - start + 1), i+1, end);
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
 
        System.out.println("Enter the pre-order array:");
        int []preorder = new int[len];

        for (int i=0;i<len; i++) {
            preorder[i] = scan.nextInt();
        }

        tree_node root = build_tree(preorder, inorder, 0, 0, len-1);
        print_inorder(root);
    }
}
