import java.util.Scanner;

public class TETSTER {

    public static void main(String[] args) {


        World world = new World();
        String onOff = "Tak";

        try {
            Scanner sc = new Scanner(System.in);


            while (onOff.equals("Tak")) {

                System.out.print("\nPodaj punkt początkowy: ");
                String start = sc.next();

                System.out.print("Podaj punkt końcowy: ");
                String end = sc.next();

                if (world.getNameOfCities().contains(start) && world.getNameOfCities().contains(end)) {

                    System.out.print("Podaj kryteruim wyszukiwania (D- najkrótsza trasa/ P- najmniejsza ilość przesiadek): ");
                    char version = sc.next(".").charAt(0);

                    System.out.print("Podaj maksymalną liczbę wyników wyszukiwania: ");
                    int size = sc.nextInt();

                    world.findRoute(start, end, size, version);
                    System.out.println("\nRozpocząć ponowne wyszukiwanie?: (Tak/Nie)");
                    onOff = sc.next();

                } else {
                    System.out.println("\n!BŁEDNE DANE!");
                }
            }

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

