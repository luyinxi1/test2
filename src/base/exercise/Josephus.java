package base.exercise;

import base.Queue.LinkedListQueue;
import base.Queue.Queue;
import base.stack.LinkedListStack;
import base.stack.Stack;

/**
 * 1.3.37 - 约瑟夫环问题的队列解法。
 * @author YCH
 */
public class Josephus {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        double n = Integer.parseInt(args[0]);
        double m = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
    }
}
