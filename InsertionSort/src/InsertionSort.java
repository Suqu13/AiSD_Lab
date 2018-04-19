import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    private ArrayList<Integer> list;

    public InsertionSort(String fileName) {
        list = new ArrayList<Integer>();
        String tab[];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while ((line = reader.readLine()) != null) {
                tab = line.split(",");
                for (int i = 0; i < tab.length; i++) {
                    list.add(Integer.parseInt(tab[i]));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertionSort() {
        int start = 0;
        while (start < list.size() - 1) {
            int i = start;
            int j = start + 1;
            while (i >= 0) {
                if (list.get(i) > list.get(j))
                    Collections.swap(list, j, i);
                j--;
                i--;
            }
            start++;
        }
    }

    public void show() {
        for (Integer i : list) {
            System.out.print(" " + i + " ");
        }
        System.out.println("\n");
    }


}
