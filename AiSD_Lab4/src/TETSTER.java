import java.util.Scanner;

public class TETSTER {
    public static void main(String[] args) {
        World world = new World();

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nPodaj punkt początkowy: ");
            String start = sc.nextLine();
            System.out.print("Podaj punkt końcowy: ");
            String end = sc.nextLine();
            sc.close();
            world.findRoute(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
