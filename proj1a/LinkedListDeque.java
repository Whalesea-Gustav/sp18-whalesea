/** Deque built in LinkedList.*/
public class LinkedListDeque<T> {
    /**pointer to prev deque*/
    private LinkedListDeque<T> prev;
    /** element storing T value.*/
    private T item;
    /**pointer to next deque.*/
    private LinkedListDeque<T> next;
    /**deque size.*/
    private int size;

    public LinkedListDeque() {

        this.prev = this;
        this.next = this;
        this.item = null;

        this.size = 0;

    }

    private LinkedListDeque(T i) {
        LinkedListDeque<T> temp = new LinkedListDeque<>();
        temp.item = i;
        this.item = null;

        this.next = temp;
        temp.prev = this;

        this.prev = temp;
        temp.next = this;

        this.size = 1;
    }

    public void addFirst(T i) {
        LinkedListDeque<T> temp = new LinkedListDeque<>();
        temp.item = i;

        temp.next = this.next;
        this.next.prev = temp;

        this.next = temp;
        temp.prev = this;

        this.size++;


    }

    public void addLast(T i) {
        LinkedListDeque<T> temp = new LinkedListDeque<>();
        temp.item = i;

        this.prev.next = temp;
        temp.prev = this.prev;
        this.prev = temp;
        temp.next = this;

        this.size++;
    }

    public boolean isEmpty() {
        if (this.next.item == null) {
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {
        LinkedListDeque<T> temp = this.next;

        while (temp.item != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }

        System.out.print("\n");
    }

    public T removeFirst() {
        this.sizeMinusOneAux();
        T result = this.next.item;
        this.next = this.next.next;
        this.next.prev = this;


        return result;
    }

    public T removeLast() {
        this.sizeMinusOneAux();
        T result = this.prev.item;
        this.prev = this.prev.prev;
        this.prev.next = this;

        return result;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        LinkedListDeque<T> temp = this.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }

        return temp.item;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return this.next.item;
        } else {
            return this.next.getRecursive(index - 1);

        }
    }

    private void sizeMinusOneAux() {
        if (this.size > 0) {
            this.size--;
        } else {
            return;
        }
    }
}

