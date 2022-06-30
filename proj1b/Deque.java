/**
    Includes all of the methods that appear in both ArrayDeque and LinkedListDeque
 */

public interface Deque<T> {
    int size();

    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    void printDeque();

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T get(int index);
}
