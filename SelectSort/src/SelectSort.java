import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    private ArrayList<Integer> list;

    public SelectSort(String fileName) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int findTheSmallert(int start, int end) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            if (list.get(start) < min) {
                index = start;
                min = list.get(start);
            }
            start ++;
        }
        return index;
    }

    public void SelectSort(){
        int start = 0;
        int end = list.size();
        while (start < list.size()){
            Collections.swap(list, start, findTheSmallert(start, end));
            start++;
        }
    }

    public void show(){
        for (Integer i: list){
            System.out.print(" " + i + " " );
        }
        System.out.println("\n");
    }
}
