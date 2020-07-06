package base.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 一种表示定容栈的抽象数据类型
 * @author YCH
 */
public class FixedCapacityStackOfStrings<E> {
    private E[] a;
    private int n;

    public FixedCapacityStackOfStrings(int cap) {
        this.a = (E[]) new Object[cap];
        n = 0;
    }

    /**
     * 添加一个字符串。
     * @param s
     */
    public void push(E s) {
        this.a[n++] = s;
    }

    /**
     * 删除栈顶的字符串。
     * @return
     */
    public E pop() {
        return this.a[--n];
    }

    /**
     * 栈是否为空。
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }


    /**
     * 栈中的元素数量。
     * @return
     */
     public int size() {
        return n;
     }

     public boolean isFull() {
         return n == a.length;
     }
     public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> f = new FixedCapacityStackOfStrings<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item)) {
                f.push(item);
            } else if (!f.isEmpty()) {
                StdOut.print(f.pop() + " ");
            }
        }
        StdOut.println("(" + f.size() + ")");
    }
}
