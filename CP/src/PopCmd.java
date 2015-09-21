import java.util.Map;
import java.util.Stack;

/**
 * Created by Bek on 19.09.2015.
 */
public class PopCmd implements Command {

    @Override
    public void execute(Stack<Double> stack, Map<String, Double> dvars, String[] args) {
        dvars.put(args[1], stack.pop());
    }
}
