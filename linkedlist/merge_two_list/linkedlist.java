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
    static boolean compare_two_list(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (Integer curr_node1 : ll1) {
            if (map.containsKey(curr_node1)) {
                map.put(curr_node1, map.get(curr_node1) + 1);
            } else {
                map.put(curr_node1, 1);
            }
        }

        for (Integer curr_node2 : ll2) {
            if (map.containsKey(curr_node2)) {
                if (map.get(curr_node2) > 0) {
                    map.put(curr_node2, map.get(curr_node2) - 1);
                } 
                
                if (map.get(curr_node2) == 0) {
                    map.remove(curr_node2);
                }
            } else {
                map.put(curr_node2, 1);
            }
        }
        
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    static LinkedList<Integer> merger(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        Iterator itr1 = ll1.iterator();
        Iterator itr2 = ll2.iterator();

        LinkedList<Integer> output = new LinkedList<Integer>();
        Integer first  = null;
        Integer second = null;
        boolean update_first     = true;
        boolean update_second    = true;
        int count = 1;

        if (itr1.hasNext() == false || itr2.hasNext() == false) return output;

        first  = (Integer)itr1.next();
        second = (Integer)itr2.next();
        do {
            if (first <= second) {
                output.add(first);
                if (itr1.hasNext()) { 
                    first = (Integer)itr1.next();
                } else {
                    first = null;
                }
            } else {
                output.add(second);
                if (itr2.hasNext()) {
                    second = (Integer)itr2.next();
                } else {
                    second = null;
                }
            }
        } while (itr1.hasNext() && itr2.hasNext());

        if (first != null) {
            output.add(first);
            while (itr1.hasNext()) {
                first = (Integer)itr1.next();
                output.add(first);
            }
        }

        if (second != null) {
            output.add(second);
            while (itr2.hasNext()) {
                second = (Integer)itr2.next();
                output.add(second);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedList<Integer> ll1 = new LinkedList<Integer>();
        LinkedList<Integer> ll2 = new LinkedList<Integer>();

        System.out.println("Enter the length of list1 :");
        int length = scan.nextInt();

        System.out.println("Enter the list:");
        for (int i = 0; i < length; i++) {
            ll1.add(scan.nextInt());
        }

        System.out.println(ll1);

        System.out.println("Enter the length of list2 :");
        length = scan.nextInt();

        System.out.println("Enter the list:");
        for (int i = 0; i < length; i++) {
            ll2.add(scan.nextInt());
        }

        System.out.println(ll2);

        System.out.println("merge " + merger(ll1, ll2));
    }
}
