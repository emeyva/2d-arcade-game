package Game2d;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;



public class editJFrame extends JFrame {
    public Component comp;
    public editJFrame(Component comp, String title, Object[][] shapesDet, String[]ShapesObj, JLabel text) {
        super(title);

        this.comp = comp;

        class ButtonHandler implements ActionListener{
            JTextField inputName;
            JTextField keepGoing;
            ButtonHandler(JTextField a, JTextField cont){
                inputName=a;
                keepGoing=cont;
            }
            public void actionPerformed(ActionEvent e){
                if (e.getActionCommand().equals("Play")){
                    String playerName=inputName.getText();
                    inputName.setText(playerName);
                    keepGoing.setText("Continue");
                }



            }
        }
        JLabel allResults = new JLabel();
        String lineFinal = " Last 10 Records -> ";
        int numberOfLines=0;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("allResults.txt"))) {

            numberOfLines = 0;
            while ((br.readLine()) != null) {
                numberOfLines++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("No records");
        } catch (IOException e) {
            System.out.println("No records");
        }
        try (BufferedReader br = new BufferedReader(new FileReader("allResults.txt"))) {
            numberOfLines = numberOfLines - 10;
            int linesCount = 0;
            if (numberOfLines < 0) {
                numberOfLines = numberOfLines + 10;
                while ((line = br.readLine()) != null) {
                    linesCount++;
                    if (linesCount <= numberOfLines) {
                        lineFinal = lineFinal + "  " + line;

                    }
                }
            }
            linesCount = 0;
            while ((line = br.readLine()) != null) {
                linesCount++;
                if (linesCount > numberOfLines) {
                    lineFinal = lineFinal + "  " + line;

                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("No records");}
        catch (IOException e) {
            System.out.println("No records");
        }



        allResults.setText(lineFinal);

        int continueRun = 0;

        JPanel name = new JPanel();
        JTextField nameText = new JTextField("Insert name");
        JTextField toContinue = new JTextField("Stop");
        JButton nameButton = new JButton("Play");

        name.add(nameText, BorderLayout.NORTH);
        name.add(nameButton, BorderLayout.SOUTH);
        nameButton.addActionListener(new ButtonHandler(nameText, toContinue));
        System.out.println(continueRun);
        this.add(name);

        this.add(allResults, BorderLayout.SOUTH);


        String player;
        String continueYesorNo;

        this.setVisible(true);

        pack();
        while(true){
            continueYesorNo=toContinue.getText();
            player=nameText.getText();

            if(continueYesorNo.equals("Continue")){

                shapesDet[8][0]=player;
                break;
            }
        }



        this.addKeyListener(new keyListener(this,shapesDet,text){});
        this.addMouseListener(new mouseListener(this,shapesDet,text,ShapesObj){});


        int time=20;



        JLabel timeLeft = new JLabel("You have " + time + " seconds!");
        this.add(timeLeft,BorderLayout.NORTH);
        Timer secondAt = new Timer(1000, new ActionListener() {
            int time=20;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                time=time-1;
                timeLeft.setText("You have " + time + " seconds!");
                if(time<1){

                    try {

                        File Resultsfile = new File("allResults.txt");

                        if (Resultsfile.createNewFile()){
                            System.out.println("File is created!");
                        }else{
                            System.out.println("File already exists.");
                        }
                        String playeyStr=String.valueOf(shapesDet[8][0]);
                        String str = ( playeyStr + " - "+ ((int)(shapesDet[7][0])) + "\n");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(Resultsfile, true));
                        writer.append(' ');
                        writer.append(str);

                        writer.close();

                    }
                    catch (IOException exc) {
                        exc.printStackTrace();

                    }
                    JOptionPane.showMessageDialog(null, "Game Over", "You Lost: " , JOptionPane.QUESTION_MESSAGE);
                    Runtime.getRuntime().exit(1);
                }
            }
        });

        this.add(text, BorderLayout.SOUTH);
        secondAt.setRepeats(true);
        secondAt.start();


        this.setFocusable(true);
        this.remove(name);
        this.remove(allResults);

        this.getContentPane().setBackground(Color.WHITE);
        this.add(BorderLayout.CENTER, comp);


        this.setSize(400,450);

        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




    }




}
