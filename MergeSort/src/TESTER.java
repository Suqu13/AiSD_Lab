import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TESTER {

    public static void main(String[] args) {
        Data data = new Data("daneTestowe.csv");

        int[] tab = data.reload();


        MergeSort.sort(tab);

        for (int i : tab) {
            System.out.println(i);
        }
    }
}
