package ru.bek.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bek on 19.09.2015.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = null;
        ComProcessor2  processor = null;
        if (args.length > 0){
            try {
                scanner = new Scanner(new File(args[0]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            scanner = new Scanner(System.in);
        }

        try {
            processor = new ComProcessor2();
        } catch (IOException e) {
            e.printStackTrace();
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
