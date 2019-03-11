package Game2d;



import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Shapes {
    static int posX;
    static int posY;
    static Color shapeColor;
    static int shapeSide;



}
class Squares extends Shapes {


    Squares(int x, int y, int side, Color color) {
        posX = x;
        posY = y;
        shapeSide = side;
        shapeColor=color;
    }
    public void draw( Graphics g ) {

        g.setColor( shapeColor );
        g.fillRect( posX, posY, shapeSide, shapeSide );
    }

}
class Rectangles extends Shapes {



    Rectangles(int x, int y, int side, Color color) {
        posX = x;
        posY = y;
        shapeSide = side;
        shapeColor=color;
    }
    public void draw( Graphics g ) {

        g.setColor( shapeColor );
        g.fillRect( posX+2, posY+1, shapeSide-(7+(int)(Math.random()*5)), shapeSide-1 );
    }
}
class Circles extends Shapes {


    Circles(int x, int y, int side, Color color) {
        posX = x;
        posY = y;
        shapeSide = side;
        shapeColor=color;
    }

    public void draw(Graphics g) {
        g.setColor(shapeColor);
        g.fillOval(posX, posY, shapeSide, shapeSide);
    }
}
class Pies extends Shapes {


    Pies(int x, int y, int side, Color color) {
        posX = x;
        posY = y;
        shapeSide = side;
        shapeColor=color;
    }

    public void draw(Graphics g) {
        g.setColor(shapeColor);
        g.fillArc(posX, posY, shapeSide, shapeSide, 0, (180+(int)(Math.random()*110)));
    }
}








