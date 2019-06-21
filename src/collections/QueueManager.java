package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueManager {
    // Precisa implementar a interface comparable
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("A");
        queue.add("D");
        queue.add("B");
        queue.add("C");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
