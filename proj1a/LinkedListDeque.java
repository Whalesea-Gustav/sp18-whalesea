public class LinkedListDeque<T> {
    public LinkedListDeque<T> prev;
    public T item;
    public LinkedListDeque<T> next;
    public int size;

    public LinkedListDeque() {

        this.prev = this;
        this.next = this;
        this.item = null;

        this.size = 0;

    }

    public LinkedListDeque(T i) {
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
        T result = this.next.item;
        this.next = this.next.next;
        this.next.prev = this;

        return result;
    }

    public T removeLast() {
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
            return this.next.getRecursive(index-1);

        }
    }

    /*
    public static void main(String[] args){
        LinkedListDeque<Integer> deque1 = new LinkedListDeque<>(10);
        deque1.addFirst(0);
        System.out.println(deque1.item);
        System.out.println(deque1.next.item);
        System.out.println(deque1.next.next.item);
        System.out.println(deque1.next.next.next.item);

        System.out.println("------------------");
        System.out.println(deque1.get(0));
        System.out.println(deque1.get(1));

        System.out.println("-----getIterative-----");
        deque1.addLast(20);
        System.out.println(deque1.get(0));
        System.out.println(deque1.get(1));
        System.out.println(deque1.get(2));
        System.out.println(deque1.get(3));
        System.out.println(deque1.size());

        System.out.println("-----getRecursive-----");
        System.out.println(deque1.getRecursive(0));
        System.out.println(deque1.getRecursive(1));
        System.out.println(deque1.getRecursive(2));
        System.out.println(deque1.getRecursive(3));
        System.out.println(deque1.size());

        System.out.println("------------------");

        deque1.printDeque();

        System.out.println("------------------");
        System.out.println(deque1.removeFirst());
        deque1.printDeque();

        System.out.println("------------------");
        LinkedListDeque<Integer> deque2 = new LinkedListDeque<>(10);
        deque2.printDeque();

        System.out.println("------------------");
        deque1.printDeque();
        System.out.println(deque1.removeLast());
        deque1.printDeque();

        System.out.println("------------------");
        System.out.println(deque1.isEmpty());
        deque1.removeLast();
        System.out.println(deque1.isEmpty());

    }
    */
}
