/**deque built in Array.*/
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextLast = 5;
    private int nextFirst = 4;

    public ArrayDeque() {
        this.size = 0;
        this.items = (T[]) new Object[8];
    }
    public void addFirst(T i) {
        /*this.nextFirst == this.nextLast*/
        /*this.size == this.items.length - 1*/
        if (this.size == this.items.length - 1) {
            this.resize(this.items.length * 2);
        }
        this.size++;
        this.items[this.nextFirst] = i;
        this.nextFirstMinusOne();
    }
    private void nextFirstMinusOne() {
        if (this.nextFirst == 0) {
            this.nextFirst = this.items.length - 1;
        } else {
            this.nextFirst--;
        }
    }
    public void addLast(T i) {
        /*this.next == this.first*/
        /*this.size == this.items.length - 1*/
        if (this.size == this.items.length - 1) {
            this.resize(this.items.length * 2);
        }
        this.size++;
        this.items[nextLast] = i;
        this.nextLastAddOne();
    }
    private void nextLastAddOne() {
        if (this.nextLast == this.items.length - 1) {
            this.nextLast = 0;
        } else {
            this.nextLast++;
        }
    }
    private void resize(int capacity) {
        if (this.nextFirst >= this.nextLast) {
            T[] temp = (T[]) new Object[capacity];
            //calculate the difference between capacity and items length
            // in case of capacity is less than items length
            int dif = capacity - this.items.length;
            System.arraycopy(this.items, 0,
                    temp, 0, this.nextLast);
            this.nextFirst += dif;
            if (this.nextFirst == capacity - 1) {
            } else {
                System.arraycopy(this.items, this.nextFirst - dif + 1,
                        temp, this.nextFirst + 1, capacity - 1 - this.nextFirst);
            }
            this.items = temp;
        } else if (this.nextFirst < this.nextLast) {
            T[] temp = (T[]) new Object[capacity];
            System.arraycopy(this.items, this.nextFirst + 1,
                    temp, 1, this.size);
            this.nextFirst = 0;
            this.nextLast = this.size + 1;
            this.items = temp;
        }
    }
    public boolean isEmpty() {
        return (this.size == 0);
    }
    public T get(int index) {
        if (this.nextFirst < this.nextLast) {
            return this.items[this.nextFirst + index + 1];
        } else if (this.nextFirst == this.items.length - 1) {
            return this.items[index];
        } else if (index <= (this.items.length - this.nextFirst - 2)) {
            return this.items[index + this.nextFirst + 1];
        } else {
            return this.items[index - (this.items.length - this.nextFirst - 1)];
        }
    }
    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println("");
        } else if (this.nextFirst < this.nextLast) {
            for (int i = this.nextFirst + 1; i < nextLast; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.print("\n");
        } else if (this.nextFirst == this.items.length - 1) {
            for (int i = 0; i < this.nextLast; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.print("\n");
        } else {
            for (int i = this.nextFirst + 1; i <= this.items.length - 1; i++) {
                System.out.print(this.items[i] + " ");
            }
            for (int i = 0; i < this.nextLast; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.print("\n");
        }
    }
    public T removeLast() {
        T result;
        if (this.isEmpty()) {
            result = null;
        } else {
            this.nextLastMinusOne();
            this.size--;
            result = this.items[this.nextLast];
            this.items[this.nextLast] = null;
        }

        if ((this.size * 4 <= this.items.length) && (this.items.length >= 16)) {
            this.resize(this.size * 2);
        }

        return result;
    }

    private void nextLastMinusOne() {
        if (this.nextLast == 0) {
            this.nextLast = this.items.length - 1;
        } else {
            this.nextLast--;
        }
    }
    public T removeFirst() {
        T result;
        if (this.isEmpty()) {
            result = null;
        } else {
            this.nextFirstAddOne();
            result = this.items[this.nextFirst];
            this.size--;
        }
        if ((this.size * 4 <= this.items.length) && (this.items.length >= 16)) {
            this.resize(this.size * 2);
        }
        return result;
    }
    private void nextFirstAddOne() { if (this.nextFirst == this.items.length - 1) { this.nextFirst = 0;
        } else {
            this.nextFirst++;
        }
    }
    public int size() {
        return this.size;
    }

//  /*  public static void main(String[] args) {
//        *//*
//        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
//        deque1.addFirst(4);
//        deque1.addFirst(3);
//        deque1.addFirst(2);
//        deque1.addFirst(1);
//        deque1.addFirst(0);
//        deque1.addFirst(5);
//        deque1.addFirst(6);
//        deque1.addFirst(7);
//        deque1.addFirst(10 );
//        System.out.println("------get()------");
//        System.out.println(deque1.get(0));
//        System.out.println(deque1.get(1));
//        System.out.println(deque1.get(2));
//        System.out.println(deque1.get(3));
//        System.out.println(deque1.get(4));
//        System.out.println(deque1.get(5));
//        System.out.println(deque1.get(6));
//        System.out.println(deque1.get(7));
//        System.out.println(deque1.get(8));
//        System.out.println(deque1.get(9));
//        *//*
//        *//*
//        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
//        deque2.addLast(0);
//        deque2.addLast(1);
//        deque2.addLast(2);
//        deque2.addLast(3);
//        deque2.addLast(4);
//        deque2.addFirst(5);
//        deque2.addFirst(6);
//        deque2.addFirst(7);
//        deque2.addFirst(8);
//        deque2.addFirst(9);
//        System.out.println(deque2.get(0));
//        System.out.println(deque2.get(1));
//        System.out.println(deque2.get(2));
//        System.out.println(deque2.get(3));
//        System.out.println(deque2.get(4));
//        System.out.println(deque2.get(5));
//        System.out.println(deque2.get(6));
//        System.out.println(deque2.get(7));
//        System.out.println(deque2.get(8));
//        System.out.println(deque2.get(9));
//        System.out.println(deque2.get(10));
//        *//*
//        *//*
//        ArrayDeque<Integer> deque3 = new ArrayDeque<>();
//        System.out.println(deque3.isEmpty());
//        deque3.addLast(10);
//        System.out.println(deque3.isEmpty());
//        *//*
//
//        *//*
//        ArrayDeque<Integer> deque4 = new ArrayDeque<>();
//        deque4.addLast(0);
//        deque4.addLast(1);
//        deque4.addLast(2);
//        deque4.addLast(3);
//        deque4.addLast(4);
//        deque4.addFirst(5);
//        deque4.addFirst(6);
//        deque4.addFirst(7);
//        deque4.addFirst(8);
//        deque4.printDeque();
//        *//*
//
//
//        ArrayDeque<Integer> deque5 = new ArrayDeque<>();
//        deque5.addFirst(10);
//        deque5.printDeque();
//        deque5.removeLast();
//        System.out.println(deque5.isEmpty());
//    }*/

//    public static void main(String[] args) {
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst(0);
//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.removeFirst();
//        deque.printDeque();
//    }
//    public static void main(String[] args) {
//
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        deque.addLast(0);
//        deque.get(0);
//        deque.printDeque();
//        deque.removeLast();
//        deque.addLast(3);
//        deque.addLast(4);
//        deque.addLast(5);
//        deque.printDeque();
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.printDeque();
//        deque.addFirst(8);
//        deque.addLast(9);
//        deque.printDeque();
//        System.out.println(deque.get(0));
//        deque.removeLast();
//        deque.printDeque();
//        deque.removeFirst();
//        deque.printDeque();
//        deque.addFirst(13);
//        deque.printDeque();
//        deque.addFirst(14);
//        deque.printDeque();
//        deque.removeFirst();
//        deque.printDeque();
//        System.out.println(deque.get(0));
//        deque.removeLast();
//        deque.printDeque();
//    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        deque.printDeque();
        deque.get(0);
        deque.get(0);
        deque.removeFirst();
        deque.printDeque();
        deque.addLast(4);
        deque.printDeque();
        deque.removeLast();
        deque.printDeque();
        deque.addFirst(6);
        deque.printDeque();
        deque.get(0);
        deque.addLast(8);
        deque.printDeque();
        deque.addFirst(9);
        deque.printDeque();
        deque.addFirst(10);
        deque.printDeque();
        deque.addLast(11);
        deque.printDeque();
        deque.removeLast();
        deque.printDeque();
        deque.addFirst(13);
        deque.printDeque();
        deque.addLast(14);
        deque.printDeque();
        deque.get(2);
        deque.addFirst(16);
        deque.printDeque();
        System.out.println(deque.get(3));
        deque.addLast(18);
        deque.printDeque();
        deque.removeFirst();
    }

}
