package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 300, 275);
        Chess chess;
        new Judge();
        bp.setRight(Info.getArea());
        primaryStage.setTitle("EST");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.sizeToScene();


        /**
         * new the chess
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                chess = new Chess(i, j);
                chess.setSize(scene);
                chess.changeColor();
                chess.getColor().set(Chess.board[i][j]);
            }
        }
        bp.setCenter(Chess.gp);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
