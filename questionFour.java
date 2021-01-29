// This question was done by Salman Husainie
/*
questionFour.java
*/

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.awt.HeadlessException;
import java.awt.event.*;

public class questionFour extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public questionFour() throws FileNotFoundException {
        try {
            JSlider sliderQ4;
            File myObjQ4 = new File("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\QuestionFourData.txt");
            // Reading the file
            Scanner fileQ4 = new Scanner(myObjQ4);
           

            JFrame guiQ4 = new JFrame();
            guiQ4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            guiQ4.setSize(400, 325);
            guiQ4.setVisible(true);
            guiQ4.setTitle("Math Mark");

            // Sets layout of slider
            setLayout(null);

            // Creates slider (orientation, min, max, starting value)
            sliderQ4 = new JSlider();
            sliderQ4.setMajorTickSpacing(10); // Set a major tick at every 10th integer
            sliderQ4.setMinorTickSpacing(1);// Set a minor tick at every integer (except the ones with major ticks)
            sliderQ4.setPaintTicks(true); // Paints the ticks on the slider
            sliderQ4.setPaintLabels(true);

            // Creating labels ("text")
            JLabel questionQ4 = new JLabel("What is your most recent grade in math?");
            JLabel textstatementQ4 = new JLabel("You can type your grade here: ");
            JLabel btwQ4 = new JLabel("(Press the button to save the value and continue)");
            JPanel panelQ4 = new JPanel(null);
            JButton submitQ4 = new JButton("Save and Continue");
            JTextField textFieldQ4 = new JTextField(1); // create text Field
            textFieldQ4.setBounds(175, 115, 40, 20);
            panelQ4.add(textFieldQ4);

            // Adding components to the frame
            guiQ4.add(questionQ4);
            guiQ4.add(sliderQ4);
            guiQ4.add(textstatementQ4);
            guiQ4.add(btwQ4);
            guiQ4.add(submitQ4);
            guiQ4.add(panelQ4);

            // Setting bounds of the components
            questionQ4.setBounds(80, 0, 300, 20);
            sliderQ4.setBounds(40, 20, 300, 95);
            textstatementQ4.setBounds(0, 75, 200, 100);
            btwQ4.setBounds(0, 90, 300, 100);
            submitQ4.setBounds(0, 200, 200, 30);
            panelQ4.setBounds(30, 30, 2, 2);
            guiQ4.setVisible(true);

            // Implementing an action listener on the textField
            textFieldQ4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = textFieldQ4.getText();
                    int valueQ4 = Integer.parseInt(text);
                    sliderQ4.setValue(valueQ4);
                }
            });

            // Implementing an action listener on the slider
            sliderQ4.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent ce) {
                    int valueQ4 = sliderQ4.getValue();
                    String textQ4 = "" + valueQ4;
                    textFieldQ4.setText(textQ4);
                }
            });

            // Implementing an action listener on the button
            submitQ4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent s) {
                    try {
                        String text = textFieldQ4.getText();
                        int value = Integer.parseInt(text);
                        File myObj = new File(
                                "C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\QuestionFourData.txt");
                        Scanner file = new Scanner(myObj);
                        int[] ranges = new int[5];
                        FileReader fr = new FileReader(myObjQ4); // Creation of FileReader object
                        
                        for (int i = 0; i < 5; i++) {
                            ranges[i] = fileQ4.nextInt();
                        }
                        //Adding 1 to appropriate range and writing the new values to the file
                        try {
                            FileWriter writer = new FileWriter(myObjQ4);
                            if (value < 50) {
                                ranges[0]++;
                                for (int i = 0; i < 5; i++) {
                                    writer.write(ranges[i] + " ");
                                }
                                writer.close();
                            } 
                            else if (value >= 50 && value < 60) {
                                ranges[1]++;
                                for (int i = 0; i < 5; i++) {
                                    writer.write(ranges[i] + " ");
                                }
                                writer.close();
                            } 
                            else if (value >= 60 && value < 70) {
                                ranges[2]++;
                                for (int i = 0; i < 5; i++) {
                                    writer.write(ranges[i] + " ");
                                }
                                writer.close();
                            }
                            else if (value >= 70 && value < 80) {
                                ranges[3]++;
                                for (int i = 0; i < 5; i++) {
                                    writer.write(ranges[i] + " ");
                                }
                                writer.close();
                            } 
                            else if (value >= 80 && value <= 100) {
                                ranges[4]++;
                                for (int i = 0; i < 5; i++) {
                                    writer.write(ranges[i] + " ");
                                }
                                writer.close();
                            }
                            fr.close();
                        } catch (IOException io) {
                            io.printStackTrace();
                        }
                        System.out.println("Saved");
                        guiQ4.setVisible(false);
                        //Statistic display for this question
                        JOptionPane.showMessageDialog(null, "~~Statistics For Math Marks~~" + "\n" + "Below 50: " + ranges[0] + "\n" 
                                                     + "50-59: " + ranges[1] + "\n" + "60-69: " + ranges[2] + "\n" + "70-79: " + ranges[3]
                                                     + "\n" + "80-100: " + ranges[4]);

                        try {
                        KalQuestions.runQuestions();
    
                    } catch (HeadlessException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    } catch (FileNotFoundException ext) {
                        ext.printStackTrace();
                    }
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public static void main(String[]args) {
        try {
            new questionFour();
        } catch (FileNotFoundException fim) {
             fim.printStackTrace();
        }
    }
}
