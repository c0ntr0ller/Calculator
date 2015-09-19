import java.util.Scanner;

/**
 * Created by Bek on 19.09.2015.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner;
        ComProcessor processor = new ComProcessor();
        if (args[0].isEmpty()){
            scanner = new Scanner(System.in);
        }
        else {
            scanner = new Scanner(args[0]);
        }

        while (scanner.hasNext()){
            String strCommand = scanner.next();
            if (strCommand.equals("EXIT")){
                break;
            };

            processor.proceedCommand(strCommand);
        }
    }

}
