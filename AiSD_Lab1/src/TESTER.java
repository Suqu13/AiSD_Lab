public class TESTER {
    public static void main(String[] args) {

        LoadCSV loadDANE1 = new LoadCSV();
        LoadCSV loadDANE2 = new LoadCSV();

        System.out.println("");
        System.out.println("Dla danych z pliku: z1data1.csv");
        loadDANE1.load("z1data1.csv");
        System.out.println("Liczba elementów: " + loadDANE1.getSize());
        loadDANE1.bubbleSort();
        System.out.println("Mediana: " + loadDANE1.showMediana());
        System.out.println("Największa wartość: " + loadDANE1.getTheHighest());
        System.out.println("Najmniejsza wartość: " + loadDANE1.getTheLowest());
        System.out.print("Lista: ");
        loadDANE1.show();

        System.out.println("\n");
        System.out.println("Dla danych z pliku: z1data2.csv");
        loadDANE2.load("z1data2.csv");
        System.out.println("Liczba elementów: " + loadDANE2.getSize());
        loadDANE2.bubbleSort();
        System.out.println("Mediana: " + loadDANE2.showMediana());
        System.out.println("Największa wartość: " + loadDANE2.getTheHighest());
        System.out.println("Najmniejsza wartość: " + loadDANE2.getTheLowest());
    }
}
