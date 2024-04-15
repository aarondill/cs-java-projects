import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cookies {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("cookies.dat"));
while(in.hasNextLine()){
    int orders = in.nextInt();
    String line = in.nextLine();
    String name = line.substring(line.indexOf("for ")+"for ".length());
    String first[] = name.toLowerCase().split(" ")[0].split("");
    String last[] = name.toLowerCase().split(" ")[1].split("");
    Arrays.sort(first);Arrays.sort(last);
    String firstBan[] = "Shrank".toLowerCase().split("");
    String lastBan[] = "Fraeder".toLowerCase().split("");
    Arrays.sort(firstBan);Arrays.sort(lastBan);
    if(String.join("", first) .equals(String.join("", firstBan) )
    && String.join("", last) .equals(String.join("", lastBan) )
    ){
        System.out.println("BANNED");
    }
}


    }

}
