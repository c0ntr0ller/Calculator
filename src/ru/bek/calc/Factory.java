package ru.bek.calc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Bek on 01.10.2015.
 */
public class Factory {
    private Map<String, Command> cmds;

    public Factory() throws IOException {
        Properties p = new Properties();

        try(InputStream inputStream = Calculator.class.getResourceAsStream("commands.properties")) {
            p.load(inputStream);

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
        }
    }

    public Command getCommanByName(String cName){
        return cmds.get(cName);
    };
}
