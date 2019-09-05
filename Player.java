/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author richycastro
 */
public class Player {
    //describes the players number in the tic tac toe game
    String playerNumber;
    
    int numOfSquares= 0;
       /*
    Boolean variables will be used to detect whether a board space is marked with a player's "X" or "Y".
    */
    boolean canWin = false, winner = false, rec1Marked = false, rec2Marked = false, rec3Marked = false, rec4Marked = false, rec5Marked = false,
    rec6Marked = false, rec7Marked = false, rec8Marked= false, rec9Marked = false;

    String returnText;
    //constructor
    Player(String playerNumber){

        this.playerNumber= playerNumber;

    }
    //sets the players mark for the Tic Tac Toe game
    void setMark(String mark){

        returnText= mark;

    }

    Text makeMove(Rectangle rec){
        //creates text object that will be the players symbol for the game
        Text newSquare= new Text(returnText);
        //customizes the font of the text to the games settings
        newSquare.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 200));

        newSquare.setFill(Color.PURPLE);
        /*
        retrieves the rectangles which was clicked and its positioning
        to set the players symbol at the same position
        */
        newSquare.setX(rec.getX()+ 60);

        newSquare.setY(rec.getY()+150);
        //returns the players symbol to replace the rectangle that was clicked on
        return newSquare;

    }
    
    void searchForWin(){
        
        if(canWin== true){
            
            if((rec1Marked== true) && (rec2Marked == true) && (rec3Marked == true))
                
                winner= true;
            
            else if((rec4Marked == true) && (rec5Marked== true) && (rec6Marked== true)){
                
                winner= true;
                
            }
            
            else if((rec7Marked == true) && (rec8Marked == true) && (rec9Marked == true)){
                
                winner= true;
            }
                
            else if((rec1Marked == true) && (rec4Marked== true)&& (rec7Marked== true)){
                
                winner= true;
                
            }
            
            else if((rec2Marked == true)&& (rec5Marked == true)&& (rec8Marked== true)){
                
                winner= true;
                
            }
            
            else if((rec3Marked == true)&& (rec6Marked == true)&& (rec9Marked == true)){
                
                winner= true;
                
            }
            
            else if((rec1Marked == true)&& (rec5Marked == true) && (rec9Marked == true)){
                
                winner= true;
                
            }
            
            else if((rec3Marked == true)&& (rec5Marked== true)&& (rec7Marked== true)){
                
                winner= true;
                
            }
            
        }
        
    }
    
    void canWinCheck(){
        
        if(numOfSquares >= 3)
            
        canWin =true;    
        
    }

}
