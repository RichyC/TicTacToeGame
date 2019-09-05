/*
This Tic Tac Toe game is created to update and improve Tic Tac Toe Version1 created by Richy Eduardo Castro.
Tic Tac Toe Version1 was created when Richy was in his early time of programming. Now, Richy has obtained an Associate
Of Science Degree in Computer Science and wishes to improve upon his first version by applying his newly practiced
skills of conventional programming practices. Thanks for Playing

Comments reference lower programming statements
*/

package TicTacToe;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TicTacToeV2 extends Application{
    
    //player object keep track of player progress throughout the game
    Player player1= new Player("Player One");
    //winningAnimation is object which will project the winning animation
    //as of right not, it will only print a string
    //subject to update to an animation across the screen
    EndGameAnimation winningAnimation= new EndGameAnimation();
    //player object keeps track of player progress throughout the game
    Player player2= new Player("Player Two");
    //boolean variables that tells whether the game is running, which player's turn it is, and if there is a winner
    boolean gameON= false, player1ON= true, player2ON= false, winnerWasFound= false;
    //string to represent players symbol 
    String o = "O";
    //string to represent players symbol      
    String x = "X";


    public static void main(String[] args){
        //launches javafx application
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage){
      //stage created for menu pane which will have quit button and
      //displayer which player's turn the game is currently on.
      Stage menuStage= new Stage();
      /*
      introStage is the stage for the pane which will give the player
      an option to choose which symbol they desire to use throughout
      gameplay. Name "intro" stage because it is the initial stage
      which will appear before menu and tic tac toe board appears.
      */
      Stage introStage= new Stage();
      //IntroWinder object  
      IntroWindow introScreen= new IntroWindow();
      //position button on introwindow
      introScreen.chooseMark.setAlignment(Pos.BOTTOM_CENTER);
      //sets spacing for the introwindow buttons
      introScreen.chooseMark.setSpacing(5);
      //scene for intro window
      Scene introScene= new Scene(introScreen.thisFlowPane, 300, 150);
      //sets title for introwindow
      introStage.setTitle("Tic Tac Toe");
      //sets scene for introwindow
      introStage.setScene(introScene);
      //sets title for primary tic tac toe window
      primaryStage.setTitle("Tic Tac Toe");
      //Disable window resizing
      primaryStage.setResizable(false);
      //sets width of the button to choose the "x" symbol in the intro window
      introScreen.xButton.setPrefWidth(100);
      //sets the action event for a player clicking the "x" button
      introScreen.xButton.setOnAction(e -> {
          //uses player classes set mark method to set player's symbol
          player2.setMark(x);
          
          player1.setMark(o);
          //uses boolean variables to start the game
          player1ON= true;
          
          gameON= true;
          
          introStage.close();
          
          menuStage.show();
          
      });
      //sets the width of the "y" button in the intro window
      introScreen.yButton.setPrefWidth(100);
      //sets the action event of clicking the "Y" button
      introScreen.yButton.setOnAction(e2 -> {
          //uses player classes set mark method to set player's symbol
          player2.setMark(o);
          
          player1.setMark(x);
          //uses boolean variables to start the game
          player1ON= true;
          
          gameON= true;
          
          introStage.close();
          
          menuStage.show();
          
      });
      //sets title for menu stage
      menuStage.setTitle("Game Status");
      //constructs menuWindow object which will be the menu window for the game
      MenuWindow menuBox= new MenuWindow();
      
      menuBox.menuVbox.setSpacing(10);
      //sets the action event for the quit button in the menu window
      menuBox.quitButton.setOnAction(e10 ->{
          
          System.exit(0);
          
      });
      //pane for menuWindow
      FlowPane menuPane= new FlowPane(menuBox.menuVbox);
      
      menuPane.setAlignment(Pos.CENTER);
      
      Scene menuWindowScene= new Scene(menuPane, 300 , 150);
      
      menuStage.setScene(menuWindowScene);
        //constructs TicTacToeBoard object
        TicTacToeBoard GameBoard = new TicTacToeBoard();
        //sets main scene to the gameboard
        Scene scene= new Scene(GameBoard.GameBoardPane, 750, 600);
        
        primaryStage.setScene(scene);
        //sets title for primary stage
        primaryStage.setTitle("Tic Tac Toe V2");
        /*
        The following statements set the actions events that will occur once 
        a player clicks on a board space (or Rectangle object in Java terms)
        */
        GameBoard.rec1.setOnMouseClicked(e -> {
          
          if(player1.rec1Marked== false && player2.rec1Marked== false)
          {
          GameBoard.rec1.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec1));
          
              player1.rec1Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();
                  
                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec1));
              
              player2.rec1Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();
                  
                  if(player2.winner){
          
          GameBoard.GameBoardPane.getChildren().clear();
                      
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
          
          }
              
              menuBox.switchPlayer();
          
          }
          
          switchPlayer();
          
          }
      
      });
      
      GameBoard.rec2.setOnMouseClicked(e2 ->{
          
          if(player1.rec2Marked== false && player2.rec2Marked== false)
          {
          
          GameBoard.rec2.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec2));
          
              player1.rec2Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();
                  
                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec2));
              
              player2.rec2Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();
                  
                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }

          
          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          }
      });
      
      GameBoard.rec3.setOnMouseClicked(e3 -> {
          
          if(player1.rec3Marked== false && player2.rec3Marked== false)
          {
          
          GameBoard.rec3.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec3));
          
              player1.rec3Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();
                  
                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec3));
              
              player2.rec3Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();

                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
          
          
      }

          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          
          } 
      });
      
      GameBoard.rec4.setOnMouseClicked(e4 -> {
          if(player1.rec4Marked== false && player2.rec4Marked== false)
          {
          
          GameBoard.rec4.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec4));
          
              player1.rec4Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();

                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec4));
              
              player2.rec4Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();

                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }

          
          }
              
              menuBox.switchPlayer();
          
          }
          
          switchPlayer();
          
          }
      });
      
      GameBoard.rec5.setOnMouseClicked(e5 -> {
          
          if(player1.rec5Marked== false && player2.rec5Marked== false)
          {
          GameBoard.rec5.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec5));
          
              player1.rec5Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();
                  
                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec5));
              
              player2.rec5Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();
         
                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
                  
          
          }
              
              menuBox.switchPlayer();
          
          }
          
          switchPlayer();
          
          }
      });
      
      GameBoard.rec6.setOnMouseClicked(e6 -> {
          if(player1.rec6Marked== false && player2.rec6Marked== false)
          {
          GameBoard.rec6.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec6));
          
              player1.rec6Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();

                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec6));
              
              player2.rec6Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();
                 
                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
                  

          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          
          }  
      });
      
      GameBoard.rec7.setOnMouseClicked(e7 -> {
          if(player1.rec7Marked== false && player2.rec7Marked== false)
          {
          GameBoard.rec7.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec7));
          
              player1.rec7Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();

                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec7));
              
              player2.rec7Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();
                  
                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
                  
          
          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          
          }  
          
          
      });
      
      GameBoard.rec8.setOnMouseClicked(e8 -> {
          if(player1.rec8Marked== false && player2.rec8Marked== false)
          {
          GameBoard.rec8.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec8));
          
              player1.rec8Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();
                  
                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec8));
              
              player2.rec8Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();

                  if(player2.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }

          
          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          
          }   
      });
      
      GameBoard.rec9.setOnMouseClicked(e9 -> {
          if(player1.rec9Marked== false && player2.rec9Marked== false)
          {
          GameBoard.rec9.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec9));
          
              player1.rec9Marked = true;
              
              player1.numOfSquares++;
              
              player1.canWinCheck();
              
              if (player1.canWin == true){
                  
                  player1.searchForWin();

                  if(player1.winner){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec9));
              
              player2.rec9Marked= true;
              
              player2.numOfSquares++;
          
              player2.canWinCheck();
              
              if (player2.canWin == true){
                  
                  player2.searchForWin();

                  if(player2.winner){
          
          GameBoard.GameBoardPane.getChildren().clear();
                      
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
          
          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          } 
          
      });
      
      primaryStage.show();
      
      introStage.show();

    }
    
    void switchPlayer(){
        
        if(player1ON==true)
            
            player1ON = false;
        
        else if(player1ON==false)
            
            player1ON= true;
        
        if(player2ON==true)
            
            player2ON= false;
        
        else if(player2ON == false)
            
            player2ON= true;
        
    }


}

/*
MenuWindow class is the object which describes which player's turn
by printing player 1 or player 2 on the window. MenuWindow is contolled through
the TicTacToeV2 main class
*/

class MenuWindow{
        
        VBox menuVbox= new VBox();
        
        Text whosPlaying= new Text("Who's Playing?");
        
        Text player1= new Text("Player 1");
        
        Text player2= new Text("Player 2");
        
        Button quitButton= new Button("Quit");
        
        MenuWindow(){
            
        whosPlaying.setFill(Color.RED);
        
        player1.setFill(Color.RED);
        
        player1.setVisible(true);
        
        player2.setFill(Color.RED);
        
        player2.setVisible(false);
        
        quitButton.setPrefWidth(100);
        
        menuVbox.getChildren().addAll(whosPlaying, player1, player2, quitButton);
        
        menuVbox.setAlignment(Pos.CENTER);
            
        }
        
        void switchPlayer(){
            
            if(player1.isVisible()== true){
                
                player1.setVisible(false);
                
                player2.setVisible(true);
            
        }
            
            else if(player2.isVisible()== true){
                
                player1.setVisible(true);
                
                player2.setVisible(false);
                
            }
            
            
        }
        
    }

/*
IntroWindow is the window that initiates the game by prompting 
a player to choose his or her symbol as "X" or "O".
*/

class IntroWindow extends FlowPane{
    
    FlowPane thisFlowPane= new FlowPane();
    
    Button xButton= new Button("X");
    //accidently wrote "y" instead of "o"
    Button yButton= new Button("O");
    
    HBox chooseMark= new HBox(xButton, yButton);
    
    IntroWindow(){
        
    thisFlowPane.setOrientation(Orientation.VERTICAL);
    
    thisFlowPane.setAlignment(Pos.CENTER);
    
    thisFlowPane.setVgap(10);
        
    Text introText= new Text("Player 2, choose your mark as \"X\" or \"O\"");
        
    introText.setFill(Color.RED);
    
    thisFlowPane.getChildren().addAll(introText, chooseMark);
    
    }
    
}

class EndGameAnimation{
    
    boolean animationRunning= false;
    
    EndGameAnimation(){
        
        
    }
    
    Text giveWinningBanner(String playerNumber){
        
        Text playerWhoWon= new Text(playerNumber+" Wins");
        
        playerWhoWon.setFont(Font.font("Al tarikh", FontWeight.BOLD, FontPosture.REGULAR, 80));
        
        playerWhoWon.setFill(Color.RED);
        
        playerWhoWon.setY(300);
        
        playerWhoWon.setX(90);
        
        return playerWhoWon;
        
    }
    
}
