package ru.bek.except;

/**
 * Created by Bek on 03.10.2015.
 */
public interface ExceptionGenerator {
        void generateNullPointerException();
        void generateClassCastException();
        void generateNumberFormatException();
        void generateStackOverflowException();
        void generateOutOfMemoryException();
        void generateMyException(String message) throws MyException;
}
