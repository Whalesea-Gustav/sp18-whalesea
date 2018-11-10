public class IntList {
	public int first;
	public IntList rest;

	public IntList(int first, IntList rest) {
		this.first = first;
		this.rest = rest;
	}

	public int size() {
		if (this.rest == null) {
			return 1;
		} else {
			return 1 + rest.size();
		}
	}
	public int iterableSize() {
		IntList thisRest = this.rest;
		int counter = 1;
		while (thisRest != null) {
			counter++;
			thisRest = thisRest.rest; 
		}

		return counter;
	}

	public int get(int position) {
		if (position == 0) {
			return this.first;
		} else {
			return this.rest.get(position - 1);
		}
	}

	public static IntList incrList(IntList L, int x) {
		if (L == null) {
			return null;
		} else {
		return new IntList((L.first+x), IntList.incrList(L.rest, x));
		}
	}

	public static IntList dincrList(IntList L, int x) {
		if (L == null) {
			return null;
		} else {
			L.first = L.first - x;
			IntList.dincrList(L.rest, x);
		}
		return L;
	}
	public static void main(String[] args) {
		IntList iL1 = new IntList(10, null);
		IntList iL2 = new IntList(15, iL1);

		System.out.println(iL1.size());
		System.out.println(iL2.size());
		System.out.println(iL2.iterableSize());
		System.out.println(iL2.get(1));
		IntList iL3 = IntList.incrList(iL2, 10);
		System.out.println(iL3.get(1));
		System.out.println(IntList.dincrList(iL3, 2).get(1));
		System.out.println(iL3.get(1));
	}
}