package algo.chp1.bqstest;
import algo.chp1.bqs.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    /**
     * Test method for Stack
     */
    @Test
    public void testStack() throws BQSException {
        Stack<Integer> stack = new Stack_LinkedList<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        try {
            Integer item = stack.pop();
            assertEquals(item, new Integer(1));
        } catch (BQSException e) {
            throw e;
        }
    }

}
