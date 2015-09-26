package ru.bek.calc;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Bek on 19.09.2015.
 */
public class PrintCmd implements Command {

    @Override
    public void execute(Stack<Double> stack, Map<String, Double> dvars, String[] args) {
        System.out.println(stack.get(stack.size() - 1));
    }

}
