import junit.framework.TestCase;
import ru.bek.calc.myMain;

/**
 * Created by Bek on 24.09.2015.
 */
public class FirstTest extends TestCase {
    public void setUp() throws Exception{
        super.setUp();
    }

    public void tearDown() throws Exception{
        super.tearDown();
    }
    public void testMaxInt()throws Exception{
        int result = myMain.maxInt(1, 3);
        assertEquals(3, result);
    }

    public void testAvgDouble() throws Exception{
        double dresult = (new myMain()).avgDouble(15, 45);
        assertEquals(30., dresult);
    }

}
