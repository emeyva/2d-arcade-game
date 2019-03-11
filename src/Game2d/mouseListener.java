package Game2d;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class mouseListener implements MouseListener{
    JFrame gameView;
    Object[][] shapesDet=new Object[400][400];
    JLabel text;
    Object[] ShapesObj = new Object[50];
    public mouseListener(JFrame View, Object[][] Details, JLabel update, Object[] shapes){
        gameView=View;
        shapesDet=Details;
        text=update;
        ShapesObj=shapes;
    }
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mousePressed(MouseEvent e) {
        int correct=0;

        int x=e.getX();
        //System.out.println("Mouse Clicked On X before: " + x);
        int y=e.getY();
        System.out.println(y);
        //System.out.println("Mouse Clicked On Y before: " + y);
        x = x-x%20;
        y=y-40;             //Title space taken away from click coordinates. (more or less 25)
        y = (y-y%20);
        //System.out.println("Mouse Clicked On X after: " + x);
        //System.out.println("Mouse Clicked On Y after: " + y);
        int i;
        int j=0;

        for (i = 0; i <= 399; i++) {
            //System.out.println("Mouse Clicked On X: " + shapesDet[j][i]);
            if((((Integer)(shapesDet[j][i]))==x)){
                if (((Integer) shapesDet[j+1][i] == y) ){
                    if (((Integer) shapesDet[j+3][i] == (int)shapesDet[4][0]) ){
                        //System.out.println("Mouse Clicked On: " + shapesDet[j+2][i]);
                        if (( shapesDet[j+2][i].equals(ShapesObj[(int)shapesDet[5][0]])) ){
                            text.setText("Correct +1 point");
                            Timer timer = new Timer(500, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    gameView.repaint();
                                }
                            });
                            timer.setRepeats(false); // Only execute once
                            timer.start();

                            correct=1;
                            break;

                        }

                    }

                }

            }

        }
        if(correct==0){
            JOptionPane.showMessageDialog(null, "Game Over", "You Lost: " , JOptionPane.QUESTION_MESSAGE);
            try {

                File Resultsfile = new File("allResults.txt");

                if (Resultsfile.createNewFile()){
                    System.out.println("File is created!");
                }else{
                    System.out.println("File already exists.");
                }
                String playeyStr=String.valueOf(shapesDet[8][0]);
                String str = ( playeyStr + " - "+ ((int)(shapesDet[7][0])) + "   \n");
                BufferedWriter writer = new BufferedWriter(new FileWriter(Resultsfile, true));
                writer.append(' ');
                writer.append(str);

                writer.close();

            }
            catch (IOException exc) {
                exc.printStackTrace();

            }
            Runtime.getRuntime().exit(1);
        }



    }
}
