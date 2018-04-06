import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ToQuickSort {

    private ArrayList<Integer> elements;

    //konstruktor wczytuje dane z pliku do listy
    public ToQuickSort(String nameOfTheFile) {
        elements = new ArrayList<Integer>();
        String tab[];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfTheFile)));
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

    //TODO OGARNIJ ODPOWIEDNIE WARTOŚĆI
    public int partition(ArrayList<Integer> list, int left, int right) {

        int border = left - 1;
        int pivot = right;
        int index = left;

        while (index < pivot) {
            if (elements.get(index) < pivot) {
                border++;
                {
                    if (index != border) {
                        Collections.swap(elements, border, index);
                    }
                }
                index++;
            }
        }
        border++;
        if (border != pivot) {
            Collections.swap(elements, border, pivot);
        }
        return border;
    }


    public void QuickSort() {
        MyStack stack = new MyStack();

        int pivot;
        int right = this.elements.size() - 1;
        int left = 0;

        stack.push(-5, -10);
        while (!stack.isEmpty()) {
            try {
                while ((int) stack.pop() > (int) stack.pop()) {

                }
            } catch (EmptyStackException e) {
                e.printStackTrace();
            }

        }

    }
}
