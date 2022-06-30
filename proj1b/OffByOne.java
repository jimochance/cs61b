public class OffByOne implements CharacterComparator{
    // If the difference of the integer version of two characters is one, then the equalChars method should
    // return us true
    // int diff = char1 - char2
    // consider diff might should be an absoluate value

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == 1 || diff == -1) {
            return true;
        }
        return false;
    }
}
