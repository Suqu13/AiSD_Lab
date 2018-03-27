import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadCSV {

    private List<Integer> list;
    private String[] tab;

    public void load(String fileName) {
        list = new ArrayList<Integer>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {

            while ((line = reader.readLine()) != null) {
                tab = line.split(",");
                for (int i = 0; i < tab.length; i++) {
                    list.add(Integer.parseInt(tab[i]));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bubbleSort() {
        boolean t = true;
        while (t) {
            t = false;
            for (int i = 0; i < list.size() - 1; i++) {
                int propablyHigher = list.get(i);
                int propablyLower = list.get(i + 1);
                if (propablyHigher > propablyLower) {
                    list.remove(i);
                    list.add(i, propablyLower);
                    list.remove(i + 1);
                    list.add(i + 1, propablyHigher);
                    t = true;
                }
            }
        }
    }

    public double showMediana(){
        int n = list.size()-1;
        if(list.size()%2==0){
            int m = (int) Math.floor(n/2);
            double b = ((list.get(m)+list.get(m+1)));
            return (b/2);
        } else {
            return list.get(n/2);
        }
    }

    public int getSize(){
        return list.size();
    }

    public int getTheHighest() {
        int w;
        int n=Integer.MIN_VALUE;
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            w = (int) iterator.next();
            if (w > n){
                n = w;
            }
        }
        return n;
    }

    public int getTheLowest() {
        int w;
        int n=Integer.MAX_VALUE;
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            w = (int) iterator.next();
            if (w < n){
                n = w;
            }
        }
        return n;
    }

    public void show(){
        Iterator iterator= list.iterator();
        while(iterator.hasNext()){
            int n = (int) iterator.next();
            if(n==list.get(list.size()-1)){
                System.out.print(n + " ");
            } else {
                System.out.print(n + ", ");
            }

        }
    }

}
