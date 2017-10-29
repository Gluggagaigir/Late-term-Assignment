package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class TicTacToeTest {

    @Test
    public void testFillField(){
        char[] insertField = new char[9];

        assertEquals(true, TicTacToe.fillField(insertField));
    }


    @Test
    public void testValidInput(){
        //Setup
        char[] insertField = new char[9];
        for(int i = 0; i < 9; i++){
                insertField[i] = ' ';
        }
        assertEquals(true, TicTacToe.findAndPlaceInField('X', "4", insertField));
    }

    @Test
    public void testInputAlreadyInPlace(){
        //Setup
        char[] insertField = new char[9];
        for(int i = 0; i < 9; i++){
                insertField[i] = ' ';
        }
        insertField[0] = 'X';
        assertEquals(false, TicTacToe.findAndPlaceInField('X', "1", insertField));
    }

    public void testInputBiggerThan8(){
        //Setup
        char[] insertField = new char[9];
        for(int i = 0; i < 9; i++){
                insertField[i] = ' ';
        }
        assertEquals(false, TicTacToe.findAndPlaceInField('X', "43", insertField));
    }

     public void testNonNumericInput(){
        //Setup
        char[] insertField = new char[9];
        for(int i = 0; i < 9; i++){
                insertField[i] = ' ';
        }
        assertEquals(false, TicTacToe.findAndPlaceInField('X', "f", insertField));
    }



    @Test
    public void testCheckWinConditions(){
        char[] insertField = new char[9];
        insertField[0] = 'X';
        insertField[1] = 'X';
        insertField[2] = 'X';

        char[] insertField1 = new char[9];

        char[] insertField2 = new char[9];
        insertField2[0] = 'O';
        insertField2[1] = 'O';
        insertField2[2] = 'O';

        assertEquals('X', TicTacToe.checkWinConditions(insertField));
        assertEquals('5', TicTacToe.checkWinConditions(insertField1));
    }

    @Test
    public void testStringInput(){
        assertEquals(false, TicTacToe.checkStringInput("52"));
    }

    @Test
    public void testStringInput2(){
        assertEquals(false, TicTacToe.checkStringInput("f"));
    }

     @Test
    public void testStringInput3(){
        assertEquals(true, TicTacToe.checkStringInput("5"));
    }

    @Test
    public void testOpenFile(){
          assertEquals(true, TicTacToe.openFile());
    }

    @Test
    public void tsetCloseFile(){
          assertEquals(true, TicTacToe.closeFile());
    }
}
