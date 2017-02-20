package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;


import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/2.
 */
class Back {
    StackPane sp;
    Rectangle chess;
    DoubleProperty width = new SimpleDoubleProperty(40);
    DoubleProperty height = new SimpleDoubleProperty(40);
    IntegerProperty color = new SimpleIntegerProperty(-1);
    Label num = new Label("1");
    static GridPane gp = new GridPane();
    //0 is white  1 is red  2 is blue
    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;
    static Integer red = 1, blue = 1;
    static int board[][] = new int[5][5];                                      //record chessboard
    static int number[][] = new int [5][5];                                    //record number of chess
    static int turn = 1;                            //1 is red  2 is blue
    static int fromI = -1, fromJ = -1, toI = -1, toJ = -1;
    static Label tempnum;
    static Rectangle tempchess;

    public Back(){

    }

    public void setBoard(){
        board[toI][toJ] = board[fromI][fromJ];
        number[toI][toJ] = number[fromI][fromJ];
        board[fromI][fromJ] = 0;
        number[fromI][fromJ] = 0;
    }

}
