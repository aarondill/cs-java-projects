import java.util.HashMap;
import java.util.Map;

public class Maps {
  public static void main(String[] args) {
    System.out.println("Maps store key-value pairs");
    System.out.println("The most basic implementation is a HashMap: ");

    Map<String, Integer> hash = new HashMap<>();
    System.out.println("> Map<String, Integer> hash = new HashMap<>();");

    hash.put("A", 1);
    System.out.println("> hash.put(\"A\", 1);");
    hash.put("B", 2);
    System.out.println("> hash.put(\"B\", 2);");
    hash.put("B", 4);
    System.out.println("> hash.put(\"B\", 4);");
    hash.put("a", 2);
    System.out.println("> hash.put(\"a\", 2);");
    System.out.println(hash);
    System.out.println("> hash.get(\"a\");");
    System.out.println(hash.get("a"));
    System.out.println("> hash.get(\"B\");");
    System.out.println(hash.get("B"));

    hash.remove("A");
    System.out.println("> hash.remove(\"A\")");
    System.out.println(hash);

    System.out.println("> hash.containsKey(\"a\")");
    System.out.println(hash.containsKey("a"));
    System.out.println("> hash.containsKey(\"A\")");
    System.out.println(hash.containsKey("A"));

    System.out.println("> hash.size()");
    System.out.println(hash.size());
    System.out.println("> hash.entrySet(): ");
    System.out.println(hash.entrySet());

    for (var entry : hash.entrySet()) {
      System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
    }
  }
}
