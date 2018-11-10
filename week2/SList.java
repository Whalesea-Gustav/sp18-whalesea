public class SList {

  /* Declaring a nested class as static means
     that methods inside the static class can not 
     access any of the members of the enclosing class.*/

  private static class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n) {
      item = i;
      next = n;
    }
  }

  /* instead of using first, we set the empty SList to a sentinul node */
  private IntNode sentinel;
  /* directly caching the size of SList, so size can be assessed in O(1) expand */
  public int size = 0;

  /* One class can have mutiple Constructor */
  public SList() {
    sentinel = new IntNode(0, null);
    size = 0;
  }

  public SList(int x) {
    sentinel = new IntNode(0, null);
    sentinel.next = new IntNode(x, null);
    size += 1;
  }

  public void addFirst(int x) {
    this.sentinel.next = new IntNode(x, this.sentinel.next);
    size += 1;
  } 

  public int getFirst() {
    return this.sentinel.next.item;
  }

  public void addLast(int x) {
   
   IntNode p = this.sentinel.next;

   while (p.next != null) {
    p = p.next;
   } 

   p.next = new IntNode(x, null);

   size += 1;
  }

  public int getLast() {
    IntNode p = this.sentinel.next;
    while (p.next != null) {
      p = p.next;
    }
    return p.item;
  }

  /* SList并不是recursive data structure, 而是包装了一个IntNode, 并不能直接在方法中通过递归解决
     遍历的问题, 需要用到辅助方法Aux*/
  private void addLastRAux(IntNode p, int x) {
    if (p.next == null) {
      p.next = new IntNode(x, null);
    } else {
      addLastRAux(p.next, x);
    }

    size += 1;
  }

  public void addLastRec(int x) {
    addLastRAux(this.sentinel.next, x);

    size += 1;
  }


  private int sizeAux(IntNode p) {
    if (p.next == null) {
      return 1;
    } else {
      return 1 + sizeAux(p.next);
    }
  }

  public int size() {
    return sizeAux(this.sentinel.next);
  }

  public int sizeIter() {
    IntNode p = this.sentinel.next;
    int counter = 1;

    while (p.next != null) {
      counter++;
      p = p.next;
    }

    return counter;
  }

  public static void main(String[] args) {
    SList slist1 = new SList(10);
    slist1.addLastRec(10);
    slist1.addLastRec(20);
    slist1.addFirst(5);
    System.out.println(slist1.getFirst());
    System.out.println(slist1.getLast());
    System.out.println(slist1.size());
    System.out.println(slist1.sizeIter());

  }
}
       