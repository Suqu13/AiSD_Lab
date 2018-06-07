import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.HashMap;

public class Data {
    private HashMap<Integer, Character> namesOfCabinets;
    private int[][] matrixOfConnections;

    public Data() {
        namesOfCabinets = new HashMap<>();
    }


    /*
    Metoda odpowiedzialna za wczytanie pliku z danymi
     */
    public void loadData(String fileName) {
        String line;
        String tab[];
        int j = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((line = bufferedReader.readLine()) != null) {

                tab = line.split(",");

                if (matrixOfConnections == null) {
                    matrixOfConnections = new int[tab.length][tab.length];
                }
                for (int i = 0; i < tab.length; i++) {
                    if (!(tab[i].contains("X") || tab[i].contains("x"))) {
                        matrixOfConnections[i][j] = Integer.parseInt(tab[i]);
                    }
                }
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    generowanie powiązania integer - character dla szuflad
     */
    private void generateNameOfCabinet() {
        char nameOfCabinet = 'a';
        for (int i = 0; i < matrixOfConnections.length; i++) {
            namesOfCabinets.put(i, nameOfCabinet);
            nameOfCabinet++;
        }
    }

    public HashMap<Integer, Character> getNamesOfCabinets() {
        generateNameOfCabinet();
        return namesOfCabinets;
    }

    public int[][] getMatrixOfConnections() {
        return matrixOfConnections;
    }
}
