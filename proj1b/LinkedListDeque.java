public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node node = sentinel;
        while (node != sentinel) {
            node = node.next;
            System.out.print(sentinel.item + " ");
        }
        System.out.println();
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removed;
    }

    @Override
    public T get(int index) {
        int count = 0;
        Node node = sentinel;
        while (node.next != sentinel) {
            node = node.next;
            if (count == index) {
                return node.item;
            }
            count++;
        }
        return null;
    }

    private T getRecursiveHelper(int index, int count, Node node) {
        if (index == count) {
            return node.item;
        }
        return getRecursiveHelper(index, count + 1, node.next);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int count = 0;
        Node node = sentinel.next;
        return getRecursiveHelper(index, count, node);
    }
}
