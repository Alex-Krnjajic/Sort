package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Controller {



    private final int min = 10;
    private final int max = 300;

    double minHeight;
    int minIndex = 0;
    int counter = 0;
    double temp = 0;
    double randHeight=0;

    public static ArrayList<Rectangle> RectList = new ArrayList<Rectangle>();
    double[] RectHeight;



    @FXML
    public void randomHeight() {

        RectHeight = new double[RectList.size()];
        int i = 0;


        for (Rectangle rect : RectList
        ) {
            randHeight = Math.random() * (max - min + 1) + min;
            RectHeight[i] = randHeight;
            rect.setHeight(randHeight);
            i++;


        }

        minHeight = RectHeight[0];
    }

    @FXML
    public void sort() throws InterruptedException {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), e -> {
            try {
                sort2();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }));
        timeline.setOnFinished(e ->
                System.out.println(Arrays.toString(RectHeight))
                );
        timeline.setCycleCount(RectList.size()-1);
        minHeight = RectHeight[0];
        counter = 0;
        minIndex = 0;
        temp = 0;

        timeline.play();

        System.out.println(Arrays.toString(RectHeight));


    }
    public void sort2() throws InterruptedException {
        System.out.println("start sort");

        System.out.println(minHeight);



        System.out.println("find min");
        for (int i = counter; i < (RectList.size()); i++) {
            //System.out.println("i= " + i);
            if (RectHeight[i] < minHeight) {
                minHeight = RectHeight[i];
               // System.out.println("minHeight= " + minHeight);
               // System.out.println("minIndex= " + i);
                minIndex = i;
            }
        }

        updateHeight();
        //Thread.sleep(500);

    }


    public void updateHeight() {
        temp = RectHeight[counter];
        RectHeight[counter] = RectHeight[minIndex];
        RectList.get(counter).setHeight(RectHeight[counter]);

        RectHeight[minIndex] = temp;
        RectList.get(minIndex).setHeight(temp);


        counter++;
        minHeight = RectHeight[counter];
        minIndex = counter;

    }

}