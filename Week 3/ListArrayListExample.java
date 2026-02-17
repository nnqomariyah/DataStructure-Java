import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayListExample {
    public static void main(String[] args) {

        // 1) Program to the interface (List), instantiate with ArrayList
        List<String> names = new ArrayList<>();

        // 2) Add elements
        names.add("Alya");
        names.add("Bima");
        names.add("Citra");

        // 3) Insert at index
        names.add(1, "Dewi"); // shifts others to the right

        // 4) Access and update
        System.out.println("First element: " + names.get(0));
        names.set(2, "Bima Updated"); // replace element at index 2

        // 5) Size and iteration
        System.out.println("Size: " + names.size());
        for (String s : names) {
            System.out.println("- " + s);
        }

        // 6) Search
        System.out.println("Contains 'Citra'? " + names.contains("Citra"));
        System.out.println("Index of 'Citra': " + names.indexOf("Citra"));

        // 7) Remove (by value and by index)
        names.remove("Alya"); // remove first match
        names.remove(0);      // remove element at index 0

        // 8) Create from existing data (fixed-size list)
        List<Integer> numsFixed = Arrays.asList(10, 20, 30);
        System.out.println("Fixed list: " + numsFixed);
        // numsFixed.add(40); // would throw UnsupportedOperationException

        // 9) Make a real mutable ArrayList copy
        List<Integer> nums = new ArrayList<>(numsFixed);
        nums.add(40);

        // 10) Print final results
        System.out.println("Names: " + names);
        System.out.println("Nums: " + nums);
    }
}
