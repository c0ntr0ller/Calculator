package ru.bek.calc;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Bek on 19.09.2015.
 */
public class ComProcessor2 {

    public Stack stack = new Stack();
    public Map<String, Double> dvars = new HashMap();
    public Factory cFactory;

    ComProcessor2() throws IOException {
        cFactory = new Factory();
    }

    public void proceedCommand(String incmd){
        String[] args = incmd.split(" ");
        if (!args[0].equals("#") && !args[0].isEmpty()) {

            Command c = cFactory.getCommanByName(args[0]);

            if (c == null) {
                Messager.msgInvalidCommand(args[0]);
            } else {
                c.execute(stack, dvars, args);
            }
        }
    }
}
