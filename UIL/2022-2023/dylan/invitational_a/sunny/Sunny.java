import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Sunny
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei
 * Date:	February 09, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Sort TCCNS data alphabetically and display in a more human friendly manner
 *
 */
class Sunny {
    public static void main(String[] args) throws IOException {
        Path dataPath = Path.of("sunny.dat");
        List<String> lines = Files.readAllLines(dataPath, Charset.forName("utf-8"));
        List<String> resultList = new ArrayList<>();
        for (String line : lines) {
            String courseCode = line.substring(0, 9);
            String r = line.substring(9) + " (" + courseCode + ")";
            resultList.add(r);
        }
        resultList.sort(null);
        for (String result : resultList)
            System.out.println(result);
    }
}
