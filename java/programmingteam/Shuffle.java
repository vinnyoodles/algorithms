import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Shuffle {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int count = Integer.parseInt(s.next());
    String[] things = new String[count];
    int half = count / 2;
    int counter = 1;
    if (count % 2 != 0) {
      half ++;
      counter ++;
    }
    for (int i = 0; i<count; i++) {
      things[i] = s.next();
    }
    int a = 0;
    int b = half;
    boolean boo = true;
    int foo = 0;
    while(foo < count) {
      if (boo) {
        if (a < b) {
          System.out.println(things[a]);
          a ++;
        }
      } else {
        System.out.println(things[b]);
        b ++;
      }
      boo = !boo;
      foo ++;
    }
  }
}
