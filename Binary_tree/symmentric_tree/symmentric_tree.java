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
    static void build_binary_tree(tree_node root, int value) {

        Deque<tree_node> queue = new LinkedList<tree_node>();
        queue.add(root);

        tree_node temp = null;
        while (queue.isEmpty() == false) {
            temp = queue.pop();
            if (temp.left == null) {
                temp.left = new tree_node(value);
                break;
            } else if (temp.left != null){
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new tree_node(value);
                break;
            } else if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    static void build_bst_tree(tree_node root, int value) {
        Deque<tree_node> queue = new LinkedList<tree_node>();
        tree_node temp = null;
        queue.add(root);
        while(queue.isEmpty() == false) {
            temp = queue.pop();
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = new tree_node(value);
                    return;
                } else {
                    queue.add(temp.left);
                }
            } else {
                if (temp.right == null) {
                    temp.right = new tree_node(value);
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
        }
    }

    static boolean check_symmentricity(tree_node root) {

        Deque<tree_node> queue            = new LinkedList<tree_node>();
        Deque<tree_node> queue_from_right = new LinkedList<tree_node>();

        queue.add(root);
        queue_from_right.add(root);

        int curr_level_len = 0;
        int curr_level_len_from_right = 0;
        boolean result = false;
        tree_node temp = null;
        tree_node temp_from_right = null;

        while ((queue.isEmpty() == false) && (queue_from_right.isEmpty() == false)) {

            curr_level_len = queue.size();
            curr_level_len_from_right = queue_from_right.size();

            for (int i=0; i<curr_level_len; i++) {
                temp = queue.pop();
                temp_from_right = queue_from_right.pop();

                if ((temp == null) && (temp_from_right == null)) {
                    continue;
                } else if ((temp == null || temp_from_right == null)) {
                    return result;
                }

                if (temp.value != temp_from_right.value) 
                    return result;

                queue.add(temp.left);
                queue.add(temp.right);
                queue_from_right.add(temp_from_right.right);
                queue_from_right.add(temp_from_right.left);
            }
        }

        if (queue.isEmpty() == queue_from_right.isEmpty()) 
            result = true;

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");

        tree_node root = new tree_node(scan.nextInt());
        for (int i = 1; i<len; i++) {
            build_binary_tree(root, scan.nextInt());
        }

        System.out.println(check_symmentricity(root));
    }
}
