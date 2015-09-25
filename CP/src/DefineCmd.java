import java.util.Map;
import java.util.Stack;

/**
 * Created by Bek on 19.09.2015.
 */
public class DefineCmd implements Command {

    @Override
    public void execute(Stack<Double> stack, Map<String, Double> dvars, String[] args) {
        if (dvars.containsKey(args[1])){
            dvars.remove(args[1]);
        }
        dvars.put(args[1], Double.valueOf(args[2]));

    }
}
