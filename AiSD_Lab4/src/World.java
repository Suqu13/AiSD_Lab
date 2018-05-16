import java.util.*;

public class World {

    private HashMap<String, HashMap<String, Integer>> cities;

    private List<String> nameOfCities;
    private List<Route> results;

    private HashMap<String, Integer> connectionWithBree;
    private HashMap<String, Integer> connectionWithAngmar;
    private HashMap<String, Integer> connectionWithRivendell;
    private HashMap<String, Integer> connectionWithIsengard;
    private HashMap<String, Integer> connectionWithGondolin;

    private HashMap<String, Integer> connectionWithTrondheim;
    private HashMap<String, Integer> connectionWithRoke;
    private HashMap<String, Integer> connectionWithLuistania;
    private HashMap<String, Integer> connectionWithGont;

    private HashMap<String, Integer> connectionWithAntuan;
    private HashMap<String, Integer> connectionWithSelidor;
    private HashMap<String, Integer> connectionWithHavnor;

    public World() {

        connectionWithBree = new HashMap<>();
        connectionWithAngmar = new HashMap<>();
        connectionWithRivendell = new HashMap<>();
        connectionWithIsengard = new HashMap<>();
        connectionWithGondolin = new HashMap<>();

        connectionWithTrondheim = new HashMap<>();
        connectionWithRoke = new HashMap<>();
        connectionWithLuistania = new HashMap<>();
        connectionWithGont = new HashMap<>();

        connectionWithAntuan = new HashMap<>();
        connectionWithSelidor = new HashMap<>();
        connectionWithHavnor = new HashMap<>();

        //Pierwszy dystrykt

        connectionWithBree.put("Roke", 1140);
        connectionWithBree.put("Trondheim", 638);
        connectionWithBree.put("Luistania", 630);
        connectionWithBree.put("Gont", 1210);
        connectionWithBree.put("Gondolin", 279);
        connectionWithBree.put("Angmar", 360);
        connectionWithBree.put("Isengard", 437);
        connectionWithBree.put("Rivendell", 525);

        connectionWithAngmar.put("Bree", 360);
        connectionWithAngmar.put("Rivendell", 186);
        connectionWithAngmar.put("Gondolin", 581);
        connectionWithAngmar.put("Isengard", 218);

        connectionWithRivendell.put("Bree", 525);
        connectionWithRivendell.put("Angmar", 186);
        connectionWithRivendell.put("Gondolin", 480);
        connectionWithRivendell.put("Isengard", 312);
        connectionWithRivendell.put("Gont", 996);
        connectionWithRivendell.put("Roke", 1024);
        connectionWithRivendell.put("Trondheim", 842);
        connectionWithRivendell.put("Luistania", 790);

        connectionWithIsengard.put("Gondolin", 357);
        connectionWithIsengard.put("Bree", 437);
        connectionWithIsengard.put("Angmar", 218);
        connectionWithIsengard.put("Rivendell", 312);

        connectionWithGondolin.put("Bree", 279);
        connectionWithGondolin.put("Angmar", 581);
        connectionWithGondolin.put("Isengard", 357);
        connectionWithGondolin.put("Rivendell", 480);

        //Drugi dystrykt

        connectionWithGont.put("Trondheim", 615);
        connectionWithGont.put("Roke", 375);
        connectionWithGont.put("Luistania", 750);
        connectionWithGont.put("Bree", 1210);
        connectionWithGont.put("Antuan", 685);
        connectionWithGont.put("Havnor", 484);
        connectionWithGont.put("Selidor", 560);

        connectionWithTrondheim.put("Bree", 638);
        connectionWithTrondheim.put("Rivendell", 842);
        connectionWithTrondheim.put("Roke", 876);
        connectionWithTrondheim.put("Luistania", 820);
        connectionWithTrondheim.put("Gont", 615);

        connectionWithRoke.put("Trondheim", 876);
        connectionWithRoke.put("Bree", 1140);
        connectionWithRoke.put("Rivendell", 1024);
        connectionWithRoke.put("Gont", 375);
        connectionWithRoke.put("Luistania", 726);
        connectionWithRoke.put("Selidor", 410);
        connectionWithRoke.put("Havnor", 337);
        connectionWithRoke.put("Antuan", 512);

        connectionWithLuistania.put("Gont", 750);
        connectionWithLuistania.put("Trondheim", 820);
        connectionWithLuistania.put("Roke", 726);
        connectionWithLuistania.put("Bree", 630);
        connectionWithLuistania.put("Rivendell", 790);

        //Drugi trzeci

        connectionWithAntuan.put("Gont", 685);
        connectionWithAntuan.put("Roke", 512);
        connectionWithAntuan.put("Selidor", 604);
        connectionWithAntuan.put("Havnor", 607);

        connectionWithSelidor.put("Antuan", 604);
        connectionWithSelidor.put("Havnor", 350);
        connectionWithSelidor.put("Gont", 560);
        connectionWithSelidor.put("Roke", 410);

        connectionWithHavnor.put("Antuan", 607);
        connectionWithHavnor.put("Selidor", 350);
        connectionWithHavnor.put("Roke", 337);
        connectionWithHavnor.put("Gont", 484);

        cities = new HashMap<>();

        cities.put("Bree", connectionWithBree);
        cities.put("Angmar", connectionWithAngmar);
        cities.put("Rivendell", connectionWithRivendell);
        cities.put("Isengard", connectionWithIsengard);
        cities.put("Gondolin", connectionWithGondolin);

        cities.put("Trondheim", connectionWithTrondheim);
        cities.put("Gont", connectionWithGont);
        cities.put("Roke", connectionWithRoke);
        cities.put("Lusitania", connectionWithLuistania);

        cities.put("Antuan", connectionWithAntuan);
        cities.put("Selidor", connectionWithSelidor);
        cities.put("Havnor", connectionWithHavnor);

        nameOfCities = new ArrayList<>();

        nameOfCities.add("Bree");
        nameOfCities.add("Angmar");
        nameOfCities.add("Rivendell");
        nameOfCities.add("Isengard");
        nameOfCities.add("Gondolin");
        nameOfCities.add("Trondheim");
        nameOfCities.add("Gont");
        nameOfCities.add("Roke");
        nameOfCities.add("Lusitania");
        nameOfCities.add("Antuan");
        nameOfCities.add("Selidor");
        nameOfCities.add("Havnor");

        results = new ArrayList<>();

    }

    private class Route {

        private int numberOfStations;
        private int distance;
        private List<String> stations = new ArrayList<>();

        private Route() {
            this.numberOfStations = 0;
            this.distance = 0;
            this.stations = new ArrayList<>();
        }

        private Route(Route route) {
            this.numberOfStations = route.numberOfStations;
            this.distance = route.getDistance();
            for (String station : route.getStations()) {
                this.stations.add(station);
            }

        }

        private int getNumberOfStations() {
            return numberOfStations;
        }

        private void setNumberOfStations(int numberOfStations) {
            this.numberOfStations = numberOfStations;
        }

        private int getDistance() {
            return distance;
        }

        private void setDistance(int distance) {
            this.distance = distance;
        }

        private List<String> getStations() {
            return stations;
        }

        private void addStation(String city) {
            stations.add(city);
        }
    }

    public void findRoute(String startOfRoute, String endOfRoute) {

        if (!nameOfCities.contains(startOfRoute) || !nameOfCities.contains(endOfRoute)) {
            System.out.println("\nBŁĘDNE DANE!");
            return;
        }
        Route route = new Route();
        find(startOfRoute, endOfRoute, route);


        Collections.sort(results, new Comparator<Route>() {

                    @Override
                    public int compare(Route o1, Route o2) {
                        if (o1.getDistance() > o2.getDistance()) {
                            return 1;
                        } else if (o1.getDistance() < o2.getDistance()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
        );

        System.out.println("\nMożliwe trasy przejazdu:\n ");


        for (Route result : results) {
            System.out.print("Trasa: ");
            for (int i = 0; i < result.getStations().size(); i++) {
                if (i < result.getStations().size() - 1) {
                    System.out.print(result.getStations().get(i) + " >> ");
                } else {
                    System.out.print(result.getStations().get(i) + " ");
                }
            }

            System.out.println(" ");
            System.out.println("Dlugość trasy: " + result.getDistance());
            System.out.println("Liczba przesiadek: " + result.getNumberOfStations());
            System.out.println(" ");
        }
    }

    private void find(String startOfRoute, String endOfRoute, Route route) {
        route.addStation(startOfRoute);

        if (cities.get(startOfRoute).get(endOfRoute) != null) {
            route.addStation(endOfRoute);
            route.setDistance(route.getDistance() + cities.get(startOfRoute).get(endOfRoute));
            results.add(route);
        }

        if (cities.get(startOfRoute).get(endOfRoute) == null) {
            for (String nameOfCity : nameOfCities) {
                if ((!route.getStations().contains(nameOfCity)) && (cities.get(startOfRoute).get(nameOfCity) != null)) {
                    Route newRoute = new Route(route);
                    newRoute.setNumberOfStations(route.getNumberOfStations() + 1);
                    newRoute.setDistance(route.getDistance() + cities.get(startOfRoute).get(nameOfCity));
                    find(nameOfCity, endOfRoute, newRoute);
                }
            }
        }
    }
}
