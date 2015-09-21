import java.util.Map;
import java.util.Stack;

/**
 * Created by Bek on 19.09.2015.
 */
public class PushCmd implements Command {

    @Override
    public void execute(Stack<Double> stack, Map<String, Double> dvars, String[] args) {
        Double curarg = dvars.get(args[1]);
        if (curarg == null) {
            stack.push(Double.valueOf(args[1]));
        }
        else {
            stack.push(curarg);
        }
    }
}
