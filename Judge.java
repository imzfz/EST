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

    public Judge(){

    }

    /**
     * 返回当前回合
     */
    public static int whosTurn(){
        return turn;
    }

    /**
     * 改变回合
     */
    public static void setTurn(){
        turn = turn == 1 ? 2 : 1;
    }

    /**
     *获取from的信息
     */
    public static int getFrom (int i, int j){
        if(whosTurn() == board[i][j]) {
            fromI = i;
            fromJ = j;
            log.println("from color is " + board[i][j] + " number is " + number[i][j]);
        }
        return board[i][j];
    }

    /**
     *获取to的信息
     */
    public static int getTo(int i, int j){
        toI = i;
        toJ = j;
        log.println("to color is " + board[i][j] + " number is " + number[i][j]);
        return board[i][j];
    }

    /**
     * 判断是否可以移动 并且初始化from和to 交换turn
     */
    public static boolean move(){
        if(canMove()){
            log.println("from: (" + fromI + " " + fromJ + ")");
            log.println("to: (" + toI + " " + toJ + ")");
            log.println("success!");
            setTurn();
            return true;
        }
        return false;
    }

    /**
     *判断是否在本回合获取了正确的from和to点坐标
     */
    public static boolean canMove() {
        boolean conditionRed = (toI == fromI + 1 && (toJ == fromJ + 1 || toJ == fromJ)) || (toJ == fromJ + 1 && ((toI == fromI + 1 || toI == fromI)));
        boolean conditionBlue = (toI == fromI - 1 && (toJ == fromJ - 1 || toJ == fromJ)) || (toJ == fromJ - 1 && ((toI == fromI - 1 || toI == fromI)));
        boolean allRight = !(fromI == -1 || fromJ == -1 || toI == -1 || toJ == -1);

        if (allRight) {
            if (conditionRed && whosTurn() == 1) {
                log.print("set color success");
                return true;
            }

            else if (conditionBlue && whosTurn() == 2) {
                return true;
            }

            else{
                log.print("error");
                fromI = -1;
                fromJ = -1;
                toI = -1;
                toJ = -1;
            }
        }
        return false;
    }

    public static int getFromI() {
        return fromI;
    }

    public static int getFromJ() {
        return fromJ;
    }

    public static int getToI() {
        return toI;
    }

    public static int getToJ() {
        return toJ;
    }
}
