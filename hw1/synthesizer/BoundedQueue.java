package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();
    int fillCount();
    /**add item to the end*/
    void enqueue(T x);
    /**delete and return item from the front*/
    T deque();
    T peek();
    Iterator<T> iterator();
    default boolean isEmpty() {
        return this.fillCount() == 0;
    }
    default boolean isFull() {
        return this.capacity() == this.fillCount();
    }
}
