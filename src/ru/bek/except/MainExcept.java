package ru.bek.except;

/**
 * Created by Bek on 03.10.2015.
 */
public class MainExcept {
    public static void main(String[] args) throws MyException {
        MyExceptGenerator meg = new MyExceptGenerator();
        meg.generateMyException("test");
    }
}
