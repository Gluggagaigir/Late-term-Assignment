package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class TicTacToeTest {

    char[][] insertField = new char[3][3];

    @Test
    public void testFillField(){
        assertEquals(true, TicTacToe.fillField(insertField));
    }

    @Test
    public void testCheckIfCorrectPlayer(){
        String input = "x";
        assertEquals("X", TicTacToe.checkIfCorrectPlayer("x"));
    }

    /*@Test
    public void testTwoNumbers(){
        assertEquals(3, Calculator.add("1,2"));
    }*/
}
