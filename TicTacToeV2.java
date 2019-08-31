/*
This Tic Tac Toe game is created to update and improve Tic Tac Toe Version1 created by Richy Eduardo Castro.
Tic Tac Toe Version1 was created when Richy was in his early time of programming. Now, Richy has obtained an Associate
Of Science Degree in Computer Science and wishes to improve upon his first version by applying his newly practiced
skills of conventional programming practices. Thanks for Playing!
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
    
    //player objects keep track of player progress throughout the game
    Player player1= new Player("Player One");
    //
    EndGameAnimation winningAnimation= new EndGameAnimation();
    
    Player player2= new Player("Player Two");
    //boolean variables that tells whether the game is running, which player's turn it is, and if there is a winner
    boolean gameON= false, player1ON= true, player2ON= false, winnerWasFound= false;
    //string to represent players symbol 
    String o = "O";
          
    String x = "X";


    public static void main(String[] args){

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        
      Stage menuStage= new Stage();
        
      Stage introStage= new Stage();
        
      IntroWindow introScreen= new IntroWindow();
      
      introScreen.chooseMark.setAlignment(Pos.BOTTOM_CENTER);
    
      introScreen.chooseMark.setSpacing(5);
      
      Scene introScene= new Scene(introScreen.thisFlowPane, 300, 150);
      
      introStage.setTitle("Tic Tac Toe");
      
      introStage.setScene(introScene);
      
      primaryStage.setTitle("Tic Tac Toe");
      
      introScreen.xButton.setPrefWidth(100);
      
      introScreen.xButton.setOnAction(e -> {
          
          player2.setMark(x);
          
          player1.setMark(o);
          
          player1ON= true;
          
          gameON= true;
          
          introStage.close();
          
          menuStage.show();
          
      });
      
      introScreen.yButton.setPrefWidth(100);
      
      introScreen.yButton.setOnAction(e2 -> {
          
          player2.setMark(o);
          
          player1.setMark(x);
          
          player1ON= true;
          
          gameON= true;
          
          introStage.close();
          
          menuStage.show();
          
      });
      
      menuStage.setTitle("Game Status");
      
      MenuWindow menuBox= new MenuWindow();
      
      menuBox.menuVbox.setSpacing(10);
      
      menuBox.quitButton.setOnAction(e10 ->{
          
          System.exit(0);
          
      });
      
      FlowPane menuPane= new FlowPane(menuBox.menuVbox);
      
      menuPane.setAlignment(Pos.CENTER);
      
      Scene menuWindowScene= new Scene(menuPane, 300 , 150);
      
      menuStage.setScene(menuWindowScene);
        
        TicTacToeBoard GameBoard = new TicTacToeBoard();
        Scene scene= new Scene(GameBoard.GameBoardPane, 750, 600);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Tic Tac Toe V2");
     
        GameBoard.rec1.setOnMouseClicked(e -> {
          
          if(player1.ifWins.rec1Marked== false && player2.ifWins.rec1Marked== false)
          {
          GameBoard.rec1.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec1));
          
              player1.ifWins.rec1Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec1));
              
              player2.ifWins.rec1Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
          
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
          
          if(player1.ifWins.rec2Marked== false && player2.ifWins.rec2Marked== false)
          {
          
          GameBoard.rec2.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec2));
          
              player1.ifWins.rec2Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec2));
              
              player2.ifWins.rec2Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          
          if(player1.ifWins.rec3Marked== false && player2.ifWins.rec3Marked== false)
          {
          
          GameBoard.rec3.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec3));
          
              player1.ifWins.rec3Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec3));
              
              player2.ifWins.rec3Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          if(player1.ifWins.rec4Marked== false && player2.ifWins.rec4Marked== false)
          {
          
          GameBoard.rec4.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec4));
          
              player1.ifWins.rec4Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec4));
              
              player2.ifWins.rec4Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          
          if(player1.ifWins.rec5Marked== false && player2.ifWins.rec5Marked== false)
          {
          GameBoard.rec5.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec5));
          
              player1.ifWins.rec5Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec5));
              
              player2.ifWins.rec5Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          if(player1.ifWins.rec6Marked== false && player2.ifWins.rec6Marked== false)
          {
          GameBoard.rec6.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec6));
          
              player1.ifWins.rec6Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec6));
              
              player2.ifWins.rec6Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          if(player1.ifWins.rec7Marked== false && player2.ifWins.rec7Marked== false)
          {
          GameBoard.rec7.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec7));
          
              player1.ifWins.rec7Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec7));
              
              player2.ifWins.rec7Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player2.playerNumber));
          
      }
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  System.out.println(player2.ifWins.canWin);
                  
                  System.out.println(player2.ifWins.winner);
          
          }
              
              menuBox.switchPlayer();
              
          }
          
          switchPlayer();
          
          }  
          
          
      });
      
      GameBoard.rec8.setOnMouseClicked(e8 -> {
          if(player1.ifWins.rec8Marked== false && player2.ifWins.rec8Marked== false)
          {
          GameBoard.rec8.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec8));
          
              player1.ifWins.rec8Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }

              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec8));
              
              player2.ifWins.rec8Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
                      
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
          if(player1.ifWins.rec9Marked== false && player2.ifWins.rec9Marked== false)
          {
          GameBoard.rec9.toBack();
          
          if(player1ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player1.makeMove(GameBoard.rec9));
          
              player1.ifWins.rec9Marked = true;
              
              player1.ifWins.numOfSquares++;
              
              player1.ifWins.canWinCheck();
              
              if (player1.ifWins.canWin == true){
                  
                  player1.ifWins.searchForWin();
                  
                  winnerWasFound= player1.ifWins.winner;
                  
                  if(winnerWasFound){
                      
          GameBoard.GameBoardPane.getChildren().clear();
          
          GameBoard.GameBoardPane.getChildren().add(winningAnimation.giveWinningBanner(player1.playerNumber));
          
      }
                  
                  
              }
              
              menuBox.switchPlayer();
              
          }
          
          else if(player2ON == true){
              
              GameBoard.GameBoardPane.getChildren().add(player2.makeMove(GameBoard.rec9));
              
              player2.ifWins.rec9Marked= true;
              
              player2.ifWins.numOfSquares++;
          
              player2.ifWins.canWinCheck();
              
              if (player2.ifWins.canWin == true){
                  
                  player2.ifWins.searchForWin();
                  
                  winnerWasFound= player2.ifWins.winner;
                  
                  if(winnerWasFound){
          
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
