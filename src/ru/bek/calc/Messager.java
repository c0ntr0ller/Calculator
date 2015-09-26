package ru.bek.calc;

/**
 * Created by Bek on 21.09.2015.
 */
public class Messager {
    public static void msgCustom(String msg){
        System.out.println(msg);
    }
    public static void msgInvalidCommand(String cmdName){
        System.out.println("Invalid command: " + cmdName);
    }
}
