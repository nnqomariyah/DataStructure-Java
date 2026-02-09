public class ObjectReferenceIdentity {
    public static void main(String[] args) {
        String s1 = new String("BINUS");
        String s2 = new String("BINUS");

        // TODO 1: Predict then run:
        System.out.println("s1 == s2      : " + (s1 == s2));
        System.out.println("s1.equals(s2) : " + s1.equals(s2));

        // TODO 2: Make s3 reference the same object as s1
        String s3 = s1;

        // TODO 3: Predict then run:
        System.out.println("s1 == s3      : " + (s1 == s3));
        System.out.println("s1.equals(s3) : " + s1.equals(s3));
    }
}
