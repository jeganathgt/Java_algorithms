import java.util.*;

class Points {
    int height;
    int length;
    Points(int length, int height) {
        this.length = length;
        this.height = height;
    }
}

class skyline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the no of building:");
        int len = scan.nextInt();

        Points [] points = new Points[len * 2];

        HashMap<Points, Points> hash= new HashMap<Points, Points>();

        int k = 0;
        int x,h,y = 0;
        System.out.println("Enter the Points:");
        for (int i = 0; i<len; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            h = scan.nextInt();
            points[k++] = new Points(x, h);
            points[k++] = new Points(y, h);
            hash.put(points[k-1], points[k-2]);
        }

        for (Map.Entry<Points, Points> entry : hash.entrySet()) {
            System.out.print("key= " + "(" + entry.getKey().length + "," + entry.getKey().height + ")");
            System.out.println(", Value= " + "(" + entry.getValue().length + "," + entry.getValue().height + ")");
        }

        Arrays.sort(points, new Comparator<Points>() {
            public int compare(Points first, Points second) {
                if (first.length != second.length) {
                    return first.length - second.length;
                } else {
                    return second.height - first.height;
                }
            }
        });


        PriorityQueue<Points> queue = new PriorityQueue<Points>(new Comparator<Points>() { public int compare(Points first, Points second){
                                                                                                       return second.height - first.height; }  
        });


        int prev_height = 0;
        Points top = null;
        Points toremove = null;
        for (int i = 0; i<(len*2); i++) {
            if (queue.isEmpty()) {
                System.out.println("i=" + i + " ," + "(" + points[i].length + "," + points[i].height + ")");
                queue.add(points[i]);
                continue;
            }

            if (hash.containsKey(points[i])) {
                toremove = hash.get(points[i]);
                queue.remove(toremove);
            } else {
                queue.add(points[i]);
            }

            if (!queue.isEmpty()) {
                top = queue.peek();
                if (top.height != prev_height) {
                    System.out.println("i=" + i + " ," + "(" + points[i].length + "," + top.height + ")");
                    prev_height = top.height;
                }
            } else {
                prev_height = 0;
                System.out.println("i=" + i + " ," + "(" + points[i].length + "," + "0" + ")");
            }
        }
    }
}
