package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/2.
 */
class Judge extends Back{
    private static int turn = 0;                            //0 is red
    private static int nowI, nowJ;


    public Judge(){

    }

    public static int whosTurn(){
        return turn;
    }

    public static void setTurn(){
        turn = turn ^ 1;
    }

    public static int getNowchoose(int i, int j){
        nowI = i;
        nowJ = j;
        log.println("color is " + board[i][j] + " number is " + number[i][j]);
        return board[i][j];
    }
    
}
