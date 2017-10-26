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
            System.out.println("Field not full");
            return;
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
        while(true){
            turn++;
            printField(field);
            if(turn%2 == 1){
                while(true){
                    String tempString = "";
                    System.out.println(player1 + " pick a number to play: ");
                    tempString = reader.next();
                    //ToDO: Validate'a strenginn
                    Boolean found = findAndPlaceInField(player1, tempString, field);
                    if(found){
                        break;
                    }
                    System.out.println("You picked " + tempString + ". Please pick number in the field");
                }
            } else {
                while(true){
                    String tempString = "";
                    System.out.println(player2 + " pick a number to play: ");
                    tempString = reader.next();
                    Boolean found = findAndPlaceInField(player2, tempString, field);
                    if(found){
                        break;
                    }
                    System.out.println("Pick an empty field");
                }
            }

            char winner = checkWinConditions(field);
            if(winner == player1.charAt(0)){
                gameOver = true;
                System.out.println(player1 + " won!!!!");
                printField(field);
            } else if(winner == player2.charAt(0)){
                gameOver = true;
                System.out.println(player1 + " won!!!!");
                printField(field);
            }

            if(gameOver){
                break;
            }

            if(turn == 9){
                System.out.println("DRAW!!!");
                System.out.println("Game is restarting");
                turn = 0;
                fillField(field);
            }
        }
        reader.close();
    }


    public static Boolean fillField(char[][] field){
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = (char) (counter+48);
                counter++;
            }
        }
        return true;
    }

    public static String checkIfCorrectPlayer(String player1){
        if(player1.equals("x") || player1.equals("X")  ){
            return "X";
        } else if( player1.equals("o") || player1.equals("O")){
            return "O";
        }
        return player1;
    }

    public static void printField(char[][] field){
        System.out.println("-----");
        for(int i = 0; i < 3; i++){
            System.out.printf(field[i][0] + "|" + field[i][1] + "|" + field[i][2]);
            System.out.println("");
            System.out.println("-----");
        }
    }

    public static Boolean findAndPlaceInField(String player, String tempNum, char[][] field){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j] == tempNum.charAt(0)){
                    field[i][j] = player.charAt(0);
                    return true;
                }
            }
        }
        return false;
    }

    public static char checkWinConditions(char[][]field){
        //Láréttar línur
        if(field[0][0] == 'X'  && field[0][1] == 'X' && field[0][2] == 'X'){
            //Efst lágrétt
            return 'X';
        }else if(field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X'){
            //Miðja lárétt
            return 'X';
        }else if(field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X'){
            //Neðst lárétt
            return 'X';
        }else if(field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X'){
            //Vinstri lóðrétt
            return 'X';
        }else if(field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X'){
            //Miðja lóðrétt
            return 'X';
        }else if(field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X'){
            //Hægri lóðrétt
            return 'X';
        }else if(field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X'){
            //Kross niður til vinstri
            return 'X';
        }else if(field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X'){
            //kross upp til vinstri
            return 'X';
        }

        if(field[0][0] == 'O'  && field[0][1] == 'O' && field[0][2] == 'O'){
            //Efst lágrétt
            return 'O';
        }else if(field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O'){
            //Miðja lárétt
            return 'O';
        }else if(field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O'){
            //Neðst lárétt
            return 'O';
        }else if(field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O'){
            //Vinstri lóðrétt
            return 'O';
        }else if(field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O'){
            //Miðja lóðrétt
            return 'O';
        }else if(field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O'){
            //Hægri lóðrétt
            return 'O';
        }else if(field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O'){
            //Kross niður til vinstri
            return 'O';
        }else if(field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O'){
            //kross upp til vinstri
            return 'O';
        }
        //Skilar þessu til að vita að enginn er búinn að vinna
        return '5';
    }

}