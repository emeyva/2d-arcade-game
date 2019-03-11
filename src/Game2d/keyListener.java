package Game2d;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class keyListener implements KeyListener{
    JFrame gameView;
    Object[][] shapesDet=new Object[400][400];
    JLabel text;
    public keyListener(JFrame View,Object[][] Details, JLabel update){
        gameView=View;
        shapesDet=Details;
        text=update;
    }
    public void keyPressed (KeyEvent e){
        int correct = 0;
        int Code = e.getKeyCode();
        if (Code == 40) {
            Code = 3;
        }
        if (Code == 39) {
            Code = 0;
        }
        if (Code == 38) {
            Code = 2;
        }
        if (Code == 37) {
            Code = 1;
        }
        System.out.println("Code clicked " + Code);
        System.out.println("Order " + shapesDet[6][0]);
        if (Code == (int) (shapesDet[6][0])) {
            correct = 1;
            System.out.println("keyPressed=" + (Code));
            text.setText("Correct +1 point");
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    gameView.repaint();
                }
            });
            timer.setRepeats(false); // Only execute once
            timer.start();

        }
        if (correct == 0) {
            JOptionPane.showMessageDialog(null, "Game Over", "You Lost: ", JOptionPane.INFORMATION_MESSAGE);
            try {

                File Resultsfile = new File("allResults.txt");

                if (Resultsfile.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }
                String playeyStr = String.valueOf(shapesDet[8][0]);
                String str = (playeyStr + " - " + ((int) (shapesDet[7][0])) + "\n");
                BufferedWriter writer = new BufferedWriter(new FileWriter(Resultsfile, true));
                writer.append(' ');
                writer.append(str);

                writer.close();

            } catch (IOException exc) {
                exc.printStackTrace();

            }
            Runtime.getRuntime().exit(1);
        }


    }


    public void keyTyped (KeyEvent e){
    }
    public void keyReleased(KeyEvent e) {
    }

}






