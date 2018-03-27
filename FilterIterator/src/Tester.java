public class Tester {
    public static void main(String[] args) {


        People p1 = new People(13, "P1");
        People p2 = new People(20, "P2");
        People p3 = new People(55, "P3");
        People p4 = new People(11, "P4");
        People p5 = new People(10, "P5");
        People p6 = new People(3, "P6");
        People p7 = new People(45, "P7");

        Adults AD= new Adults();

        AD.add(p1);
        AD.add(p2);
        AD.add(p3);
        AD.add(p4);
        AD.add(p5);
        AD.add(p6);
        AD.add(p7);

        AD.findAdults();


    }
}
