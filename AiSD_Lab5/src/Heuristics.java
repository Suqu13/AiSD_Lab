import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Heuristics {
    private HashMap<Integer, Character> rooms;
    private int[][] matrixOfRelationships;
    private List<ArrayList<Integer>> population = new ArrayList<>();
    private List<ArrayList<Integer>> newPopulation = new ArrayList<>();
    private int averageGoalFunctionValue;

    /*
    Konstruktor pobiera dane z pliku przetwarzając je na tablicę dwuwymiarową zmiennych typu integer, jest
    to nasza macierz powiązań, w której element 0 oznacza brak powiązń. Pierwszy wiersz i pierwsza kolumna
    zawierają zmienne oznaczające nasze pokoje np. 1- pokój 'a', 2- pokój 'b' itd. Reszta to informacje o
    częstotliwości poruszania.
     */
    public Heuristics(String fileName, int numberOfSpecimens) {

        String line;
        String tab[];
        int index_j = 1;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while ((line = bufferedReader.readLine()) != null) {

                tab = line.split(",");

                if (matrixOfRelationships == null) {
                    matrixOfRelationships = new int[tab.length + 1][tab.length + 1];
                    for (int i = 0; i < matrixOfRelationships.length; i++) {
                        matrixOfRelationships[i][0] = i;
                        matrixOfRelationships[0][i] = i;
                    }
                }
                for (int i = 0; i < tab.length; i++) {
                    if (!tab[i].contains("X")) {
                        matrixOfRelationships[i + 1][index_j] = Integer.parseInt(tab[i]);
                    }
                }
                index_j++;
            }
            generatePopulation(numberOfSpecimens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda generująca losową populację. Pobiera od użytkownika ilość osobników.
    Następnie generuje jej przedstawiciela na podstawie macierzy powiązań zawierającej
    nasz badany zbiór.
     */
    private void generatePopulation(int numberOfSpecimens) {
        int i = 0;
        while (i < numberOfSpecimens) {
            ArrayList<Integer> specimen = new ArrayList<>();
            while (specimen.size() < (matrixOfRelationships.length - 1)) {
                int newOne = (int) (Math.random() * (matrixOfRelationships.length - 1)) + 1;
                if (!specimen.contains(newOne)) {                                                                       //pilnuje aby nie powtarzały się te same pokoje
                    specimen.add(newOne);
                }
            }
            population.add(specimen);
            i++;
        }
    }

    /*
    Generuje hashmap w której key wartość numeryczna, a value watość typu char np. key 1 - value 'a'
     */
    private void generateNameOfRooms() {
        rooms = new HashMap<>();
        char nameOfRoom = 'a';
        for (int i = 1; i <= matrixOfRelationships.length - 1; i++) {
            rooms.put(i, nameOfRoom);
            nameOfRoom++;
        }
    }

    //TODO DOKŃCZ I W OGÓLE OGARNIJ
    /*
    Metoda licząca fukncję celu
     */
    private int goalFunction(ArrayList<Integer> specimen) {

        return 0;
    }

    /*
    Metoda licząca średnią wartość funkcji celu dla całej populacji
     */
    private void averageGoalFunctionValue() {
        int value = 0;
        for (ArrayList<Integer> specimen : population) {
            value += goalFunction(specimen);
        }
        averageGoalFunctionValue = value/ population.size();
    }

    /*
    Metoda sortująca populację, która ułatwi nam finalnie eliminacje najgorszych osobników.
    Całość ułożona jest od najlepszego do najgorszego
     */
    private void sort() {
        Collections.sort(population, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (goalFunction(o1) > goalFunction(o2)) {
                    return 1;
                } else if (goalFunction(o1) < goalFunction(o2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    /*
    Metod pozwalająca wygenerować nową populcaję zgodnie z liczebnością pierwotnej.
    Na początku uwzględniane są najlepsze osobniki. Gdy zakres wielkości się skończy,
    reszta zosatje dolosowana.
     */
    private void generateNewPopulation(double percent) {
        int sizeWithoutTheWorst = (int) (population.size() - (population.size() * percent));                            //określamy wielkość starej populacji bez najgorszych przypadków
        for (ArrayList<Integer> specimen : population) {                                                                //klonujemy okazy ze starej populacji do nowej zaczynając od tych najlepszych
            if (newPopulation.size() >= sizeWithoutTheWorst) {                                                          //jeśli wielkość nowej populacji przyjmie warość rozmiaru starej po modyfikacji to kończymy kopiowanie
                break;
            } else {
                clone(specimen, sizeWithoutTheWorst);
            }
        }

        population = newPopulation;                                                                                     //przypisujemy starej populacji tą nowo utworzoną
        generatePopulation(sizeWithoutTheWorst);                                                                        //uzupełniamy populacje do pierwotnej liczebności okazami wygenerowanymi losowo
    }

    /*
    Motedo pozwalanie na kopiowanie do nowej populacji, zawiera również mutacje.
    Klonowanie zosatje zaprzestane jeśli uzyskamy rozmiar starej populacji bez
    najgorszych przypadków.
     */
    private void clone(ArrayList<Integer> specimen, int sizeWithoutTheWorst) {
        int cloningFactor = (int) Math.round(averageGoalFunctionValue / goalFunction(specimen));                        //określenie wskaźnika mutacji, który determinuje ilość klonów danego okazu
        while (cloningFactor > 0) {
            if (newPopulation.size() >= sizeWithoutTheWorst) {                                                          //jeśli wielkość nowej populacji przyjmie warość starej uwzględniając brak najgorszych przypadków to kończymy wykonywanie metody
                return;
            }
            newPopulation.add(mutation(specimen));                                                                      //w innym wypadku dodajemy osobnika, który najpierw przechodzi mutację
            cloningFactor--;
        }
    }

    /*
    Metoda mutująca zwracająca pierwotnego osobnika lub jego mutanta w zależności od
    wartości funkcji celu (mniej == lepiej)
     */
    private ArrayList<Integer> mutation(ArrayList<Integer> specimen) {
        int index_0 = (int) (Math.random() * (matrixOfRelationships.length - 2)) + 1;                                   //losuje liczbe z zakresu 1 - (length - 1)
        int index_1 = index_0;

        while (index_0 == index_1) {                                                                                    //jeśli index_0 != index_1 to kończy / nie wykonuje pętli
            index_1 = (int) (Math.random() * (matrixOfRelationships.length - 2)) + 1;                                   //losuje liczbe z zakresu 1 - (length - 1)
        }

        ArrayList<Integer> afterMutation = specimen;
        Collections.swap(afterMutation, index_0, index_1);                                                              //następuje mutacja, czyli zamiana kolejności odwiedzonych pokoi

        if (goalFunction(specimen) > goalFunction(afterMutation)) {                                                     //sprawdzenie czy mutacja wyszła korzystniej niż pierwowzór
            return afterMutation;                                                                                       //jeśli tak to zwraca mutanta
        }
        return specimen;                                                                                                //jeśli nie to zwraca pierwowzór
    }

    /*
    Metoda pozwalająca wyświetlić całą wygenerowaną populację
     */
    public void showPopulation() {
        System.out.println(" ");
        for (List<Integer> p : population) {
            for (Integer i : p) {
                System.out.print(" " + i);
            }
            System.out.println(" ");
        }
    }

    /*
    Metoda pozwalająca wyświetlić macierz powiązań utworzoną na podtsawie danych zawartych w pliku
     */
    public void showMatrix() {
        for (int i = 0; i < matrixOfRelationships.length; i++) {
            for (int j = 0; j < matrixOfRelationships[i].length; j++) {
                System.out.print(" " + matrixOfRelationships[j][i] + " ");
            }
            System.out.println("");
        }
    }

    /*
    Metoda pozwalająca wyświetlić nazwy pokoi w zależności od ich liczebności
     */
    public void showNamesOfRooms() {
        System.out.println("");
        for (int i = 1; i <= matrixOfRelationships.length - 1; i++) {
            System.out.println(" " + i + " " + rooms.get(i) + " ");
        }
        System.out.println("");
    }

    public void results() {
        generateNameOfRooms();
        System.out.println("\nFINALNE WYNIKI\n");
        ArrayList<Character> finalRooms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (Integer room : population.get(i)) {
                finalRooms.add(rooms.get(room));
            }
            System.out.println(Arrays.toString(finalRooms.toArray()) + "  Wartość funkcji celu: " + goalFunction(population.get(i)));
            finalRooms.clear();
        }
    }
}

