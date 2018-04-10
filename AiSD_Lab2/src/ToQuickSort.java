import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;


public class ToQuickSort {

    private ArrayList<Integer> elements;


    //konstruktor wczytuje dane z pliku do listy
    public ToQuickSort(String nameOfTheFile) {
        elements = new ArrayList<Integer>();
        String tab[];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfTheFile)));
            while ((line = reader.readLine()) != null) {
                tab = line.split(",");
                for (int i = 0; i < tab.length; i++) {
                    elements.add(Integer.parseInt(tab[i]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wyświetla wszystkie elementy
    public void show() {
        for (Integer i : elements) {
            System.out.print(" " + i + " ");
        }
        System.out.println(" ");
    }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    /*
    sprawdza czy lista zawiera jakieś elementy, jeśli tak tp przechodzi do metody quickSort
    oraz pozwala na określenie sposobu wybierania pivotu
    */
    public void sort(int version) {
        if (elements.isEmpty()) {
            System.out.println("The List is empty!");
            return;
        }
        quickSort(0, elements.size() - 1, version);

    }

    //Może trochę przekombinowane, ale dobrze czasami sobie coś przypomnieć, w tym przypadku mapy
    public int findMedianOfThreeElements(int left, int right) {
        HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();

        newList.add(elements.get(left));
        newList.add(elements.get((int) Math.floor((left + (right - left)) / 2)));
        newList.add(elements.get(right));

        newMap.put(elements.get(left), left);
        newMap.put(elements.get((int) Math.floor((left + (right - left)) / 2)), (int) Math.floor((left + (right - left)) / 2));
        newMap.put(elements.get(right), right);

        // lista newList jest sortowana za pomocą bubbleSort, mediana 3 elementów ustawi się na srodku listy
        boolean t = true;
        while (t) {
            t = false;
            for (int i = 0; i < newList.size() - 1; i++) {
                if (newList.get(i) > newList.get(i + 1)) {
                    Collections.swap(newList, i, i + 1);
                    t = true;
                }
            }
        }

        /*
        korzystamy z właśności mapy, która jako klucze przyjmuje wartości
        elementów z pierwotenj listy podanej w argumentach metody i zwracamy value, czyli te indeksy
        */

        return newMap.get(newList.get(1));
    }

    //rozpatruje wybranie indexu pivota na podstawie trzech wersji, zwraca jego index
    public int selectPivot(int left, int right, int version) {
        int index0fPivot;
        switch (version) {

            //domyślnie ustawia index pivota na ostatnim miejsu problemu/ podproblemu, który rozpatrujemy

            default:

                index0fPivot = right;
                break;

            //ustawia index pivota na losowej pozycji z przediału

            case 2:

                int index = right;
                int pP = ThreadLocalRandom.current().nextInt(left, right);
                if (pP > left && pP < right)
                    index = pP;
                index0fPivot = index;
                break;

            //ustawia pivot na pozycji mediany trzech elementów (pierwszy, środkowy, ostatni)

            case 3:
                index0fPivot = findMedianOfThreeElements(left, right);
                break;
        }
        return index0fPivot;

    }

    private int partinion(int left, int right, int version) {

        //wyznacza pivot wedłóg podanej wersji i zamienia go z ostatnim indexem
        Collections.swap(elements, selectPivot(left, right, version), right);

        //pivot przyjmuje wartość ostatniego elementu po prawej stronie
        int pivot = elements.get(right);
        int border = left - 1;
        int i = left;

        while (i < right) {

            /*
            jeśli pivot jest większy od elementu listy znajdującego się po
            prawej stronie berder'u (wskazany przez index i)to border zostaje
            zamieniony z tym obiektem
             */

            if (elements.get(i) < pivot) {
                border++;
                if (border != i) {
                    Collections.swap(elements, border, i);
                }
            }
            i++;
        }

        /*
        jeśli border != right to następuje zamiana ich miejsc, traktujemy wtedy, że
        pivot znajdujący się obecnie na miejscu pierwszego elementu po prawej stronie
        border'u jest już posortowany i znajduje się na swojej finalnej pozycji w liście
        */

        border++;
        if (border != right) {
            Collections.swap(elements, border, right);
        }
        return border;
    }

    //główna metoda na quick sort
    public void quickSort(int left, int right, int version) {

        //kończy wykonywanie metody w momencie kiedy pivot będzie porównywany z samym sobą
        if (left >= right) return;

        //wywołanie metody patition, dzieli na mniejsze problemy i ustawia pivot na właściwym miejscu
        int border = partinion(left, right, version);

        /*
        rekurencyje wywołąnie kolejnych metod quickSort, dla tej samej listy, lecz ze
        zmienionymi zakresami działania fucnki, zastosowanie metody "dziel i rządź",
        problem został podzielony na podproblemy
        */

        quickSort(left, border - 1, version);
        quickSort(border + 1, right, version);
    }

    //TODO w wypadku, gdy w jednej linni przedział jest nie czytelny nalęzy skalować cało

    //metoda generująca prosty histogram
    public void generateBarGraph(int numberOfRanges) {

        ArrayList<Integer> list_2 = new ArrayList<Integer>();

        double range; //wartość o jaką przedziały się zwiększają
        double begginig = 0; //wartość która określa początek przedziału
        double theHighestElement = getTheHighest(); // najwyższa liczba w liście
        int element = 0; //służy za licznik


        // jeżeli liczba przedziałów jest większa niż połowa maksymalnej
        // wartości i mnjesza od 3/4 tego elementu to automatycznie ilość
        // zakresów wynosi 2
        if (numberOfRanges > theHighestElement / 2 && numberOfRanges < (theHighestElement / 4) * 3) {
            range = 2;

            // jeśli większa od największego alementu to automatycznie zakres wynosi 1
        } else if (numberOfRanges > theHighestElement) {
            range = 1;

            // wszelkie inne przypadki
        } else {
            range = theHighestElement / numberOfRanges;
        }

        double end = range;
        int maxHash = 30; //malsymalna ilość elementów w kolumnie


        double theBiggest = findTheBiggest(0, range); //liczba elementów w najdłóższej kolumnie histogramu
        int maxNumbers = (int) Math.round(theBiggest / (double) maxHash); // określenie jak optymalnie przyjąć wartość #

        //zabezpiecza wartość # dla dużej ilości przedziałów
        if (maxNumbers < 1) {
            maxNumbers = 1;
        }

        System.out.println("Ilość elementów w #: " + maxNumbers);


        while (begginig < theHighestElement) {

            //działamy na dublach, więc end nie zawsze osiągnie
            // wartość najwyższą, ale można przyjąć takie zabezpieczenia dla końca histogramu

            if (end > theHighestElement - 1) end = theHighestElement;

            if (begginig == 0) {
                System.out.printf("%-10s ", "\n<" + (int) begginig + "," + (int) Math.floor(end) + ">");
            } else {
                System.out.printf("%-10s ", "\n<" + (int) Math.ceil(begginig) + "," + (int) Math.floor(end) + ">");
            }

            Iterator<Integer> iterator_3 = elements.iterator();
            while (iterator_3.hasNext()) {
                int b = iterator_3.next();
                if (begginig < b && end >= b) { //dodaje do listy jeśli liczba znajduje się w określonym przedziale
                    list_2.add(b);
                    element++; //inkrementacja countera dla każedo elementu (każdy znajdzie dla siebie przedział)
                    if (list_2.size() == maxNumbers) { // jeśli ilość liczb na liście jest równa wartości # to następuje wydruk
                        System.out.print("#");
                        list_2.clear();
                    }
                }
            }
            begginig = end;
            end += range;

        }
        System.out.println("\n\nIlość elementów/ Counter: " + element);
    }

    //szuka przedziału który przechowuje najwięcej elementów i zwraca ilość tych elementów
    public int findTheBiggest(double beggining, double range) {

        ArrayList<Integer> list_1 = new ArrayList<Integer>();
        int n = 0;
        double end = range;

        //inkrementuje n za każdym razem gdy jakaś liczba zbajduje się w przedziale, kolejno wstawai uzyskane n do listy
        // zeruje wartość n po wstaweiniu zosatje wyzerowanan
        while (beggining < getTheHighest()) {
            Iterator<Integer> iterator_1 = elements.iterator();
            while (iterator_1.hasNext()) {
                int b = iterator_1.next();
                if (beggining < b && end >= b) {
                    n++;
                }
            }
            list_1.add(n);
            beggining = end;
            end += range;
            n = 0;
        }

        //szuka w liście największego elementu (miejsce reprezentuje przedział z największą ilością elementów)
        int w;
        n = Integer.MIN_VALUE;
        Iterator iterator_2 = list_1.iterator();
        while (iterator_2.hasNext()) {
            w = (int) iterator_2.next();
            if (w > n) {
                n = w;
            }
        }
        return n;
    }


    // zlicza ilość elementów w poszczególnych przedziałach
    public double showMediana() {
        int n = elements.size() - 1;
        if (elements.size() % 2 == 0) {
            int m = (int) Math.floor(n / 2);
            double b = ((elements.get(m) + elements.get(m + 1)));
            return (b / 2);
        } else {
            return elements.get(n / 2);
        }
    }

    public int getSize() {
        return elements.size();
    }

    public int getTheHighest() {
        int w;
        int n = Integer.MIN_VALUE;
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            w = (int) iterator.next();
            if (w > n) {
                n = w;
            }
        }
        return n;
    }

    public int getTheLowest() {
        int w;
        int n = Integer.MAX_VALUE;
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            w = (int) iterator.next();
            if (w < n) {
                n = w;
            }
        }
        return n;
    }
}


