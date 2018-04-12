import javax.print.attribute.SetOfIntegerSyntax;
import java.util.ArrayList;
import java.util.Calendar;

public class TESTER {
    public static void main(String[] args) throws EmptyStackException {

        System.out.println("\n");


        //TODO OPTYMALIZUJ, NIECH QUICKSORT ZACZNIE OD NAJMNIEJSZEGO PRZEDZIAŁU

        ArrayList<ToQuickSort> list = new ArrayList<>();

        ToQuickSort dane_11_P1 = new ToQuickSort("z3data11.csv");
        dane_11_P1.quickSort(1);
        list.add(dane_11_P1);
        ToQuickSort dane_11_P2 = new ToQuickSort("z3data11.csv");
        dane_11_P2.quickSort(2);
        list.add(dane_11_P2);
        ToQuickSort dane_11_P3 = new ToQuickSort("z3data11.csv");
        dane_11_P3.quickSort(3);
        list.add(dane_11_P3);

        ToQuickSort dane_21_P1 = new ToQuickSort("z3data21.csv");
        dane_21_P1.quickSort(1);
        list.add(dane_21_P1);
        ToQuickSort dane_21_P2 = new ToQuickSort("z3data21.csv");
        dane_21_P2.quickSort(2);
        list.add(dane_21_P2);
        ToQuickSort dane_21_P3 = new ToQuickSort("z3data21.csv");
        dane_21_P3.quickSort(3);
        list.add(dane_21_P3);

        ToQuickSort dane_31_P1 = new ToQuickSort("z3data31.csv");
        dane_31_P1.quickSort(1);
        list.add(dane_31_P1);
        ToQuickSort dane_31_P2 = new ToQuickSort("z3data31.csv");
        dane_31_P2.quickSort(2);
        list.add(dane_31_P2);
        ToQuickSort dane_31_P3 = new ToQuickSort("z3data31.csv");
        dane_31_P3.quickSort(3);
        list.add(dane_31_P3);

        ToQuickSort dane_12_P1 = new ToQuickSort("z3data12.csv");
        dane_12_P1.quickSort(1);
        list.add(dane_12_P1);
        ToQuickSort dane_12_P2 = new ToQuickSort("z3data12.csv");
        dane_12_P2.quickSort(2);
        list.add(dane_12_P2);
        ToQuickSort dane_12_P3 = new ToQuickSort("z3data12.csv");
        dane_12_P3.quickSort(3);
        list.add(dane_12_P3);

        ToQuickSort dane_22_P1 = new ToQuickSort("z3data22.csv");
        dane_22_P1.quickSort(1);
        list.add(dane_22_P1);
        ToQuickSort dane_22_P2 = new ToQuickSort("z3data22.csv");
        dane_22_P2.quickSort(2);
        list.add(dane_22_P2);
        ToQuickSort dane_22_P3 = new ToQuickSort("z3data22.csv");
        dane_22_P3.quickSort(3);
        list.add(dane_22_P3);

        ToQuickSort dane_32_P1 = new ToQuickSort("z3data32.csv");
        dane_32_P1.quickSort(1);
        list.add(dane_32_P1);
        ToQuickSort dane_32_P2 = new ToQuickSort("z3data32.csv");
        dane_32_P2.quickSort(2);
        list.add(dane_32_P2);
        ToQuickSort dane_32_P3 = new ToQuickSort("z3data32.csv");
        dane_32_P3.quickSort(3);
        list.add(dane_32_P3);

        ToQuickSort dane_13_P1 = new ToQuickSort("z3data13.csv");
        dane_13_P1.quickSort(1);
        list.add(dane_13_P1);
        ToQuickSort dane_13_P2 = new ToQuickSort("z3data13.csv");
        dane_13_P2.quickSort(2);
        list.add(dane_13_P2);
        ToQuickSort dane_13_P3 = new ToQuickSort("z3data13.csv");
        dane_13_P3.quickSort(3);
        list.add(dane_13_P3);

        ToQuickSort dane_23_P1 = new ToQuickSort("z3data23.csv");
        dane_23_P1.quickSort(1);
        list.add(dane_23_P1);
        ToQuickSort dane_23_P2 = new ToQuickSort("z3data23.csv");
        dane_23_P2.quickSort(2);
        list.add(dane_23_P2);
        ToQuickSort dane_23_P3 = new ToQuickSort("z3data23.csv");
        dane_23_P3.quickSort(3);
        list.add(dane_23_P3);

        ToQuickSort dane_33_P1 = new ToQuickSort("z3data33.csv");
        dane_33_P1.quickSort(1);
        list.add(dane_33_P1);
        ToQuickSort dane_33_P2 = new ToQuickSort("z3data33.csv");
        dane_33_P2.quickSort(2);
        list.add(dane_33_P2);
        ToQuickSort dane_33_P3 = new ToQuickSort("z3data33.csv");
        dane_33_P3.quickSort(3);
        list.add(dane_33_P3);

        System.out.println("LZM - całkowita liczba zamian miejscami");
        System.out.println("MWS - maksymalna liczebność stosu");
        System.out.println(" ");
        System.out.println("Sposób doboru pivotu: ");
        System.out.println("P1 - ostatni element z zadanego przedziału");
        System.out.println("P2 - losowy element z zadanego przedziału");
        System.out.println("P3 - mediana trzech elementów należących do zadanego przedziału (pierwszy, środkowy, ostatni)");


        System.out.println("\n");

        System.out.printf("%-15s %10s %10s %10s %10s\n", "Nazwa pliku ", "Liczebność", "Pivot", "LZM", " MWS");
        String name = "name";
        for (ToQuickSort TQS : list) {
            if (name != TQS.getNameFile()) System.out.println(" ");
            System.out.printf("%-15s %10d %10s %10d %10d\n", TQS.getNameFile(), TQS.size(), TQS.showTheSelectedVersion(), TQS.getSwapPlaces(), TQS.getMaximumStackHeight());
            name = TQS.getNameFile();
        }


    }
}
