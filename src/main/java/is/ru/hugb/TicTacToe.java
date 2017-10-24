/*
VERKEFNI
Búa til og fylla völlinn
Búa til breytur
Spilari velur X eða O
LEIKURINN SPILADUR 
Spilari 1 velur stað fyrir sitt merki
Spilari 2 velur stað fyrir sitt merki
Ef spilari vinnur, er leik lokið
Ef enginn vann er spilað aftur*/

package is.ru.hugb;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
        //Variables
        char[][] field = new char[3][3];
        Boolean fieldFull = fillField(field);
        if(fieldFull == false){
            //TODO -- throw exception
        }
        String player1 = "";
        String player2 = "";
        int turn = 0;
        Boolean gameOver = false;
    
    }


    public static Boolean fillField(char[][] field){
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = (char) (counter+48);
                counter++;
                return true;
            }
        }
    return false;
    }
}