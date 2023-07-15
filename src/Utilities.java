import java.util.ArrayList;

public class Utilities {
    public static <T> ArrayList<T> deepCopy(ArrayList<T> list) {

        ArrayList<T> copy = new ArrayList<>();
        for (T item : list) {
            if (item instanceof ArrayList) {
                ArrayList<?> nestedList = (ArrayList<?>) item;
                copy.add((T) deepCopy(nestedList));
            } else {
                copy.add(item);
            }
        }
        return copy;
    }

}
