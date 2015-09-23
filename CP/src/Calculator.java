import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Bek on 19.09.2015.
 */
public class Calculator {
    public static void main(String[] args){
        Scanner scanner = null;
        ComProcessor processor = new ComProcessor();

        if (args.length > 0){
            try {
                scanner = new Scanner(new File(String.join(" ", args)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            scanner = new Scanner(System.in);
        }

        if (scanner != null) {
            while (scanner.hasNext()) {
                String strCommand = scanner.nextLine();
                if (strCommand.equals("EXIT")) {
                    break;
                }
                processor.proceedCommand(strCommand);
            }
        }
    }

}
