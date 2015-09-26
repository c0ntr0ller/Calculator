package ru.bek.calc;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Bek on 19.09.2015.
 */
public class ComProcessor2 {
    private Map<String, Command> cmds;
    public Stack stack;
    public Map<String, Double> dvars;
    private Properties p;

    ComProcessor2() throws IOException {

        p = new Properties();
        try(InputStream inputStream = Calculator.class.getResourceAsStream("commands.properties")){
            p.load(inputStream);
        }

        cmds = new HashMap<String, Command>();
        p.entrySet().forEach(e -> {
                    try {
                        cmds.put((String) e.getKey(),
                                (Command) Class.forName((String) e.getValue()).newInstance());
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e1) {
                        e1.printStackTrace();
                    }
                }
            );

        stack = new Stack();
        dvars = new HashMap();
//        cmds.put("ADD", new AddCmd());
//        cmds.put("MULT", new MultiCmd());
//        cmds.put("MINUS", new MinusCmd());
//        cmds.put("DIV", new DivCmd());
//        cmds.put("PUSH", new PushCmd());
//        cmds.put("PRINT", new PrintCmd());
//        cmds.put("DEFINE", new DefineCmd());
//        cmds.put("SQRT", new SqrtCmd());
//        cmds.put("CLEAR", new ClearCmd());
    }

    public void proceedCommand(String incmd){
        String[] args = incmd.split(" ");
        if (!args[0].equals("#") && !args[0].isEmpty()) {

            Command c = cmds.get(args[0]);

            if (c == null) {
                Messager.msgInvalidCommand(args[0]);
            } else {
                c.execute(stack, dvars, args);
            }
        }
    }
}
