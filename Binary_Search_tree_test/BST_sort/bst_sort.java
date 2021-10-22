import java.util.*;

class treeNode {
    int value;
    treeNode Right;
    treeNode Left;
    treeNode(int value) {
        this.value = value;
        this.Right = null;
        this.Left = null;
    }
}


class Solution {
    static void buildTree(int[] array, treeNode root, int index) {
        if (index < array.length) {
            if (array[index] < root.value) {
                if (root.Left != null) {
                    buildTree(array, root.Left, index);
                } else {
                    root.Left = new treeNode(array[index]);
                }
            } else if (array[index] > root.value) {
                if (root.Right != null) {
                    buildTree(array, root.Right, index);
                } else {
                    root.Right = new treeNode(array[index]);
                }
            }
        }
    }

    static void inOrderTraverse(ArrayList<Integer> list, treeNode root) {
        if (root != null) {
            inOrderTraverse(list, root.Left);
            list.add(root.value);
            inOrderTraverse(list, root.Right);
        }
    }

    static void bstSort(int[] array) {
        treeNode root = new treeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            buildTree(array, root, i);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrderTraverse(list, root);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length:");
        int len = scan.nextInt();

        System.out.println("Enter the array:");
        int [] array = new int[len];
        for (int i = 0; i< len; i++) {
            array[i] = scan.nextInt();
        }

        bstSort(array);
        System.out.println(Arrays.toString(array));
    }
}
