
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ToQuickSort {

    private ArrayList<Integer> elements;
    private String nameFile;
    private int swapPlaces = 0;
    private int maximumStackHeight = 0;
    private int version = 0;

    public int getMaximumStackHeight() {
        return maximumStackHeight;
    }

    public String getNameFile() {
        return nameFile;
    }

    public int size() {
        return elements.size();
    }

    public int getSwapPlaces() {
        return swapPlaces;
    }

    public ToQuickSort(String fileName) {
        this.nameFile = fileName;
        elements = new ArrayList<Integer>();
        String tab[];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while ((line = reader.readLine()) != null) {
                tab = line.split(",");
                for (int i = 0; i < tab.length; i++) {
                    elements.add(Integer.parseInt(tab[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        for (Integer i : elements) {
            System.out.print(" " + i + " ");
        }
        System.out.println(" ");
    }

    public int medianOfThreeElements(int left, int right) {

        HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();

        newList.add(elements.get(left));
        newList.add(elements.get((int) Math.floor((left + (right - left)) / 2)));
        newList.add(elements.get(right));

        newMap.put(elements.get(left), left);
        newMap.put(elements.get((int) Math.floor((left + (right - left)) / 2)), (int) Math.floor((left + (right - left)) / 2));
        newMap.put(elements.get(right), right);

        boolean t = true;
        while (t) {
            t = false;
            for (int i = 0; i < newList.size() - 1; i++) {
                if (newList.get(i) > newList.get(i + 1)) {
                    Collections.swap(newList, i, i + 1);
                    t = true;
                }
            }
        }


        return newMap.get(newList.get(1));
    }

    private void selectPivot(int left, int right, int version) {
        int futurePivotIndex = 0;
        switch (version) {
            case 1:
                futurePivotIndex = right;
                break;

            case 2:
                futurePivotIndex = right;
                int index = ThreadLocalRandom.current().nextInt(left, right);
                if (index > left && index < right) futurePivotIndex = index;
                break;

            case 3:
                futurePivotIndex = medianOfThreeElements(left, right);
                break;
        }

        Collections.swap(elements, futurePivotIndex, right);
    }

    private int partition(int left, int right, int version) {

        selectPivot(left, right, version);
        int pivot = elements.get(right);
        int border = left - 1;
        int i = left;
        while (i < right) {

            if (elements.get(i) < pivot) {
                border++;
                if (border != i) {
                    Collections.swap(elements, border, i);
                    swapPlaces++;
                }
            }
            i++;
        }
        border++;
        if (border != right) {
            Collections.swap(elements, border, right);
            swapPlaces++;
        }
        return border;
    }


    public void quickSort(int version) throws EmptyStackException {

        MyStack<Integer> stack = new MyStack<Integer>();
        this.version = version;
        int border;
        int left = 0;
        int right = elements.size() - 1;

        stack.push(right);
        stack.push(left);
        maximumStackHeight = stack.maximumStackHeight();

        while (!stack.isEmpty()) {
            left = stack.pop();
            right = stack.pop();

            /*
            "continue" pilnuje sytuacji, gdy pivot jest porównywany z
            samym sobą, wtedy nie wykonuje pętli dla tej iteracji
             */

            if (right <= left) continue;

            border = partition(left, right, version);

            stack.push(border - 1);
            stack.push(left);

            stack.push(right);
            stack.push(border + 1);
            maximumStackHeight = stack.maximumStackHeight();

        }
    }

    public void showTheSelectedVersion(){
        if (version == 1) System.out.println("Pivot został wybrany jako ostatni element z zadanego przedziału.");
        if (version == 2) System.out.println("Pivot został wybrany losowo z zadanego przedziału.");
        if (version == 3) System.out.println("Pivot został wybrany jako mediana trzech elementów należących do zadanego przedziału (pierwszy, środkowy, ostatni).");
    }

    public double showMediana() {
        int n = elements.size() - 1;
        if (elements.size() % 2 == 0) {
            int m = (int) Math.floor(n / 2);
            double b = ((elements.get(m) + elements.get(m + 1)));
            return (b / 2);
        } else {
            return elements.get(n / 2);
        }
    }

}
