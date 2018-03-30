
public class TESTER {
    public static void main(String[] args) {

        ArrayListWithoutCapicity list = new ArrayListWithoutCapicity();

        String hej = "Hej";
        int m = 6;
        int mk = 6;
        char znakA = 'a';
        String elo = "ELO";
        int md = 61;
        int mlk = 65;
        char znakB = 'b';

        list.add(elo);
        list.add(0, znakB);
        list.add(0, znakA);
        list.add(elo);
        list.show();

        System.out.println(list.lastIndexOf(znakB));
        System.out.println(list.indexOf(hej));

        list.set(3, hej);
        list.show();
        System.out.println(list.lastIndexOf(znakB));
        System.out.println(list.indexOf(hej));
    }
}
