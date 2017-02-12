package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/1.
 * 棋盘和棋子的属性
 */
class Chess extends Back{
    static GridPane gp = new GridPane();
    private StackPane sp;
    private Rectangle chess;
    //0 is white  1 is red  2 is blue
    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private DoubleProperty width = new SimpleDoubleProperty(40);
    private DoubleProperty height = new SimpleDoubleProperty(40);
    private IntegerProperty color = new SimpleIntegerProperty(-1);
    static Integer red = 1, blue = 1;
    private Label num = new Label("1");

    /**
     * begin
     */

    public Chess(){}

    /**
     * 初始化棋盘，注册响应事件
     */
    public Chess(int i, int j) {
        chess = new Rectangle();
        sp = new StackPane();
        chess.heightProperty().bind(height);
        chess.widthProperty().bind(width);
        setColorandnumber(chess, i, j);
        gp.add(sp, i, j);
        //line of rectangle
        gp.setStyle("-fx-grid-lines-visible:true");
        sp.setOnMouseClicked(e -> {
            //记录from的棋子信息
            if(Judge.getFromI() == -1 && Judge.getFromJ() == -1 && !Judge.isFinished()) {
                tempnum = num;
                tempchess = chess;
                Judge.getFrom(i, j);
                color.set(-1);
            }
            else if(Judge.getToI() == -1 && Judge.getToJ() == -1 && !Judge.isFinished()) {
                Judge.getTo(i, j);
            }
            if(Judge.move() && !Judge.isFinished()){
                moveChange();
            }
        });
    }



    /**
     * 调整大小
     */
    public void setSize(Scene s){
        s.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                width.set((s.getWidth() - 100) / 5);
                height.set((s.getHeight() - 75) / 5);
            }
        });
    }


    public void changeColor(){
        color.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (color.get() == 1) {
                    chess.fillProperty().set(Color.RED);
                }
                else if (color.get() == 2) {
                    chess.fillProperty().set(Color.BLUE);
                }
                else if(color.get() == 0){
                    chess.fillProperty().set(Color.WHITE);
                }
            }
        });
/*
        num.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
*/
    }

    /**
     * 初始化棋子编号以及颜色
     */
    public void setColorandnumber(Rectangle chess, int i, int j){
        if(i < 3 && j < 3 - i){
            num.setText(red.toString());                                            //num label
            sp.getChildren().addAll(chess, num);
            board[i][j] = RED;
            number[i][j] = red;
            red++;
        }
        else if(i >= 2 && j >= 4 - i + 2){
            num.setText(blue.toString());
            sp.getChildren().addAll(chess, num);
            board[i][j] = BLUE;
            number[i][j] = blue;
            blue++;
        }
        else {
            num.setText("");
            sp.getChildren().addAll(chess, num);
            board[i][j] = WHITE;
        }
    }

    /**
     * 变更时候减少某个颜色的计数，实现棋子移动
     */
    public void moveChange(){
        if(board[toI][toJ] == 1){
            red--;
        }

        if(board[toI][toJ] == 2){
            blue--;
        }

        //改变数字填充，颜色填充，实现棋子移动
        color.set(board[fromI][fromJ]);
        num.setText(tempnum.getText());
        tempnum.textProperty().set("");
        tempchess.fillProperty().set(Color.WHITE);
        //设置后端棋盘数据
        setBoard();
        //设置from和to为初始值
        fromI = -1;
        fromJ = -1;
        toI = -1;
        toJ = -1;
    }

    public IntegerProperty getColor(){
        return color;
    }
}
