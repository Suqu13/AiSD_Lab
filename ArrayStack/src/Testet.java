import java.util.EmptyStackException;

public class Testet {

    public static void main(String[] args) {

        String S = "Elo";
        boolean B = false;
        double D = 2.23;
        char C = 'x';
        int I = 2;

        ArrayStack AS= new ArrayStack(5);

        System.out.println("\n");

        try {
            AS.push((Object) S);
            AS.push((Object) B);
            AS.push((Object) D);
            AS.push((Object) C);
            AS.push((Object) I);
            AS.push((Object) I);

        } catch (FullStackException e) {
            e.MyExceptionFull();
        }

        System.out.println("\nTop index: " + AS.showTop());


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }
        System.out.println("\nTop index: " + AS.showTop());


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }
        System.out.println("\nTop index: " + AS.showTop());


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }
        System.out.println("\nTop index: " + AS.showTop());


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }
        System.out.println("\nTop index: " + AS.showTop());


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }
        System.out.println("\nTop index: " + AS.showTop() + "\n");


        try {
            System.out.println("Element: " + AS.pop());
        } catch (EmptyStackExceptionE e) {
            e.MyExceptionEmpty();
        }

    }
}
