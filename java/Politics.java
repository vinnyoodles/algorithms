import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Hashtable;

public class Politics {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String f = s.nextLine();
    String[] ar = f.split("\\s");
    int candidateCount = Integer.parseInt(ar[0]);
    int supporterCount = Integer.parseInt(ar[1]);
    String[] candidates = new String[candidateCount];
    for (int i = 0; i <candidateCount; i++) {
      candidates[i] = s.nextLine();
    }

    Hashtable<String, ArrayList<String>> table = new Hashtable<String,ArrayList<String>>();
    Hashtable<String, ArrayList<String>> non = new Hashtable<String,ArrayList<String>>();
    ArrayList<String> nonC = new ArrayList<String>();

    for (int j = 0; j < supporterCount; j++) {
      String line = s.nextLine();
      String[] tokens = line.split("\\s");
      if (tokens.length < 2) {
        continue;
      }


      int index = indexOf(candidates, tokens[1]);
      if (index < 0)  {
        ArrayList<String> list = non.get(tokens[1]);
        if (list == null){
          nonC.add(tokens[1]);
        }


        if (list == null) {
          list = new ArrayList<String>();
        }

        list.add(tokens[0]);
        non.put(tokens[1], list);

      } else {
        ArrayList<String> list = table.get(tokens[1]);

        if (list == null) {
          list = new ArrayList<String>();
        }

        list.add(tokens[0]);
        table.put(tokens[1], list);

      }
    }

    int foo = print(table, candidates, candidateCount);
    int bar = supporterCount - foo;
    print(non, nonC, bar);

  }


  public static int print(Hashtable<String, ArrayList<String>> table, String[] array, int count) {
    int counter = 0;
    for (int i = 0 ; i < count; i ++) {
      ArrayList<String> l = table.get(array[i]);
      if (l == null) {
        continue;
      }
      for (int j = 0; j < l.size() ; j ++) {
        counter ++;
        System.out.println(l.get(j));
      }
    }
    return counter;
  }

  public static void print(Hashtable<String, ArrayList<String>> table, ArrayList<String> array, int bar) {
    for (int i = 0 ; i < array.size(); i ++) {
      ArrayList<String> l = table.get(array.get(i));
      if (l == null) {
        continue;
      }
      for (int j = 0; j < l.size() ; j ++) {
        System.out.println(l.get(j));
      }
    }

  }

  public static int indexOf(String[] array, String element) {
    for (int i = 0; i < array.length; i ++) {
      if (array[i].equals(element)) {
        return i;
      }
    }

    return -1;
  }
}
