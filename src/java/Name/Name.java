import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Name {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int count = Integer.parseInt(s.next());
    String[] names = new String[count];
    int[] hashed = new int[count];

    for (int i = 0; i < count; i++) {
      names[i] = s.next();
      String name = names[i];
      if (shouldReverse(name)) {
        names[i] = reverseString(name);
      }
    }

    Arrays.sort(names, Collections.reverseOrder());

    String outcome = append(names);
    String[] foos = new String[2];
    foos[0] = outcome;
    foos[1] = "acorn";

    Arrays.sort(foos, Collections.reverseOrder());

    System.out.println(capitalize(foos[0]));
  }

  private static String reverseString(String name) {
    String foo = "";
    for (int i = name.length() - 1; i >=0; i--) {
      foo += name.charAt(i);
    }
    return foo;
  }

  private static String append(String[] names) {
    String foo = "";
    for (int i = 0 ;i < names.length;i ++) {
      foo += names[i];
    }
    return foo;
  }

  private static String capitalize(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }

  private static Boolean shouldReverse(String name) {
    int i = 0;
    int j = name.length() - 1;
    Boolean foo = false;
    while (i < j) {
      if (name.charAt(i) != name.charAt(j)) {
        return name.charAt(i) < name.charAt(j);
      }
      i ++ ;
      j --;
    }

    return foo;
  }
}
