

public class TESTER {
    public static void main(String[] args) throws EmptyStackException {

        System.out.println("\n");

        ToQuickSort dane_11 = new ToQuickSort("z3data11.csv");
        System.out.println("Nazwa pliku: " + dane_11.getNameFile());
        dane_11.quickSort(1);
        dane_11.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_11.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_11.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_11.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_21 = new ToQuickSort("z3data21.csv");
        System.out.println("Nazwa pliku: " + dane_21.getNameFile());
        dane_21.quickSort(2);
        dane_21.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_21.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_21.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_21.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_31 = new ToQuickSort("z3data31.csv");
        System.out.println("Nazwa pliku: " + dane_31.getNameFile());
        dane_31.quickSort(3);
        dane_31.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_31.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_31.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_31.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_12 = new ToQuickSort("z3data12.csv");
        System.out.println("Nazwa pliku: " + dane_12.getNameFile());
        dane_12.quickSort(1);
        dane_12.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_12.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_12.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_12.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_22 = new ToQuickSort("z3data22.csv");
        System.out.println("Nazwa pliku: " + dane_22.getNameFile());
        dane_22.quickSort(2);
        dane_22.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_22.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_22.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_22.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_32 = new ToQuickSort("z3data32.csv");
        System.out.println("Nazwa pliku: " + dane_32.getNameFile());
        dane_32.quickSort(3);
        dane_32.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_32.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_32.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_32.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_13 = new ToQuickSort("z3data13.csv");
        System.out.println("Nazwa pliku: " + dane_13.getNameFile());
        dane_13.quickSort(1);
        dane_13.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_13.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_13.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_13.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_23 = new ToQuickSort("z3data23.csv");
        System.out.println("Nazwa pliku: " + dane_23.getNameFile());
        dane_23.quickSort(2);
        dane_23.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_23.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_23.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_23.getMaximumStackHeight());

        System.out.println("\n");

        ToQuickSort dane_33 = new ToQuickSort("z3data33.csv");
        System.out.println("Nazwa pliku: " + dane_33.getNameFile());
        dane_33.quickSort(3);
        dane_33.showTheSelectedVersion();
        System.out.println("Liczebność: " + dane_33.size());
        System.out.println("Całkowita liczba zamian miejscami elementów zbioru: " + dane_33.getSwapPlaces());
        System.out.println("Maksymalna zarejstrowana wysokokść stosu: " + dane_33.getMaximumStackHeight());
    }
}
