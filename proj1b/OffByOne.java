public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
            return (Math.abs(x - y) == 1);
        } else {
            return false;
        }
    }

}
