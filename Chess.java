package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
    private Judge judge;
    private static boolean listener = false;
    private static final int WHITE = 0;                                                //0 is white  1 is red  2 is blue
    private static final int RED = 1;
    private static final int BLUE = 2;
    private DoubleProperty width = new SimpleDoubleProperty(40);
    private DoubleProperty height = new SimpleDoubleProperty(40);
    private IntegerProperty color = new SimpleIntegerProperty(Back.color);
    private static Integer red = 1, blue = 1;
    private Label num = new Label("1");


    /**
     * begin
     */
    public Chess(int i, int j) {
        chess = new Rectangle();
        sp = new StackPane();
//        judge = new Judge();
        chess.heightProperty().bind(height);
        chess.widthProperty().bind(width);
        setColorandnumber(chess, i, j);
        gp.add(sp, i, j);
        gp.setStyle("-fx-grid-lines-visible:true");                    //line of rectangle
        sp.setOnMouseClicked(e -> {
            if(Judge.getFromI() == -1 && Judge.getFromJ() == -1)  Judge.getFrom(i, j);
            else if(Judge.getToI() == -1 && Judge.getToJ() == -1)  Judge.getTo(i, j);
            if(Judge.move()){
                listener = true;
                color.set(board[toI][toJ]);
            }
        });
    }



    /**
     * auto resize
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
        if(listener) {
            color.addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if (color.get() == 1) {
                        chess.fillProperty().set(Color.RED);
                    }
                    else if (color.get() == 2) {
                        chess.fillProperty().set(Color.BLUE);
                    }
                    fromI = -1;
                    fromJ = -1;
                    toI = -1;
                    toJ = -1;
                    listener = false;
                }
            });
        }
    }

    /**
     * set chess color&number at start
     */
    public void setColorandnumber(Rectangle chess, int i, int j){
        if(i < 3 && j < 3 - i){
            num.setText(red.toString());                                            //num label
            sp.getChildren().addAll(chess, num);
            chess.fillProperty().setValue(Color.RED);
            board[i][j] = RED;
            number[i][j] = red;
            red++;
        }
        else if(i >= 2 && j >= 4 - i + 2){
            num.setText(blue.toString());
            sp.getChildren().addAll(chess, num);
            chess.fillProperty().setValue(Color.BLUE);
            board[i][j] = BLUE;
            number[i][j] = blue;
            blue++;
        }
        else {
            sp.getChildren().addAll(chess);
            chess.fillProperty().setValue(Color.WHITE);
            board[i][j] = WHITE;
        }
    }

    public void setC(){
        color.set(Back.getColor());
        log.print("set c success " + color);
    }
}
