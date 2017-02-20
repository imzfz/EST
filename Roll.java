package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Random;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/20.
 */
class Roll {
    private static Label number = new Label();
    private static Button roll = new Button("掷骰子");
    private static Random random = new Random();
    private static Integer num;
    static HBox hbox = new HBox();


    public Roll() {
        hbox.getChildren().addAll(roll, number);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(15);
        hbox.setPadding(new Insets(5, 5, 20, 5));
        roll.setOnMouseClicked(e -> {
            num = random.nextInt(6) % 6;
            num = num + 1;
            number.setText(num.toString());
        });
    }
}
