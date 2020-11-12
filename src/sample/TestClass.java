package sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;
import javafx.stage.Stage;

public class TestClass {


    @Test
    void test() {
        Controller con = new Controller();
        Rectangle rect = new Rectangle();
        con.RectList.add(rect);
        con.randomHeight();
        assertEquals(con.RectHeight[0],con.randHeight);
    }
    @Test
    void test2() {
        int test = 1+2;
        assertEquals(3,test);

    }

}
