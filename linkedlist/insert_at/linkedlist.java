import java.util.*;

class single_list_node {
    int list_data;
    single_list_node next;
    single_list_node(int data) {
        list_data = data;
        next = null;
    }
}

class singlylinkedlist {
    single_list_node head;
    single_list_node tail;
    int list_size;

    singlylinkedlist() {
        head      = null;
        tail      = null;
        list_size = 0;
    }

    boolean add(int data) {
        single_list_node node = new single_list_node(data);
        if(head == null) {
            head = node;
            tail = node;
            list_size = 1;
        } else {
            tail.next = node;
            tail = node;
            list_size++;
        }
        return true;
    }

    boolean insertAt(int data, int position) {
        single_list_node new_node = new single_list_node(data);
        if (position == 0) {
            new_node.next = head;
            head = new_node;
            return true;
        }

        int current = 1;
        single_list_node current_node = head;
        for (current = 1; current<position; current++) {
            if (current_node.next == null) {
                break;
            }
            current_node = current_node.next;
        }

        if (current == position) {
            //if (current_node != null) {
                new_node.next = current_node.next;
                current_node.next = new_node;
                return true;
            //}
        }

        return false;
    }

    void printlist() {
        single_list_node current_node = head;

        while (current_node != null) {
            System.out.print(current_node.list_data + "->");
            current_node = current_node.next;
        }
        System.out.println("null");
    }
}


class solution  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        singlylinkedlist ll = new singlylinkedlist();

        System.out.println("Enter the length of list :");
        int length = scan.nextInt();

        System.out.println("Enter the list:");
        for (int i = 0; i < length; i++) {
            ll.add(scan.nextInt());
        }
        ll.printlist();
        System.out.println("Enter the new node:");
        int new_node_data = scan.nextInt();

        System.out.println("Enter the new node location:");
        ll.insertAt(new_node_data, scan.nextInt());
        ll.printlist();
    }
}
