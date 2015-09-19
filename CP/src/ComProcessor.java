import java.util.*;

/**
 * Created by Bek on 19.09.2015.
 */
public class ComProcessor {
    private Map<String, Command> cmds;
    public Stack<Double> stack;
    public Map<String, Double> dvars;

    ComProcessor(){
        cmds = new HashMap();
        stack = new Stack();
        dvars = new HashMap();
        cmds.put("ADD", new AddCmd());
        cmds.put("MILT", new MultiCmd());
        cmds.put("MINUS", new MinusCmd());
        cmds.put("DIV", new DivCmd());
        cmds.put("PUSH", new PushCmd());
        cmds.put("PRINT", new PrintCmd());
        cmds.put("DEFINE", new DefineCmd());
    }

    public void proceedCommand(String incmd){
        String[] args = incmd.split(" ");
        Command c = cmds.get(args[0]);
        c.execute(stack,dvars, args);
    }
}
