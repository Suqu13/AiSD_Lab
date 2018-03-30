
public class TESTER {
    public static void main(String[] args) {

        ArrayListWithCapicity list = new ArrayListWithCapicity(4);

        String hej = "Hej";
        int m = 6;
        int mk = 6;
        char znakA = 'a';
        String elo = "ELO";
        int md = 61;
        int mlk = 65;
        char znakB = 'b';

        list.add(hej);
        list.add(elo);
        list.add(0, znakA);
        list.add(2, znakB);
        list.add(hej);
        list.add(elo);
        list.add(0, znakA);
        list.add(2, znakB);


        System.out.println("Size: " + list.size());
        System.out.println("Empty?: " + list.isEmpty());
        list.show();

        System.out.println("First: " + list.indexOf(hej));
        System.out.println("Last: " + list.lastIndexOf(hej));
        System.out.println("\n");
        System.out.println("Contains: " + list.contains(mk));
        System.out.println("Contains: " + list.contains(znakA));
        System.out.println(list.size());

        list.removeIndex(0);
        list.remove(hej);
        System.out.println("\n");

        list.show();
        list.clear();
        System.out.println("Empty?: " + list.isEmpty());
    }
}