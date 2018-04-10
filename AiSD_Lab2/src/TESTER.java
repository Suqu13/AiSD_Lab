public class TESTER {
    public static void main(String[] args) {

        ToQuickSort dane_1 = new ToQuickSort("z2data1.csv");

        //Opis wersji wyboru pivota dla sortowania QuickSort
        //default - pivot to otsatni element
        //1 - pivot losowy element
        //2 - pivot to mediana z trzech elemnetów (pierwszy, środkowy, ostatni)
        dane_1.sort(3);

        //System.out.println("\nLiczba elementów: " + dane_1.getSize());
        System.out.println("\nMediana: " + dane_1.showMediana());
        System.out.println("Największa wartość: " + dane_1.getTheHighest());
        System.out.println("Najmniejsza wartość: " + dane_1.getTheLowest());
        System.out.println(" ");
        dane_1.generateBarGraph(6);
        System.out.println("\n");


        ToQuickSort dane_2 = new ToQuickSort("z2data2.csv");

        dane_2.sort(1);

        //System.out.println("\nLiczba elementów: " + dane_2.getSize());
        System.out.println("Mediana: " + dane_2.showMediana());
        System.out.println("Największa wartość: " + dane_2.getTheHighest());
        System.out.println("Najmniejsza wartość: " + dane_1.getTheLowest());
        System.out.println(" ");
        dane_2.generateBarGraph(17);
        System.out.println("\n");


    }
}
