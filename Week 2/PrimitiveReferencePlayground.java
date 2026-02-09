import java.util.Arrays;
import java.util.Scanner;

public class PrimitiveReferencePlayground {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Primitive vs Reference Playground (Java) ===");
            System.out.println("1) Primitive copy vs reference alias");
            System.out.println("2) == vs equals (String)");
            System.out.println("3) Pass-by-value: int vs array");
            System.out.println("4) clone vs copyOf vs alias");
            System.out.println("5) Null safety mini-lab");
            System.out.println("6) Object identity (identityHashCode)");
            System.out.println("7) Fix the bug: shared roster (aliasing)");
            System.out.println("0) Exit");
            System.out.print("Choose a lab: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> lab1();
                case 2 -> lab2();
                case 3 -> lab3();
                case 4 -> lab4();
                case 5 -> lab5(sc);
                case 6 -> lab6();
                case 7 -> lab7();
                case 0 -> {
                    System.out.println("Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ------------------------------------------------------------
    // LAB 1: Primitive copy vs Reference alias
    // ------------------------------------------------------------
    static void lab1() {
        System.out.println("\n[Lab 1] Primitive copy vs Reference alias");

        int a = 10;
        int b = a;       // primitive copy
        b = 99;

        System.out.println("Primitive: a=" + a + ", b=" + b);
        System.out.println("Try: change b, a stays the same because primitives copy the value.");

        int[] x = {10, 20};
        int[] y = x;     // alias (reference copy)
        y[0] = 99;

        System.out.println("Reference: x=" + Arrays.toString(x));
        System.out.println("Reference: y=" + Arrays.toString(y));
        System.out.println("Try: x changes when you modify y, because both refer to the same array.");

        // TODO (student play): replace `int[] y = x;` with `int[] y = x.clone();` and rerun.
    }

    // ------------------------------------------------------------
    // LAB 2: == vs equals (String)
    // ------------------------------------------------------------
    static void lab2() {
        System.out.println("\n[Lab 2] == vs equals (String)");

        String s1 = "AI";
        String s2 = "AI";
        String s3 = new String("AI");

        System.out.println("s1 == s2      : " + (s1 == s2));
        System.out.println("s1 == s3      : " + (s1 == s3));
        System.out.println("s1.equals(s3) : " + (s1.equals(s3)));

        // TODO (student play):
        // 1) Replace "AI" with a longer string.
        // 2) Try: String s2 = new String("AI");
        // 3) Discuss: what does == compare? what does equals compare?
    }

    // ------------------------------------------------------------
    // LAB 3: Pass-by-value trick
    // ------------------------------------------------------------
    static void lab3() {
        System.out.println("\n[Lab 3] Pass-by-value: int vs array");

        int x = 5;
        changeInt(x);
        System.out.println("After changeInt(x), x = " + x);

        int[] a = {1, 2, 3};
        changeArray(a);
        System.out.println("After changeArray(a), a = " + Arrays.toString(a));

        reassignArray(a);
        System.out.println("After reassignArray(a), a = " + Arrays.toString(a));

        // TODO (student play):
        // Write reassignInt(int n) { n = 123; } and test if caller changes.
    }

    static void changeInt(int n) {
        n = 999;
    }

    static void changeArray(int[] arr) {
        arr[0] = 999;
    }

    static void reassignArray(int[] arr) {
        arr = new int[]{7, 7, 7};
    }

    // ------------------------------------------------------------
    // LAB 4: clone vs copyOf vs alias
    // ------------------------------------------------------------
    static void lab4() {
        System.out.println("\n[Lab 4] clone vs copyOf vs alias");

        int[] original = {1, 2, 3, 4};

        int[] c1 = original; // alias
        int[] c2 = original.clone(); // copy
        int[] c3 = Arrays.copyOf(original, original.length); // copy

        c1[0] = 99;
        c2[1] = 88;
        c3[2] = 77;

        System.out.println("original = " + Arrays.toString(original));
        System.out.println("c1(alias)= " + Arrays.toString(c1));
        System.out.println("c2(clone)= " + Arrays.toString(c2));
        System.out.println("c3(copy) = " + Arrays.toString(c3));

        // TODO (student play):
        // Try Arrays.copyOf(original, 2) and observe the length/output.
    }

    // ------------------------------------------------------------
    // LAB 5: Null safety mini-lab
    // ------------------------------------------------------------
    static void lab5(Scanner sc) {
        System.out.println("\n[Lab 5] Null safety mini-lab");

        System.out.print("Type a name (or just press Enter for null): ");
        String input = sc.nextLine();
        String name = input.isEmpty() ? null : input;

        // TODO: Print "length = 0" if name is null, else real length.
        // Implement using:
        // 1) if statement
        // 2) ternary operator
        // For now, it's intentionally incomplete.
        System.out.println("length = " + /* TODO */ 0);

        // TIP: name == null ? 0 : name.length()
    }

    // ------------------------------------------------------------
    // LAB 6: identityHashCode (object identity)
    // ------------------------------------------------------------
    static void lab6() {
        System.out.println("\n[Lab 6] Object identity (identityHashCode)");

        int[] a = {1, 2};
        int[] b = a;
        int[] c = a.clone();

        System.out.println("identity(a) = " + System.identityHashCode(a));
        System.out.println("identity(b) = " + System.identityHashCode(b));
        System.out.println("identity(c) = " + System.identityHashCode(c));

        // TODO (student play):
        // Modify b[0] and check a changes.
        // Modify c[0] and check a changes or not.
    }

    // ------------------------------------------------------------
    // LAB 7: Fix the bug (shared roster aliasing)
    // ------------------------------------------------------------
    static void lab7() {
        System.out.println("\n[Lab 7] Fix the bug: shared roster (aliasing)");

        String[] rosterA = {"Ira", "Budi", "Siti"};
        String[] rosterB = rosterA; // BUG: alias

        // TODO: Make rosterB independent (no alias).
        // Hint: rosterB = rosterA.clone(); OR Arrays.copyOf(...)
        rosterB = /* TODO */ rosterA;

        rosterB[0] = "Hacked";

        System.out.println("A = " + Arrays.toString(rosterA));
        System.out.println("B = " + Arrays.toString(rosterB));
    }
}
