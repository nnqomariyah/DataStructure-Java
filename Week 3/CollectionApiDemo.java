import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionApiDemo {
    public static void main(String[] args) {

        // Collection<E> is an interface; ArrayList is one implementation
        Collection<String> names = new ArrayList<>();

        // 1) add(E obj)
        boolean added1 = names.add("Ira");
        boolean added2 = names.add("Budi");
        boolean added3 = names.add("Ira"); // duplicates allowed in List-based collections

        System.out.println("Added Ira? " + added1);
        System.out.println("Added Budi? " + added2);
        System.out.println("Added Ira again? " + added3);

        // 2) size()
        System.out.println("Size: " + names.size());

        // 3) contains(E obj)
        System.out.println("Contains 'Ira'? " + names.contains("Ira"));
        System.out.println("Contains 'Siti'? " + names.contains("Siti"));

        // 4) iterator()
        System.out.println("Iterating with Iterator:");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String current = it.next();
            System.out.println("- " + current);

            // Example: removing safely while iterating
            if (current.equals("Budi")) {
                it.remove(); // removes "Budi" from the collection
            }
        }

        System.out.println("After removal, size: " + names.size());
        System.out.println("Now contains 'Budi'? " + names.contains("Budi"));
        System.out.println("Final collection: " + names);
    }
}
