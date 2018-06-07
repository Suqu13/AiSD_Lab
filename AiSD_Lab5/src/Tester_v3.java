import java.util.Scanner;

public class Tester_v3 {
    public static void main(String[] args) {

        char yesOrNot = 'T';
        String nameOfFile;
        int sizeOfPopulation = 0;
        double percentValue;
        String percent;

        System.out.println("\nPREZENTACJA ALGORYTMY HEURYSTYCZNEGO");
        Scanner sc = new Scanner(System.in);

        System.out.print("\nNAZWA PLIKU: ");
        nameOfFile = sc.next();

        Data data = new Data();
        data.loadData(nameOfFile);
        Population population = new Population(data.getMatrixOfConnections());

        while (sizeOfPopulation < 30 || sizeOfPopulation > 10000) {
            System.out.print("ROZMIAR GENEROWANEJ POPULACJI <30; 10000>: ");
            sizeOfPopulation = sc.nextInt();
            if (sizeOfPopulation < 30 || sizeOfPopulation > 10000) {
                System.out.println("!PODANA WARTOŚĆ NIE NALEŻY DO PRZEDZIAŁU!");
            }
        }

        percentValue = 0;
        while (percentValue <= 0 || percentValue >= 1) {
            System.out.print("PROCENT NAJGORZEJ DOSTOSOWANYCH OSOBNIKÓW DO USUNIĘCIA: ");
            percent = sc.next();
            percentValue = parsePercent(percent);
            if (percentValue <= 0 || percentValue >= 1) {
                System.out.println("!PODANA WARTOŚĆ NIE NALEŻY DO PRZEDZIAŁU!");
            }
        }

        System.out.print("\ns - stosunek wartości funkcji celu okazu celu do jej średniej wartości dla populacji \nm - stosunek wartości funkcji celu okazu do jej mediany dla populacji \nPODAJ SPOSÓB DOBORU WSPÓŁCZYNNIKA KLONOWANIA: ");
        char version = sc.next().charAt(0);

        int x = sizeOfPopulation +1;
        while (x >= sizeOfPopulation || x <= 0 ) {
            System.out.print("\nILOŚĆ WYŚWIETLANYCH OSOBNIKÓW:  ");
            x = sc.nextInt();
            if (x >= sizeOfPopulation) {
                System.out.println("!PODANA WARTOŚĆ JEST ZBYT DUŻA!");
            } else if (x <= 0) {
                System.out.println("!PODANA WARTOŚĆ JEST ZBYT MAŁA!");
            }

        }
        System.out.println(" ");



        while (yesOrNot == 'T' || yesOrNot == 't') {
            population.runAlgorithm(percentValue, sizeOfPopulation, version);
            population.results(x, data.getNamesOfCabinets());

            System.out.print("\nPOWTÓRZYĆ SYMULACJE (T/N):");
            yesOrNot = sc.next().charAt(0);
            System.out.println(" ");
        }

       /*
        if(yesOrNot != 'T' || yesOrNot != 't') {
            population.showPopulation();
        }
        */

        sc.close();
    }



    public static double parsePercent(String percent) {
        String[] tab = percent.split("%");
        return Double.parseDouble(tab[0]) / 100;
    }
}
