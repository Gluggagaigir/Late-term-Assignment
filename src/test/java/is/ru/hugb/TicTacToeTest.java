package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class TicTacToeTest {
    
    @Test
    public void testFillField(){
        char[][] insertField = new char[3][3];

        assertEquals(true, TicTacToe.fillField(insertField));
    }

    @Test
    public void testCheckIfCorrectPlayer(){
        String input = "x";
        assertEquals("X", TicTacToe.checkIfCorrectPlayer("x"));
    }

    @Test
    public void testfindAndPlaceInField(){
        //Setup
        char[][] insertField = new char[3][3];
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                insertField[i][j] = (char) (counter+48);
                counter++;
            }
        }
        assertEquals(true, TicTacToe.findAndPlaceInField("x", "3", insertField));
    }

    /* Virkar ekki að testa System.out eða void :(
    @Test
    public void testPrintField(){
        //Setup
        char[][] insertField = new char[3][3];
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                insertField[i][j] = (char) (counter+48);
                counter++;
            }
        }

        assertEquals("-----\n1|2|3\n4|5|6\n7|8|9\n-----\n", TicTacToe.printField(insertField));
    } */


    /*@Test
    public void testTwoNumbers(){
        assertEquals(3, Calculator.add("1,2"));
    }*/
}
