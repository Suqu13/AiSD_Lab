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

    private void generateNameOfCabinet() {
        char nameOfRoom = 'a';
        for (int i = 0; i <= matrixOfConnections.length - 1; i++) {
            namesOfCabinets.put(i, nameOfRoom);
            nameOfRoom++;
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
