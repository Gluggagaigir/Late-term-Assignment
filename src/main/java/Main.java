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
import java.io.*;
import java.util.*;

import static spark.Spark.*;

public class Main {
    
    static Scanner reader = new Scanner(System.in);

  public static void main(String[] args) {
        //Variables
        
        char[] field = new char[9];
        fillField(field);

        char player1 = 'X';
        char player2 = 'O';
        int[] turn = {1};
        Boolean[] gameOver = {false};

        port(getHerokuPort());

        get("/", (req, res) -> {

            char winner = checkWinConditions(field);
            if(winner == player1){
                gameOver[0] = true;
                return printField(field, player1, true);
            } else if(winner == player2){
                gameOver[0] = true;
                return printField(field, player2, true);
            }


            if(turn[0] == 10){
                return printField(field, ' ', true);
            }

            return printField(field, ' ', false);
        });

        get("/:number", (req, res) -> {
            if(req.params(":number").equals("95346581359763116548")){
              turn[0] = 1;
              fillField(field);
              res.redirect("/");
              return null;
            }
            if(gameOver[0] == true){
              res.redirect("/");
              gameOver[0] = false;
              return null;
            }

            boolean valid = true;
            if (turn[0] % 2 == 1) {
                valid = findAndPlaceInField(player1, req.params(":number"), field);
            }
            else {
                valid = findAndPlaceInField(player2, req.params(":number"), field);
            }
            if (valid) {
                turn[0] = turn[0] + 1;
                res.redirect("/");
                return null;
            }
            else {
                return "Invalid number";
            }
        });

        /*get("/reset", (req, res) -> {
            turn[0] = 1;
            fillField(field);
            res.redirect("/");
            return null;
        });*/
    }

    static int getHerokuPort() {
        ProcessBuilder psb = new ProcessBuilder();
        if (psb.environment().get("PORT") != null) {
            return Integer.parseInt(psb.environment().get("PORT"));
        }
        return 4567;
    }

    public static void fillField(char[]field){
        for(int i = 0; i < 9; i++){
          field[i] = ' ';
        }
    }


    public static String printField(char[] field, char player, boolean quit){
        return readFile(field, player, quit);
    }

    public static Boolean findAndPlaceInField(char player, String tempNum, char[] field){
        int index = Character.getNumericValue(tempNum.charAt(0))-1;
        if(field[index] != 'X' && field[index] != 'O'){
            field[index] = player;
            return true;
        }
        return false;
    }

    private static Scanner x;

    public static void openFile(){
      try{
        x = new Scanner(new File("src/ratpack/templates/index.html"));
      }
      catch(Exception e){
          System.out.println("Bugg");
      }
    }

    public static void closeFile() {
      x.close();
    }


    public static String readFile(char[] field, char player, boolean quit){
      openFile();
      String ret = "";

      int index = 0;
      while(x.hasNext()){
        String next = x.next();
        ret = ret + " " + next;

        if(quit == true){
          if(next.equals("class=\"message\">")){
            if(player != ' '){
              ret = ret + player + " WON!" + x.next();
            }
            else{
               ret = ret + "Draw!!" + x.next();
            }
          }
        }
        if(next.equals("id")){
          if(index < 9){
             ret = ret + x.next() + field[index] + x.next();
             index++;
          }
          else{
             ret = ret + x.next() + 'F' + x.next();
          }
        }
      }
      closeFile();
      return ret;
    }

    public static char checkWinConditions(char[] field){
        //Láréttar línur
        if(field[0] == 'X'  && field[1] == 'X' && field[2] == 'X'){
            //Efst lágrétt
            return 'X';
        }else if(field[3] == 'X' && field[4] == 'X' && field[5] == 'X'){
            //Miðja lárétt
            return 'X';
        }else if(field[6] == 'X' && field[7] == 'X' && field[8] == 'X'){
            //Neðst lárétt
            return 'X';
        }else if(field[0] == 'X' && field[3] == 'X' && field[6] == 'X'){
            //Vinstri lóðrétt
            return 'X';
        }else if(field[1] == 'X' && field[4] == 'X' && field[7] == 'X'){
            //Miðja lóðrétt
            return 'X';
        }else if(field[2] == 'X' && field[5] == 'X' && field[8] == 'X'){
            //Hægri lóðrétt
            return 'X';
        }else if(field[0] == 'X' && field[4] == 'X' && field[8] == 'X'){
            //Kross niður til vinstri
            return 'X';
        }else if(field[6] == 'X' && field[4] == 'X' && field[2] == 'X'){
            //kross upp til vinstri
            return 'X';
        }

          if(field[0] == 'O'  && field[1] == 'O' && field[2] == 'O'){
            //Efst lágrétt
            return 'O';
        }else if(field[3] == 'O' && field[4] == 'O' && field[5] == 'O'){
            //Miðja lárétt
            return 'O';
        }else if(field[6] == 'O' && field[7] == 'O' && field[8] == 'O'){
            //Neðst lárétt
            return 'O';
        }else if(field[0] == 'O' && field[3] == 'O' && field[6] == 'O'){
            //Vinstri lóðrétt
            return 'O';
        }else if(field[1] == 'O' && field[4] == 'O' && field[7] == 'O'){
            //Miðja lóðrétt
            return 'O';
        }else if(field[2] == 'O' && field[5] == 'O' && field[8] == 'O'){
            //Hægri lóðrétt
            return 'O';
        }else if(field[0] == 'O' && field[4] == 'O' && field[8] == 'O'){
            //Kross niður til vinstri
            return 'O';
        }else if(field[6] == 'O' && field[4] == 'O' && field[2] == 'O'){
            //kross upp til vinstri
            return 'O';
        }
        
        //Skilar þessu til að vita að enginn er búinn að vinna
        return '5';
    }

}