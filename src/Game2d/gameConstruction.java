package Game2d;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Color.cyan;

public class  gameConstruction extends JComponent{

    static Object[][] shapesDetails = new Object[400][402];
    static String[] shapesRand = new String[50];
    String[] shapesCol = new String[100];
    String[] arrowKey = new String[100];
    static int points=-2;

    static JLabel textArea = new JLabel();

    static Color[] colors = { green, cyan, red, yellow, magenta, pink, orange, black};
    int[][] arrayColors;
    int width, height;
    static int size = 20;

    public gameConstruction(int[][] a) {
        this.arrayColors = a;

        width = a.length;
        height = a[0].length;
    }


    public void paintComponent(Graphics g) {

        shapesRand[0]="Circle";
        shapesRand[1]="Rectangle";
        shapesRand[2]="Square";
        shapesRand[3]="Pie";

        arrowKey[0]="Arrow Right";
        arrowKey[1]="Arrow Left";
        arrowKey[2]="Arrow Up";
        arrowKey[3]="Arrow Down";

        shapesCol[0]="green";
        shapesCol[1]="blue";
        shapesCol[2]="red";
        shapesCol[3]="yellow";
        shapesCol[4]="magenta";
        shapesCol[5]="pink";
        shapesCol[6]="orange";
        shapesCol[7]="black";

        int position=0;
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {


                g.setColor(colors[arrayColors[i][j]]);
                int randsh = (int)(Math.random()*4);
                int xsize=i * size;
                int ysize=j * size;
                shapesDetails[4][0]=(int)(Math.random()*8);
                shapesDetails[5][0]=(int)(Math.random()*4);
                shapesDetails[6][0]=(int)(Math.random()*4);
                if (randsh==0){
                    Squares randomSquare = new Squares(i * size, j * size, size, colors[arrayColors[i][j]]);
                    randomSquare.draw(g);
                    //System.out.println("X: "+ xsize + " Y: "+ ysize + " Square");
                    shapesDetails[0][position]=xsize;
                    shapesDetails[1][position]=ysize;
                    shapesDetails[2][position]="Square";
                    shapesDetails[3][position]=arrayColors[i][j];

                    position++;
                }
                if (randsh==1){
                    Rectangles randomRectangle = new Rectangles(i * size, j * size, size, colors[arrayColors[i][j]]);
                    randomRectangle.draw(g);
                    //System.out.println("X: "+ xsize + " Y: "+ ysize + " Square");
                    shapesDetails[0][position]=xsize;
                    shapesDetails[1][position]=ysize;
                    shapesDetails[2][position]="Rectangle";
                    shapesDetails[3][position]=arrayColors[i][j];

                    position++;
                }
                if (randsh==2){
                    Circles randomCircle = new Circles(i * size, j * size, size, colors[arrayColors[i][j]]);
                    randomCircle.draw(g);
                    shapesDetails[0][position]=(xsize);
                    shapesDetails[1][position]=(ysize);
                    shapesDetails[2][position]=("Circle");
                    shapesDetails[3][position]=(arrayColors[i][j]);

                    position++;
                }
                if (randsh==3){
                    Pies randomPie = new Pies(i * size, j * size, size, colors[arrayColors[i][j]]);
                    randomPie.draw(g);
                    shapesDetails[0][position]=(xsize);
                    shapesDetails[1][position]=(ysize);
                    shapesDetails[2][position]=("Pie");
                    shapesDetails[3][position]=(arrayColors[i][j]);

                    position++;
                }

            }
        }
        points++;
        shapesDetails[7][0]=points;



        if((int)(Math.random()*3)==0){
            shapesDetails[4][0]= 8;
            shapesDetails[5][0]= 4;
            textArea.setText("Click on "  + " " + arrowKey[(int)shapesDetails[6][0]] + ".     |       " + " Total Points: " + points);



        }
        else{
            shapesDetails[6][0]=4;
            textArea.setText("Click on "  + shapesCol[(int)shapesDetails[4][0]]+ " " +
                    shapesRand[(int)shapesDetails[5][0]] +".     |       " + " Total Points: " + points );
        }


    }

    public Dimension getPreferredSize() {

        return new Dimension(width * size, height * size);
    }







}

