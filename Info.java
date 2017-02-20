package sample;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by zfz on 17/2/8.
 */
class Info{
    private static StackPane area = new StackPane();
    private static TextArea info = new TextArea();

    /**
     * 设置不可编辑、自动换行的信息显示区域
     */
    public Info(){
        area.setPadding(new Insets(5,5,80,5));
        info.setPrefWidth(90);
        info.setWrapText(true);
        info.setEditable(false);
        area.getChildren().add(info);
    }


    /**
     * 添加显示区到主界面
     */
    public static StackPane getArea(){
        return area;
    }


    /**
     * 添加说明信息到末尾
     */
    public static void setInfo(String s){
        info.appendText(s);
    }
}
