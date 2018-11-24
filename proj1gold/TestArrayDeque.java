import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDeque {
    ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
    StudentArrayDeque<Integer> studentVersion = new StudentArrayDeque<>();

    @Test
    public void test() {
        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                solution.addFirst(i);
                studentVersion.addFirst(i);
                assertEquals("AddFirst Error\n RandomNumber:" + " " + i,
                        solution.get(0), studentVersion.get(0));
            } else if (numberBetweenZeroAndOne < 0.5) {
                solution.addLast(i);
                studentVersion.addLast(i);
                assertEquals("AddLast Error\n RandomNumber:" + " " + i,
                        solution.get(solution.size()-1), studentVersion.get(studentVersion.size()-1));
            } else if ((solution.size() == 0 || studentVersion.size() == 0)
                    && numberBetweenZeroAndOne < 0.75) {
                solution.addFirst(i);
                studentVersion.addFirst(i);
                assertEquals("AddFirst Error\n RandomNumber:" + " " + i,
                        solution.get(0), studentVersion.get(0));
            } else if ((solution.size() == 0 || studentVersion.size() == 0)
                    && numberBetweenZeroAndOne < 1) {
                solution.addLast(i);
                studentVersion.addLast(i);
                assertEquals("AddLast Error\n RandomNumber:" + " " + i,
                        solution.get(solution.size()-1), studentVersion.get(studentVersion.size()-1));
            } else if (numberBetweenZeroAndOne < 0.75) {
                assertEquals("removeFirst Error:\n RandomNumber:" + " " + i,
                        solution.removeFirst(), studentVersion.removeFirst());
                solution.removeFirst();
                studentVersion.removeFirst();
            } else {
                solution.removeLast();
                studentVersion.removeLast();
            }
        }
    }

}
