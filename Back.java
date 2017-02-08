package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/2.
 */
class Back {
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
