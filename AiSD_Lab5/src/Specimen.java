import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Specimen {
    private List<Integer> cabinets;
    private int[][] matrixOfConnections;

    public List<Integer> getCabinets() {
        return cabinets;
    }

    public int[][] getMatrixOfConnections() {
        return matrixOfConnections;
    }

    public Specimen (int[][] matrixOfConnections) {
        this.matrixOfConnections = matrixOfConnections;
        cabinets = new ArrayList<>();
    }

    /*
    Metoda kupiująca okaz i zwracająca kopie
     */
    private Specimen copySpecimen() {
        Specimen copy = new Specimen(getMatrixOfConnections());
        for (Integer cabinet : getCabinets()) {
            copy.getCabinets().add(cabinet);
        }
        return copy;
    }

    /*
    Metoda generująca osobnika z losowymi cechami
     */
    public void generateRandomSpecimen() {
        while (getCabinets().size() < matrixOfConnections.length) {
            Random random = new Random();
            int newCabinet = random.nextInt(matrixOfConnections.length);
            if (!getCabinets().contains(newCabinet)) {
                getCabinets().add(newCabinet);
            }
        }
    }

    /*
    Metoda licząca funkcje celu na podstawie macierzy powiązań
     */
    public int goalFunction() {
        int value = 0;
        int index_i;
        int index_j;
        for (int i = 0; i < cabinets.size() - 1; i++) {
            index_i = cabinets.get(i);
            for (int j = i + 1; j < cabinets.size(); j++) {
                index_j = cabinets.get(j);
                if (index_i != index_j) {
                    value += (Math.abs(i - j) * matrixOfConnections[index_i][index_j]);
                }
            }
        }
        return value;
    }

    /*
    Metoda mutująca i zwracająca osobnika, zamienia dwie dowolne szafy miejscami
     */
    public Specimen mutate() {
        int value = (matrixOfConnections.length - 1);
        int i = (int) (Math.random() * value);
        int j = i;

        while (i == j) {
            j = (int) (Math.random() * value);
        }

        Specimen mutantSpecime = copySpecimen();

        Collections.swap(cabinets, i, j);
        if (goalFunction() >= mutantSpecime.goalFunction()) {
            return mutantSpecime;
        } else {
            return this;
        }
    }
}
