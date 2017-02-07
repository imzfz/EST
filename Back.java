package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    static int color = -1;

    public Back(){

    }

    public static void setBoard(){
        board[fromI][fromJ] = board[toI][toJ];
    }

    public static void setColor(int c){
        color = c;
        log.print("color = " + color);
    }

    public static int getColor(){
        return color;
    }


}
