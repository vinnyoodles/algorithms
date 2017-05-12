import java.util.Scanner;
import java.util.Stack;

public class Paren {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String line = s.next();
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '(') {
        stack.push(line.charAt(i));
      } else if (line.charAt(i) == ')') {
        if (stack.empty()) {
          System.out.println("Unbalanced");
          return;
        }
        stack.pop();
      } else {
        System.out.println("Unbalanced");
        return;
      }
    }

    if (stack.empty()) {
      System.out.println("Balanced");
    } else {
      System.out.println("Unbalanced");
    }
  }
}
