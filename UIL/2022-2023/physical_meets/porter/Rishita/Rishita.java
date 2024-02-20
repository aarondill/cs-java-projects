import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Rishita
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: output a multilevel sort algorithm
 *
 */
class Rishita {
    public static void main(String[] args) throws IOException {
        Path dataPath = Path.of("./rishita.dat");
        List<String> lines = Files.readAllLines(dataPath, Charset.forName("utf-8"));
        List<String> classFirst = new ArrayList<>();
        lines.forEach(line -> {
            String[] parts = line.split(",");
            String name = parts[0];
            String room = parts[1];
            String school = parts[2];
            classFirst.add(school + "," + room + "   " + name);
        });
        classFirst.sort(null);
        List<String> alreadyFound = new ArrayList<>();
        classFirst.forEach(courseLine -> {
            String[] course = courseLine.split(",");
            String school = course[0];
            String roomAndName = course[1];
            if (!alreadyFound.contains(school)) {
                alreadyFound.add(school);
                System.out.println(school);
            }
            System.out.println("   " + roomAndName);
        });
    }
}
