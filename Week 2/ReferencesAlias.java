public class ReferencesAlias {

    static class Student {
        String name;
        int score;
        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String toString() { return name + " (" + score + ")"; }
    }

    public static void main(String[] args) {
        Student st1 = new Student("Ira", 80);
        Student st2 = st1; // alias

        // TODO 1: Print both
        System.out.println("st1 = " + st1);
        System.out.println("st2 = " + st2);

        // TODO 2: Change st2.score to 100
        st2.score = 100;

        // TODO 3: Print again and explain why st1 changed too
        System.out.println("st1 = " + st1);
        System.out.println("st2 = " + st2);

        // TODO 4 (challenge): Create st3 as an independent copy of st1
        // (Manual copy: new Student(st1.name, st1.score))
        Student st3 = new Student(st1.name, st1.score);

        st3.score = 60;
        System.out.println("st1 = " + st1);
        System.out.println("st3 = " + st3);
    }
}
