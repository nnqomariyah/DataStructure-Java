import java.util.*;

/** Class with methods to check whether a string is a palindrome. */
public class PalindromeFinder {

    /**
     * Fills a stack of characters from an input string.
     *
     * @param inputString the string to be checked
     * @return a stack of characters in inputString
     */
    private static Deque<Character> fillStack(String inputString) {
        Deque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < inputString.length(); i++) {
            charStack.push(inputString.charAt(i));
        }
        return charStack;
    }

    /**
     * Builds the reverse of a string by calling fillsStack
     * to push its characters onto a stack and then popping them
     * and appending them to a new string.
     *
     * @return The string containing the characters in the stack
     * @post The stack is empty.
     */

    private static String buildReverse(String inputString) {
        Deque<Character> charStack = fillStack(inputString);
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            // Remove top item from stack and append it to result.
            result.append(charStack.pop());
        }

        return result.toString();
    }

    /**
     * Calls buildReverse and compares its result to inputString
     *
     * @param inputString the string to be checked
     * @return true if inputString is a palindrome, false if not
     */

    public static boolean isPalindrome(String inputString) {
        return inputString.equalsIgnoreCase(buildReverse(inputString));
    }

}