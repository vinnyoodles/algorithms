import java.util.Scanner;
import java.util.Hashtable;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;

public class Polling {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int count = Integer.parseInt(s.nextLine());
    Hashtable<String, Integer> table = new Hashtable<String, Integer>(count);
    int score = 0;
    for (int i = 0; i < count; i++) {
      String name = s.nextLine().trim();
      if (name.length() == 0) {
        continue;
      }
      if (table.get(name) == null) {
        table.put(name, 1);
        score = Math.max(score, 1);
      } else {
        int currentScore = table.get(name) + 1;
        table.put(name, table.get(name) + 1);
        score = Math.max(currentScore, score);
      }
    }

    Set<String> keys = table.keySet();
    ArrayList<String> names = new ArrayList<String>(count);
    for (String key: keys) {
      if (table.get(key) == score){
        names.add(key);
      }
    }
    String[] foo = new String[names.size()];

    for (int i = 0; i < names.size(); i ++) {
      foo[i] = names.get(i);
    }

    Arrays.sort(foo);
    for (String name: foo) {
      if (name.length() == 0) {
        continue;
      }
      System.out.println(name.trim());
    }
  }
}
