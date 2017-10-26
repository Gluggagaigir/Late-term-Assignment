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

    @Test
    public void testCheckWinConditions(){
        char[][] insertField = new char[3][3];
        insertField[0][0] = 'X';
        insertField[0][1] = 'X';
        insertField[0][2] = 'X';

        char[][] insertField1 = new char[3][3];

        char[][] insertField2 = new char[3][3];
        insertField2[0][0] = 'O';
        insertField2[0][1] = 'O';
        insertField2[0][2] = 'O';

        assertEquals('X', TicTacToe.checkWinConditions(insertField));
        assertEquals('5', TicTacToe.checkWinConditions(insertField1));
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
