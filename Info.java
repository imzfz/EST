package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/8.
 */
class Info{
    private static StackPane area = new StackPane();
    private static TextArea info = new TextArea();
    private static String text = "";

    public Info(){
        area.setPadding(new Insets(5,5,80,5));
        info.setPrefWidth(90);
        info.setWrapText(true);
        info.setEditable(false);
        area.getChildren().add(info);
    }

    public static StackPane getArea(){
        return area;
    }

    public static void setInfo(String s){
        text += s;
        info.appendText(s);
    }
}
