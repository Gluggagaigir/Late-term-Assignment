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
    
    static Scanner reader = new Scanner(System.in);

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
        
        //Open scanner

        //Choosing side
        System.out.println("Play as O or X"); // Display the string.
        while(true){
            player1 = reader.next();
            player1 = checkIfCorrectPlayer(player1);
            if(player1.equals("X")||player1.equals("O")){
                break;
            }else{
                System.out.println("You picked " + player1 + ". Please pick O or X");
            }
        }
        System.out.println("Thank you, you are playing as " + player1 );
        if(player1.equals("X")){
            player2 = "O";
        } else {
            player2 = "X";
        }
        
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
    public static String checkIfCorrectPlayer(String player1){
        if(player1.equals("x") || player1.equals("X")  ){
            return "X";
        } else if( player1.equals("o") || player1.equals("O")){
            return "O";
        }
        return player1;
    }
}