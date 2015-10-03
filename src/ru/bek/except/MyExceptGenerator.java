package ru.bek.except;

import java.util.List;
import java.util.Stack;

/**
 * Created by Bek on 03.10.2015.
 */
public class MyExceptGenerator implements ExceptionGenerator {
    @Override
    public void generateNullPointerException(){
        Integer a = null;
        a.toString();
    }

    @Override
    public void generateClassCastException() {
        Object a = new Integer(0);
        String s = (String) a;
    }

    @Override
    public void generateNumberFormatException() {
        String s = "test";
        Integer i = new Integer(s);
    }

    @Override
    public void generateStackOverflowException() {
        generateStackOverflowException();
    }

    @Override
    public void generateOutOfMemoryException() {
        int[] a = new int[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        MyException m = new MyException(message);
        throw m;
    }
}
