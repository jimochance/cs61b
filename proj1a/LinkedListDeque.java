public class LinkedListDeque<T> {
    private class Node {
        public Node pre;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            pre = p;
            item = i;
            next = n;
        }
    }

    private Node sentFront;
    private Node sentBack;
    private int size;

    public LinkedListDeque() {
        sentFront = new Node(null, null, null);
        sentBack = new Node(null, null, null);
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentFront = new Node(null, null, null);
        sentFront.next = new Node(null, item, null);
        sentBack = new Node(null, null, null);
        sentBack.pre = new Node(null, item, null);
        size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        Node prt = sentFront;
        while (prt != null) {
            System.out.print(prt.item + " ");
            prt = prt.next;
        }
        System.out.println();
    }

    public void addFirst(T item) {
        size += 1;
        sentFront.next = new Node(sentBack.pre, item, sentFront.next);
    }

    public void addLast(T item) {
        size += 1;
        sentBack.pre = new Node(sentBack.pre, item, sentFront.next);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T removed = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        return removed;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T removed = sentBack.pre.item;
        sentBack.pre = sentBack.pre.pre;
        return removed;
    }
}
