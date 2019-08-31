package TicTacToe;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TicTacToeBoard extends GameBoard {

    
    int numOfSquares= 0;
    
    /*
    X lines are vertical lines starting from left to right.
    line1X is the vertical line farthest to the left.
    line4X is the vertical line farthest to the right.
     */
    Line line1X= new Line();

    Line line2X= new Line();

    Line line3X= new Line();

    Line line4X= new Line();

    /*
    Y lines are horizontal lines starting from up to down.
    Line1Y is the upper most horizontal line.
    Line4Y is the lower most horizontal line.
     */
    Line line1Y= new Line();

    Line line2Y= new Line();

    Line line3Y= new Line();

    Line line4Y= new Line();

    /*
    Each space is denoted as a rectangular area named recX where X is the number of the rectangular space on the board.
    Rectangular areas are read from left to right on each row.
    Rec1 is: first row + first column;  Rec3 is: first row + third column
    Rec4 is: second row +first column; Rec6 is: second row + third column
    . . .
     */
    Rectangle rec1 = new Rectangle (242, 178);

    Rectangle rec2= new Rectangle(248, 178);

    Rectangle rec3= new Rectangle(227, 178);

    Rectangle rec4= new Rectangle(240, 193);

    Rectangle rec5= new Rectangle(248, 193);

    Rectangle rec6= new Rectangle(227, 193);

    Rectangle rec7= new Rectangle(240, 188);

    Rectangle rec8= new Rectangle(250, 188);

    Rectangle rec9= new Rectangle(226, 188);

    /*
    GameBoardPane sets the imagery of the BoardGame.
    GameBoardPane will be where the game board is drawn.
    GameBoardPane Pane will be returned for the Scene Object of the JavaFX application.
     */
    Pane GameBoardPane= new Pane(line1X, line2X, line3X, line4X, line1Y, line2Y, line3Y, line4Y, rec1,
            rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9);

    //Default Constructor for TicTacToeBoard Class
    public TicTacToeBoard() {
        /*
        Refer to instantiation of variables for line locations
        Each line is repetitive with respect to its function
        setStroke sets the color of the line
        strokeWidth sets the thickness of the line
        startX and endX properties are applied to horizontal lines
        startY and endY properties are applied to vertical lines
         */

        line1X.setStroke(Color.PURPLE);

        line1X.setStrokeWidth(3.5);

        line1X.startXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));

        line1X.endXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));;

        line1X.startYProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(8))));

        line1X.endYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        line2X.setStroke(Color.PURPLE);

        line2X.setStrokeWidth(3.5);

        line2X.startXProperty().bind(GameBoardPane.widthProperty().divide(3).add(5));

        line2X.endXProperty().bind(GameBoardPane.widthProperty().divide(3).add(5));

        line2X.startYProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(8))));

        line2X.endYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        line3X.setStroke(Color.PURPLE);

        line3X.setStrokeWidth(3.5);

        line3X.startXProperty().bind((GameBoardPane.widthProperty().divide(3).add(5)).multiply(2));

        line3X.endXProperty().bind((GameBoardPane.widthProperty().divide(3).add(5)).multiply(2));

        line3X.startYProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(8))));

        line3X.endYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        line4X.setStroke(Color.PURPLE);

        line4X.setStrokeWidth(3.5);

        line4X.startXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line4X.endXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line4X.startYProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(8))));

        line4X.endYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        line1Y.setStroke(Color.PURPLE);

        line1Y.setStrokeWidth(3.5);

        line1Y.startXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));

        line1Y.endXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line1Y.startYProperty().bind(GameBoardPane.heightProperty().subtract(GameBoardPane.heightProperty().subtract(8)));

        line1Y.endYProperty().bind(GameBoardPane.heightProperty().subtract(GameBoardPane.heightProperty().subtract(8)));

        line2Y.setStroke(Color.PURPLE);

        line2Y.setStrokeWidth(3.5);

        line2Y.startXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));

        line2Y.endXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line2Y.startYProperty().bind(GameBoardPane.heightProperty().divide(3.25).add(8));

        line2Y.endYProperty().bind(GameBoardPane.heightProperty().divide(3.25).add(8));

        line3Y.setStroke(Color.PURPLE);

        line3Y.setStrokeWidth(3.5);

        line3Y.startXProperty().add(8);

        line3Y.startXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));

        line3Y.endXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line3Y.startYProperty().bind((GameBoardPane.heightProperty().divide(3.1).add(8)).multiply(1.975));

        line3Y.endYProperty().bind((GameBoardPane.heightProperty().divide(3.1).add(8)).multiply(1.975));

        line4Y.setStroke(Color.PURPLE);

        line4Y.setStrokeWidth(3.5);

        line4Y.startXProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(8)));

        line4Y.endXProperty().bind(GameBoardPane.widthProperty().subtract(8));

        line4Y.startYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        line4Y.endYProperty().bind(GameBoardPane.heightProperty().subtract(8));

        rec1.xProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(10)));

        rec1.yProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(10))));

        rec1.setFill(Color.WHITE);

        rec2.xProperty().bind(GameBoardPane.widthProperty().divide(3).add(7));

        rec2.yProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(10))));

        rec2.setFill(Color.WHITE);

        rec3.xProperty().bind((GameBoardPane.widthProperty().divide(3).add(6.2)).multiply(2));

        rec3.yProperty().bind(GameBoardPane.heightProperty().subtract((GameBoardPane.heightProperty().subtract(10))));

        rec3.setFill(Color.WHITE);

        rec4.xProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(10)));

        rec4.yProperty().bind(GameBoardPane.heightProperty().divide(3));

        rec4.setFill(Color.WHITE);

        rec5.xProperty().bind(GameBoardPane.widthProperty().divide(3).add(7));

        rec5.yProperty().bind(GameBoardPane.heightProperty().divide(3).add(1));

        rec5.setFill(Color.WHITE);

        rec6.xProperty().bind((GameBoardPane.widthProperty().divide(3).add(6.2)).multiply(2));

        rec6.yProperty().bind(GameBoardPane.heightProperty().divide(3).add(1));

        rec6.setFill(Color.WHITE);

        rec7.xProperty().bind(GameBoardPane.widthProperty().subtract(GameBoardPane.widthProperty().subtract(10)));

        rec7.yProperty().bind((GameBoardPane.heightProperty().divide(3).add(1)).multiply(2));

        rec7.setFill(Color.WHITE);

        rec8.xProperty().bind(GameBoardPane.widthProperty().divide(3).add(7));

        rec8.yProperty().bind((GameBoardPane.heightProperty().divide(3).add(1)).multiply(2));

        rec8.setFill(Color.WHITE);

        rec9.xProperty().bind((GameBoardPane.widthProperty().divide(3).add(6.5)).multiply(2));

        rec9.yProperty().bind((GameBoardPane.heightProperty().divide(3).add(1)).multiply(2));

        rec9.setFill(Color.WHITE);

    }

}
