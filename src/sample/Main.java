package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {


    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        Pane root = new Pane();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sort");

        for(int i =0;i<180;i++){
            Rectangle rect = new Rectangle();
            rect.rotateProperty().setValue(180);
            rect.setX((10*i));
            rect.setY(150);
            rect.setHeight(10);
            rect.setWidth(5);
            root.getChildren().add(rect);
            Controller.RectList.add(rect);
        }
        Controller con = new Controller();

        Button btn1 = new Button("random");
        btn1.setLayoutX(10);
        btn1.setLayoutY(10);
        DropShadow shadow = new DropShadow();
        btn1.setEffect(shadow);

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                con.randomHeight();

            }
        });
        Button btn2 = new Button("sort");
        btn2.setLayoutX(100);
        btn2.setLayoutY(10);
        DropShadow shadow2 = new DropShadow();
        btn2.setEffect(shadow);

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try {
                    con.sort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 1800, 540);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
