public class MergeSort {


    private static int[] newTab;


    public static void sort(int[] tab) {
        newTab = new int[tab.length];
        int left = 0;
        int right = tab.length - 1;
        mergeSort(tab, left, right);
    }

    /*
    Dzieli całą tablice na mniejsze podproblemy do momentu, gdy podproblem stanie się jednym elementem (rekurencja)
    następuje powrót i wykonywanie po kolei merge
     */
    public static void mergeSort(int[] tab, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(tab, left, middle);
            mergeSort(tab, middle + 1, right);
            merge(tab, left, middle, right);
        }

    }

    /*
    Następuje sortowanie kolejnymi podproblemami, począwszy od najmniejszcyh
     */
    public static void merge(int[] tab, int leftIndex, int middleIndex, int rightIndex) {

        //Przepisuje cały rozpatrywany przedział
        for (int i = leftIndex; i <= rightIndex; i++) {
            newTab[i] = tab[i];
        }

        //f1, f2 - wskażniki pozycji w kopii
        int f1 = leftIndex;
        int f2 = middleIndex + 1;
        int current = leftIndex;

        //Determinuje wykonywanie while do chwili w której jeden z wskaźników osiągnie wartosć krańca
        while (f1 <= middleIndex && f2 <= rightIndex) {
            //Jeśli wartość pod f1 jest mniejsza od tej pod f2, to pierwsza zosatnie wpisana do pierwotenj tablicy pod indeksem current
            if (newTab[f1] <= newTab[f2]) {
                tab[current] = newTab[f1];
                f1++;
            } else {
                // Sutuacja analogicznie odwrotna
                tab[current] = newTab[f2];
                f2++;
            }
            current++;
        }
        //Rozpatrzenie sytuacji, w której wszystkie elementy wskazaywane przez f2 zostały wpisane, z f1 nie wszystkie
        while (f1 <= middleIndex) {
            tab[current] = newTab[f1];
            current++;
            f1++;
        }
    }
}
