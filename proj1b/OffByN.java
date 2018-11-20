public class OffByN implements CharacterComparator{
    private int setDiff = 0;
    public OffByN(int n) {
       setDiff = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == setDiff);
    }

}
