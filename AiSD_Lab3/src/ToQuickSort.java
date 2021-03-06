
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
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
            reader.close();
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


    /*metoda znajdująca mediane na posdstawie trzech elementów, zwraca jej indeks
    działa na zasaidzie porównań*/

    private int medianOfThreeElements(int left, int right) {

        int middle = (int) Math.floor((left + (right - left)) / 2);
        int median = right;

        if (elements.get(left) <= elements.get(right) && elements.get(middle) <= elements.get(right)) {
            if (elements.get(left) <= elements.get(middle)) {
                median = middle;
            } else {
                median = left;
            }
        } else if (elements.get(left) <= elements.get(middle) && elements.get(right) <= elements.get(median)) {
            if (elements.get(left) <= elements.get(right)) {
                median = right;
            } else {
                median = left;
            }
        } else {
            if (elements.get(middle) <= elements.get(right)) {
                median = right;
            } else {
                median = middle;
            }
        }

        return median;

    }

    /*metoda pozwapająca na określenie pivota w wybrany przez nas sposób*/

    private void selectPivot(int left, int right, int version) {
        int futurePivotIndex = 0;
        switch (version) {
            case 1:
                futurePivotIndex = right;
                break;

            case 2:
                futurePivotIndex = right;
                int index = ThreadLocalRandom.current().nextInt(left, right + 1);
                if (index > left && index < right) futurePivotIndex = index;
                break;

            case 3:
                futurePivotIndex = medianOfThreeElements(left, right);
                break;
        }
        Collections.swap(elements, futurePivotIndex, right);
    }

    /*metoda partycjonująca, która dodatkowo inkrementuje nam zmeinną odpowiadającą
    za zliczanie zamian miejscami, w chwili gdy to następuje*/

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

    /*metoda główna dla algorytmu, to tu następuje praca na stosie i
    określanie jego największej wysokości*/

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

            /*"continue" pilnuje sytuacji, gdy pivot jest porównywany z
             samym sobą, wtedy nie wykonuje pętli dla tej iteracji*/

            if (right <= left) continue;

            border = partition(left, right, version);


            /*Optymalizacja, węższy przedział rozpatrywany pierwszy */

            if (Math.abs((border - 1) - left) >= Math.abs(right - (border + 1))) {

                stack.push(border - 1);
                stack.push(left);

                stack.push(right);
                stack.push(border + 1);
                maximumStackHeight = stack.maximumStackHeight();

            } else {

                stack.push(right);
                stack.push(border + 1);

                stack.push(border - 1);
                stack.push(left);
                maximumStackHeight = stack.maximumStackHeight();

            }
        }
    }

    /*metoda służoca do wydruku sposobu w jaki pivot był wybierany*/

    public String showTheSelectedVersion() {
        if (version == 1) return "P1";
        if (version == 2) return "P2";
        if (version == 3) return "P3";
        return null;
    }

}
