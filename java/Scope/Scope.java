import java.util.Scanner;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Set;

public class Scope {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String PRINT = "print";
    String EQUALS = "=";
    int count = Integer.parseInt(s.nextLine());
    Hashtable<String, String> table = new Hashtable<String, String>();
    Stack<Hashtable<String, String>> stack = new Stack<Hashtable<String, String>>();

    stack.push(table);

    String[] lines = new String[count];

    for (int i = 0; i < count; i ++) {
      lines[i] = s.nextLine();
    }

    for (int j = 0; j < count; j ++) {
      String line = lines[j];
      Hashtable<String, String> scope = stack.peek();
      String[] tokens = line.split("\\s");

      // New scope or hashmap.
      if (line.equals("{")) {
        stack.push(copyTable(scope));

      // Close last scope.
      } else if (line.equals("}")) {
        stack.pop();

      } else if (line.contains(PRINT)) {
        String value = scope.get(tokens[1]);
        if (value == null) {
          value = "0";
        }
        if (value.length() != 0) {
          System.out.println(value);
        }
      } else if (line.contains(EQUALS)) {
        String value = scope.get(tokens[2]);
        if (value == null) {
          try {
            Integer.parseInt(tokens[2]);
            scope.put(tokens[0], tokens[2]);
          } catch (Exception e) {
            scope.put(tokens[0], "0");
          }
        } else {
          scope.put(tokens[0], value);
        }
      } else {
        System.exit(1);

      }
    }
  }

  public static Hashtable<String, String> copyTable(Hashtable<String, String> original) {
    Hashtable<String, String> table = new Hashtable<String, String>();
    Set<String> keys = original.keySet();
    for(String key: keys){
      table.put(key, original.get(key));
    }

    return table;
  }
}
