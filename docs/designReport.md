### Háskólinn í Reykjavík
### Haust 2017
### Gluggagæir
# Design Report

In this project we will practice setting up the infrastructure for agile development of the game Tic Tac Toe. Our team will be using github for source control, Heroku to run the game as a web app and Travis as our continuous integration server.

### Class Diagram

<img src="https://i.imgur.com/TnfziRG.png">

#### Functions in the TicTacToe class

**public static boolean fillField();**

This function creates a field with the numbers one to nine in a three by three grid. This makes it easy for the users to pick the field which they would like to pick.

**public static String printField(char[][] field);**

This function prints the field with neat lines in between.

**public static Boolean findAndPlaceInField(String player, String tempNum, char[][] field);**

This function places the sign (player) into the correct field (tempNum) of the field (field). It will return true if it’s unoccupied, or else false.

**public static char checkWinConditions(char[][]field);**

This function checks for a winner, and returns their sign if there is, else it returns something else to tell the programme that there is no winner as of yet.


### Programming Rules

##### Java:
* Variables, functions and other name giving should be written in English.
* Functions and loops should use "Egyptian style" for curly brackets. E.g.

```java
if(winner == true) {
	doStuff();
}
```

* Variables and functions should use Camel Casing. E.g.
```java
int camelCaseVariable = 1; ```
```
 
* Classes should use Pascal Case. E.g
```java 
public class PascalCaseClass {
...
}
```

* Comments for functions should be one line above the function
* Comments for individual lines of code should be made one line above.

### Nöfn og tölvupóstfang allra í teyminu
- Bjarki Kjartansson - Bjarkik16@ru.is
- Daníel Emil Sigurðsson - Daniels15@ru.is
- Jakob Örn Guðnason - Jakobog16@ru.is
- Jóhann Þorvaldsson - Johannt15@ru.is
- Margrét Kristín Björnsdóttir - Margretw16@ru.is
- Smári N. Guðmundsson - Smaring16@ru.is
- Tryggvi Bragason - Tryggvib15@ru.is
