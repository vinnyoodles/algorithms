package tools;
import java.lang.StringBuilder;
public class Utilities {
    private static final int MAX_VERTEX = 128;
    private static final int MIN_VERTEX = 16;

    public static void compare(int[] expected, int[] actual) throws Exception {
        if (expected == actual) return;

        String message = Utilities.exceptionMessage(
            Utilities.toString(expected), Utilities.toString(actual)
        );

        if (expected == null || actual == null || expected.length != actual.length) {
            throw new Exception(message);
        }

        for (int i = 0; i < expected.length; i ++) {
            if (expected[i] != actual[i]) throw new Exception(message);
        }
    }

    public static void compare(int[][] expected, int[][] actual) throws Exception {
        if (expected == actual) return;

        String message = "Incorrect matrix";

        if (expected == null || actual == null || expected.length != actual.length) {
            throw new Exception(message);
        }

        for (int i = 0; i < expected.length; i ++) {
            for (int j = 0; j < expected[i].length; j ++) {
                if (expected[i][j] != actual[i][j]) throw new Exception(message);
            }
        }
    }

    public static String toString(int[] a) {
        if (a == null) return "[]";
        StringBuilder b = new StringBuilder();

        b.append("[");
        for (int i = 0; i < a.length; i ++) {
            b.append(a[i]);
            if (i < a.length - 1) b.append(", ");
        }
        b.append("]");

        return b.toString();
    }

    public static int getRandomNumber(int min, int max) {
        return min + ((int) (Math.random() * (max - min)));
    }

    public static int[] getRandomGraphParameters() {
        int n = Utilities.getRandomNumber(MIN_VERTEX, MAX_VERTEX);
        int m = Math.min(
            Utilities.getRandomNumber(n - 1, (int) ((n * (n - 1)) / 5)),
            (n - 1) * 5
        );
        return new int[] { n, m };
    }

    public static String exceptionMessage(String expected, String actual) {
        return String.format("Expected: %s, but got %s", expected, actual);
    }
}