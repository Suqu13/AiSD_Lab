import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TESTER {
    private List<Integer> elements;

    public TESTER(String fileName) {
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

    public List<Integer> getElements() {
        return elements;
    }

    public static void main(String[] args) {
        TESTER tester_0 = new TESTER("dane_0.csv");
        TESTER tester_1 = new TESTER("dane_1.csv");


        BinarySearch.search(58, tester_0.getElements());
        BinarySearch.search(209, tester_1.getElements());

    }
}
