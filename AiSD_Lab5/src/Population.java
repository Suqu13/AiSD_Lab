import java.util.*;

public class Population {
    private List<Specimen> randomPopulation;
    private int[][] matrixOfConnections;


    public Population(int[][] matrixOfConnections) {
        this.matrixOfConnections = matrixOfConnections;
        randomPopulation = new ArrayList<>();
    }

    /*
    Metoda generująca losową populacje osobników, wrzuca je do listy, następnie sortuje
     */
    private void generateRandomPopulation(int numberOfSpecimens) {
        int i = randomPopulation.size();

        while (i < numberOfSpecimens) {
            Specimen specimen = new Specimen(matrixOfConnections);
            specimen.generateRandomSpecimen();
            randomPopulation.add(specimen);
            i++;
        }
        Collections.sort(randomPopulation, (o1, o2) -> o1.goalFunction() - o2.goalFunction());
    }

    /*
    Liczy średnią wartość funckji celu dla całej populacji
     */
    private int averageGoalFunctionValue() {
        int value = 0;
        Iterator<Specimen> iterator = randomPopulation.iterator();
        while (iterator.hasNext()) {
            value += iterator.next().goalFunction();
        }
        return (value / randomPopulation.size());
    }

    /*
    Generuje nową populacje na podstawie najleprzych osobników ze starej po odrzuceniu "ogona",
    kolejno generują się osobniki losowe tak aby osiągnąć pierwotną liczebność. Bezpośrednim
    wskaźnikiem liczby klonów jest podwojony stosunek funkcji celu osobnika do mediany dla całej populacji
    lub jej stosunek dla średniej wartości dla całej populacji. Ten parametr wybiera użytkownik
     */
    private ArrayList<Specimen> generateNewGenerationOfPopulation(double percent, char version) {
        ArrayList<Specimen> newPopulation = new ArrayList<>();
        int oldSize = randomPopulation.size();
        int averageGoalFunctionValue = averageGoalFunctionValue();
        int sizeWithoutTheWorst = (int) (oldSize - (oldSize * percent));

        Iterator<Specimen> iterator = randomPopulation.iterator();

        while (iterator.hasNext() && newPopulation.size() < sizeWithoutTheWorst) {

            Specimen specimen = iterator.next();
            int cloningFactor = countCloningFactor(version, specimen, averageGoalFunctionValue);

            while (cloningFactor > 0 && newPopulation.size() < sizeWithoutTheWorst) {
                newPopulation.add(specimen.mutate());
                cloningFactor--;
            }
        }
        return newPopulation;
    }

    /*
    Wyliczenie i wybranie wskaźnika klonowania
     */
    private int countCloningFactor(char version, Specimen specimen, int averageGoalFunctionValue) {
        int cloningFactor;
        switch (version) {
            default:
                cloningFactor = 2 * Math.round((averageGoalFunctionValue / specimen.goalFunction()));
                break;

            case ('m'):
                int value = randomPopulation.get(randomPopulation.size() / 2).goalFunction();
                cloningFactor = 2 * Math.round(value / specimen.goalFunction());
                break;
        }
        return cloningFactor;
    }

    /*
    Metoda przeprowadza pięciokrotne powstanie nowej populacji
     */
    public void runAlgorithm(double percent, int size, char version) {
        int i = 0;
        generateRandomPopulation(size);
        while (i < 10) {
            randomPopulation = generateNewGenerationOfPopulation(percent, version);
            generateRandomPopulation(size);
            i++;
        }
    }

    /*
    Wyświetlanie wyniku
     */
    public void results(int x, HashMap<Integer, Character> fileCabinets) {
        ArrayList<Character> routeBetweenCabinets = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (Integer cabinets : randomPopulation.get(i).getCabinets()) {
                routeBetweenCabinets.add(fileCabinets.get(cabinets));
            }
            System.out.println(Arrays.toString(routeBetweenCabinets.toArray()) + "  FC: " + randomPopulation.get(i).goalFunction());
            routeBetweenCabinets.clear();
        }
    }

    /*
    Wyświtlanie calej populacji
     */
    public void showPopulation() {
        System.out.println(" ");
        for (Specimen specimen : randomPopulation) {
            for (Integer i : specimen.getCabinets()) {
                System.out.print(" " + i);
            }
            System.out.println(" ");
        }
    }
}