import java.util.*;
public class Main {
    private static int linearSearch(Object[] items, Object target, int posFirst) {
        if (posFirst == items.length)
            return -1;
        else if (target.equals(items[posFirst]))
            return posFirst;
        else
            return linearSearch(items, target, posFirst + 1);

    }
    public static int linearSearch(Object[] items, Object target) {
        return linearSearch(items, target, 0);
    }
    public static void main(String[] args){


    
    // Linear Search

    	String[] greetings = {"Hi", "Hello", "Shalom"};
        int posHello = linearSearch(greetings, "Hello");
        System.out.println(posHello);

    }


}
