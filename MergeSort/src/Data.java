import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {

    private ArrayList<Integer> elements;
    private String nameFile;

    public Data(String fileName) {
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

    public int[] reload() {
        int[] tab = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++){
            tab[i] = elements.get(i);
        }
        return tab;
    }
}
