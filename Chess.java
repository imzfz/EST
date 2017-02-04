package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
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
    private Judge judge;
    private static final int WHITE = 0;                                                //0 is white  1 is red  2 is blue
    private static final int RED = 1;
    private static final int BLUE = 2;
    private DoubleProperty width = new SimpleDoubleProperty(40);
    private DoubleProperty height = new SimpleDoubleProperty(40);
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
        chess.setOnMouseClicked(e -> {
            Judge.getNowchoose(i, j);
        });
        test();
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
}
