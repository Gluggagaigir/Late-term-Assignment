### Háskólinn í Reykjavík
### Fall 2017
### Gluggagæir

# Administration Manual

In this manual we will go through how to set up and run on a fresh machine. Also how to run and maintain as a web application.


### Deploy run and maintain

When deploying and running the project you need to follow these steps.
* Sign into [github.com](https://github.com) with your github account
* Fork and clone this project to your computer [github.com](https://github.com/Gluggagaigir/Late-term-Assignment)
* Install java JDK 1.8 
* Install Gradle by following the instructions at [Gradle install page](https://gradle.org/install/)
* Sign into [travis-ci.org](https://travis-ci.org/) with your github account
* Sign into [heroku.com](https://heroku.com) with your github account
* Install any web application

When you push your code to github Travis CI builds the code. If it doesn’t find any problems it pushes it to the Heroku server.

### How to run the game
* Go on your local drive on your computer 
* Navigate to the root of the directory of the repository
* Run the program with
```
$ ./gradlew clone build run
```
* The server is running on your localhost under port 4567 . Open any web browser and type the URL: http://localhost:4567/ 


### How to play the game

The game is hosted at http://gluggagaigir-staging.herokuapp.com/
The game is between two people, the first player is X and second is O
Click on a empty space on the board to place your token on the board.
X is always first
First player to place three in a row wins, either horizontally, vertically or diagonally.
When the game is over you can click on reset to reset the game.

### Names and emails of team members
- Bjarki Kjartansson - Bjarkik16@ru.is
- Daníel Emil Sigurðsson - Daniels15@ru.is
- Jakob Örn Guðnason - Jakobog16@ru.is
- Jóhann Þorvaldsson - Johannt15@ru.is
- Margrét Kristín Björnsdóttir - Margretw16@ru.is
- Smári N. Guðmundsson - Smaring16@ru.is
- Tryggvi Bragason - Tryggvib15@ru.is
