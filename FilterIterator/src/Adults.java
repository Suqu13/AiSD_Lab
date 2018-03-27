import java.util.ArrayList;
import java.util.Iterator;

public class Adults implements Predicate {

    private static ArrayList<People> listOfPeople=new ArrayList<>();

    @Override
    public boolean accepept(Object o) {
        People element= (People) o;
        return ((People) o).getAge()>=18;
    }

    public void add(People person){
        listOfPeople.add(person);
    }

    public void findAdults(){
        Iterator<People> iterator = listOfPeople.iterator();
        Predicate<People> predicate = new Adults();
        FilterIterator<People> filterIterator= new FilterIterator<>(iterator, predicate);

        while (filterIterator.hasNext()){
            System.out.println("Dorosłe osoby: " + filterIterator.next().getName());
        }

    }
}
