package ru.bek.calc;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Bek on 19.09.2015.
 */
public interface Command {
    void execute(Stack<Double> stack,
        Map<String, Double> dvars,
        String[] args);
}
