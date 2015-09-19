import java.util.Scanner;

/**
 * Created by Bek on 19.09.2015.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner;
        ComProcessor processor = new ComProcessor();
        if (args.length > 0){
            scanner = new Scanner(args[0]);
        }
        else {
            scanner = new Scanner(System.in);
        }

        while (scanner.hasNext()){
            String strCommand = scanner.nextLine();
            if (strCommand.equals("EXIT")){
                break;
            };

            processor.proceedCommand(strCommand);
        }
    }

}
