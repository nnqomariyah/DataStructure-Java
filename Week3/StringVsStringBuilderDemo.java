public class StringVsStringBuilderDemo {

    public static void main(String[] args) {
        // 1) Small/simple concatenation → String (readable & fine)
        String greeting = "Hello, " + "Ira" + "!";   // compiler often optimizes this
        System.out.println(greeting);

        // 2) String is immutable: each "+=" creates a NEW String object
        String s = "";
        for (int i = 0; i < 5; i++) {
            s += i; // creates a new String each iteration (old content copied)
        }
        System.out.println("String result: " + s);

        // 3) Repeated concatenation in loops / large text → StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i); // modifies the same buffer (no new String each time)
        }
        String built = sb.toString();
        System.out.println("StringBuilder result: " + built);

        // 4) Realistic example: building logs/messages
        String user = "Ira";
        int score = 92;

        // Small/simple: OK with String (few parts)
        String msg = "User " + user + " scored " + score;
        System.out.println(msg);

        // Many parts in a loop: use StringBuilder
        StringBuilder log = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            log.append("Attempt ").append(i)
               .append(": user=").append(user)
               .append(", score=").append(score)
               .append("\n");
        }
        System.out.println(log.toString());
    }
}
