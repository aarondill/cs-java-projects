import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class UtfEncode {
  public static BufferedReader input(String path) throws FileNotFoundException {
    Reader reader = path.equals("-") ? new InputStreamReader(System.in) : new FileReader(path);
    return new BufferedReader(reader);
  }

  public static BufferedWriter output(String path) throws FileNotFoundException, IOException {
    Writer reader = path.equals("-") ? new OutputStreamWriter(System.out) : new FileWriter(path);
    return new BufferedWriter(reader);
  }

  private static void usage(int code) {
    System.err.println(String.format("Usage: %s <in> [out]", UtfEncode.class.getSimpleName()));
    System.exit(code);
  }

  public static void main(String... args) throws FileNotFoundException, IOException {
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--help", "-h":
          usage(0);
      };
    }
    if (args.length == 0) usage(2);
    String inpath = args[0];
    String outpath = args.length > 1 ? args[1] : "-";

    try (BufferedReader in = input(inpath); BufferedWriter out = output(outpath)) {
      int c;
      while ((c = in.read()) != -1) {
        if (c == '\n') out.write(c);
        else out.write(String.format("\\u%04X", (int) c));
      }
    }
  }
}
