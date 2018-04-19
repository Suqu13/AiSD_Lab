import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class BucketSort {

    ArrayList<Double> list;

    public BucketSort(String fileName) {
        list = new ArrayList<Double>();
        String tab[];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while ((line = reader.readLine()) != null) {
                tab = line.split(",");
                for (int i = 0; i < tab.length; i++) {
                    list.add(Double.parseDouble(tab[i]));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toBucketSort() {


        double newSize = maxValue() - minValue();
        double bound = newSize / list.size();


        ArrayList<ArrayList> newList = new ArrayList<>();
        int n = 0;
        double newBound = minValue();

        while (newBound <= maxValue()) {
            newList.add(new ArrayList<Integer>());
            for (double l : list) {
                if (newBound <= l && l < newBound + bound) {
                    newList.get(n).add(l);
                }
            }
            newBound += bound;
            n++;
        }

        list.clear();

        for (int i = 0; i < newList.size(); i++) {
            for (int j = 0; j < newList.get(i).size(); j++) {
                Collections.sort(newList.get(i));
                double k = (double) newList.get(i).get(j);
                list.add(k);
            }
        }

        for (double d : list) {
            System.out.println(d);
        }

    }

    private double minValue() {
        double min = Double.MAX_VALUE;
        for (double l : list) {
            if (l < min) {
                min = l;
            }
        }
        return min;
    }

    private double maxValue() {
        double max = Double.MIN_VALUE;
        for (double l : list) {
            if (l > max) {
                max = l;
            }
        }
        return max;
    }
}
