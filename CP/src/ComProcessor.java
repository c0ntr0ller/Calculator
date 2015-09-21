import java.util.*;

/**
 * Created by Bek on 19.09.2015.
 */
public class ComProcessor {
    private Map<String, Command> cmds;
    public Stack stack;
    public Map<String, Double> dvars;

    ComProcessor(){
        cmds = new HashMap();
        stack = new Stack();
        dvars = new HashMap();
        cmds.put("ADD", new AddCmd());
        cmds.put("MULT", new MultiCmd());
        cmds.put("MINUS", new MinusCmd());
        cmds.put("DIV", new DivCmd());
        cmds.put("PUSH", new PushCmd());
        cmds.put("PRINT", new PrintCmd());
        cmds.put("DEFINE", new DefineCmd());
        cmds.put("SQRT", new SqrtCmd());
        cmds.put("POP", new PopCmd());
        cmds.put("CLEAR", new ClearCmd());
    }

    public void proceedCommand(String incmd){
        String[] args = incmd.split(" ");
        if (!args[0].equals("#")) {
            Command c = cmds.get(args[0]);
            if (c == null) {
                Messager.msgInvalidCommand();
            } else {
                c.execute(stack, dvars, args);
            }
        }

    }
}
