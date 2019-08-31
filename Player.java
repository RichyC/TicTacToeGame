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
    String playerNumber;
    
    TicTacToeBoard ifWins= new TicTacToeBoard();

    String returnText;

    Player(String playerNumber){

        this.playerNumber= playerNumber;

    }

    void setMark(String mark){

        returnText= mark;

    }

    Text makeMove(Rectangle rec){

        Text newSquare= new Text(returnText);

        newSquare.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 200));

        newSquare.setFill(Color.PURPLE);

        newSquare.setX(rec.getX()+ 60);

        newSquare.setY(rec.getY()+150);

        return newSquare;

    }

}
