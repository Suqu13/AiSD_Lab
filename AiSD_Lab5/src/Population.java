import java.util.*;

public class Population {
    private List<ArrayList<Integer>> randomPopulation;
    private int[][] matrixOfConnections;


    public Population(int[][] matrixOfConnections) {
        this.matrixOfConnections = matrixOfConnections;
        randomPopulation = new ArrayList<>();
    }


    private void generateRandomPopulation(int numberOfSpecimens) {
        int i = randomPopulation.size();
        ArrayList<Integer> specimen;

        while (i < numberOfSpecimens) {

            specimen = new ArrayList<>();
            while (specimen.size() < matrixOfConnections.length) {
                Random random = new Random();
                int newCabinet = random.nextInt(matrixOfConnections.length);
                if (!specimen.contains(newCabinet)) {
                    specimen.add(newCabinet);
                }
            }
            randomPopulation.add(specimen);
            i++;
        }
        Collections.sort(randomPopulation, (o1, o2) -> goalFunction(o1) - goalFunction(o2));
    }


    private int goalFunction(ArrayList<Integer> specimen) {
        int value = 0;
        int index_i;
        int index_j;

        for (int i = 0; i < specimen.size() - 1; i++) {
            index_i = specimen.get(i);
            for (int j = i + 1; j < specimen.size(); j++) {
                index_j = specimen.get(j);
                if (index_i != index_j) {
                    value += (Math.abs(i - j) * matrixOfConnections[index_i][index_j]);
                }
            }
        }
        return value;
    }


    private int averageGoalFunctionValue() {
        int value = 0;
        for (ArrayList<Integer> specimen : randomPopulation) {
            value += goalFunction(specimen);
        }
        return (value / randomPopulation.size());
    }


    private ArrayList<ArrayList<Integer>> generateNewGenerationOfPopulation(double percent) {
        ArrayList<ArrayList<Integer>> newPopulation = new ArrayList<>();
        int oldSize = randomPopulation.size();
        int averageGoalFunctionValue = averageGoalFunctionValue();
        int sizeWithoutTheWorst = (int) (oldSize - (oldSize * percent));

        Iterator<ArrayList<Integer>> iterator = randomPopulation.iterator();

        while (iterator.hasNext() && newPopulation.size() < sizeWithoutTheWorst) {

            ArrayList<Integer> specimen = iterator.next();
            int cloningFactor = Math.round(2 * (averageGoalFunctionValue / goalFunction(specimen)));

            while (cloningFactor > 0 && newPopulation.size() < sizeWithoutTheWorst ){
                newPopulation.add(mutate(specimen));
                cloningFactor--;
            }
        }
        return newPopulation;
    }


    private ArrayList<Integer> mutate(ArrayList<Integer> specimen) {
        int value = (matrixOfConnections.length - 1);
        int i = (int) (Math.random() * value);
        int j = i;
        ArrayList<Integer> mutantSpecime = new ArrayList<>();
        while (i == j) {
            j = (int) (Math.random() * value);
        }
        for (int k = 0; k < specimen.size(); k++) {
            mutantSpecime.add(specimen.get(k));
        }
        Collections.swap(mutantSpecime, i, j);
        if (goalFunction(specimen) >= goalFunction(mutantSpecime)) {
            return mutantSpecime;
        } else {
            return specimen;
        }
    }


    public void runAlgorithm(double percent, int size) {
        int i = 0;
        generateRandomPopulation(size);
        while (i < 5) {
            randomPopulation = generateNewGenerationOfPopulation(percent);
            generateRandomPopulation(size);
            i++;
        }
    }


    public void results(int x, HashMap<Integer, Character> fileCabinets) {
        ArrayList<Character> routeBetweenCabinets = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (Integer room : randomPopulation.get(i)) {
                routeBetweenCabinets.add(fileCabinets.get(room));
            }
            System.out.println(Arrays.toString(routeBetweenCabinets.toArray()) + "  FC: " + goalFunction(randomPopulation.get(i)));
            routeBetweenCabinets.clear();
        }
    }
}