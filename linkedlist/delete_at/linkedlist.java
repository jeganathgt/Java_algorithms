import java.util.*;

class linkedlist_node {
    linkedlist_node next = null;
    int data = 0;
    linkedlist_node(int data) {
        this.data = data;
        next = null;
    }
};

class single_linked_list {
    linkedlist_node head = null;
    linkedlist_node tail = null;
    int length = 0;
    
    boolean add(int data) {
        linkedlist_node new_node = new linkedlist_node(data);
        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        return true;
    }

    boolean insertAt(int data, int position) {
        int current = 1;
        linkedlist_node current_node = head;
        linkedlist_node newnode = new linkedlist_node(data);

        if (position == 0) {
            newnode.next = head;
            head = newnode;
            return true;
        }

        for (; current < position; current++) {
            if (current_node.next == null) break;
            current_node = current_node.next;
        }

        if (current == position) {
            newnode.next = current_node.next;
            current_node.next = newnode;
            return true;
        }
        return false;
    }

    boolean deleteAt(int position) {
        int current = 1;

        linkedlist_node current_node = head;

        if (position == 0) {
            head = head.next;
            return true;
        }

        for (; current<position; current++) {
            if (current_node.next == null) break;
            current_node = current_node.next;
        }

        if (current == position) {
           if (current_node.next != null) {
               current_node.next = current_node.next.next;
           }
           return true; 
        }
        return false;
    }

    void printlist() {
        linkedlist_node current_node = head;
        System.out.println("output:");
        while (current_node != null) {
            System.out.print(current_node.data + "->");
            current_node = current_node.next;
        }
        System.out.println("null");
    }
}

class solution  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        single_linked_list ll = new single_linked_list();

        System.out.println("Enter the length of list :");
        int length = scan.nextInt();

        System.out.println("Enter the list:");
        for (int i = 0; i < length; i++) {
            ll.add(scan.nextInt());
        }
        ll.printlist();

        System.out.println("Enter the delete node location:");
        ll.deleteAt(scan.nextInt());
        ll.printlist();
    }
}
