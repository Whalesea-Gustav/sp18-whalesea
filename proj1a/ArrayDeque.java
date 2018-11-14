public class ArrayDeque<T> {
    public int size;
    public T[] items;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque() {
        this.size = 0;
        this.nextFirst = 7;
        this.nextLast = 0;
        this.items = (T []) new Object[8];
    }

    public void addFirst(T i) {
        this.size++;
        if (this.nextFirst == this.nextLast) {
            //resize
            this.resize(2*this.items.length);
        }
        this.items[this.nextFirst] = i;
        this.nextFirst--;
    }

    public void addLast(T i) {
        this.size++;
        if (this.nextLast == this.nextFirst) {
            this.resize(2*this.items.length);
        }
        this.items[this.nextLast] = i;
        this.nextLast++;
    }

    public boolean isEmpty() {
        if ((this.nextFirst == this.items.length-1) && this.nextLast == 0){
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {

        for (int start=this.nextFirst+1;start<this.items.length;start++) {
            System.out.print(this.items[start]+" ");
        }

        for (int start=0; start<this.nextLast;start++) {
            System.out.print(this.items[start] + " ");
        }
        System.out.print("\n");
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        this.size = capacity;
        int dif = capacity - this.items.length;
        //  +++++++ nextLast/nextFirst + +  +  +  +  +
        //  0123456         7          8 9 10 11 12 13
        System.arraycopy(this.items, 0, temp, 0, nextFirst);
        System.arraycopy(this.items, this.nextLast+1, temp,
                nextLast+1+dif, this.items.length-1-this.nextFirst);
        this.items = temp;
        this.nextFirst += dif;

    }

    public T removeLast() {
        this.size--;
        if (this.size * 4 < this.items.length) {
            this.resize(this.size*2);
        }
        this.nextLast--;
        T result = this.items[this.nextLast];
        this.items[this.nextLast] = null;
        return result;
    }

    public T removeFirst() {
        this.size--;
        if (this.size * 4 < this.items.length) {
            this.resize(this.size*2);
        }
        this.nextFirst++;
        T result = this.items[this.nextFirst];
        this.items[this.nextFirst] = null;
        return result;
    }

    public T get(int index) {
        if (index > this.size-1) {
            return null;
        }

        if (index <= (this.items.length-1-this.nextFirst-1)) {
            return this.items[this.nextFirst+index+1];
        } else {
            return this.items[index - this.items.length + 1 + this.nextFirst];
        }
    }

    public int size() {
        return this.size;
    }

    /*
    public static void main(String [] args) {
        ArrayDequeV2<Integer> deque1 = new ArrayDequeV2<>();
        deque1.addFirst(10);
        deque1.addFirst(20);
        deque1.addFirst(30);
        deque1.addFirst(40);
        deque1.addFirst(50);
        System.out.println("-----get(0)-----");
        System.out.println(deque1.get(0));

        System.out.println("-----get(n)-----");
        System.out.println(deque1.get(1));
        System.out.println(deque1.get(2));
        System.out.println(deque1.get(3));
        System.out.println(deque1.get(4));
        System.out.println(deque1.get(5));
        deque1.printDeque();


        System.out.println("-----get(x)-----");
        deque1.addLast(0);
        System.out.println(deque1.get(5));
        deque1.addLast(-10);
        System.out.println(deque1.get(6));
        System.out.println(deque1.get(7));
        System.out.println(deque1.size());

        System.out.println("-----exceed and resize-----");
        deque1.addFirst(60);
        System.out.println(deque1.get(0));
        deque1.addLast(-20);
        deque1.addLast(-30);

        deque1.printDeque();

        System.out.println("-----removeLast()-----");
        deque1.removeLast();
        deque1.printDeque();

        System.out.println("-----removeFirst()-----");
        deque1.removeFirst();
        deque1.printDeque();
        System.out.println(deque1.get(7));


   }
   */
}
