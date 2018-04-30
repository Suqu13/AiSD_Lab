import java.util.Collections;
import java.util.List;

public class BinarySearch {


    public static void search(int x, List<Integer> list) {
        Collections.sort(list);
        System.out.printf("%10s %-5d %-10s %-5s \n", "Szukana wartosć: ", x, "Znaleziono? : ", binarySearch(x, list, 0, list.size() - 1));
    }

    public static boolean binarySearch(int x, List<Integer> list, int left, int right) {
        if (left > right) {
            return false;
        }

        int middle = (left + right) / 2;

        if (list.get(middle) == x) {
            return true;
        } else if (list.get(middle) > x) {
            return binarySearch(x, list, left, middle - 1);
        } else {
            return binarySearch(x, list, middle + 1, right);
        }
    }
}
