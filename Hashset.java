import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.print(set);

        System.out.println("Size = " + set.size());

        if (set.contains(1)) {
            System.out.println("Set contains 1");
        }

        if (!set.contains(7)) {
            System.out.println("Does not contain 7");
        }

        set.remove(2);

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}