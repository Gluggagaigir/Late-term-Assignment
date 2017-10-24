package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    char[][] insertField = new char[3][3];
    @Test
    public void testFillField(){
        char[][] insertField = new char[3][3];

        assertEquals(true, TicTacToe.fillField(insertField));
    }

    /*@Test
    public void testTwoNumbers(){
        assertEquals(3, Calculator.add("1,2"));
    }*/
}
