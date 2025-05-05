import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class GenderQuestionLav {
    public static void main(String[] args) {
        dir = "C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\";

        GenderQuestionMultipleChoice();
    }

    public static void GenderQuestionMultipleChoice() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        frame.add(contentPane);

        frame.setSize(320, 320);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel gender = new JLabel("What is your gender?");
        gender.setBounds(22, 41, 234, 40);
        contentPane.add(gender);

        JRadioButton other = new JRadioButton("Other");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton male = new JRadioButton("Male");
        male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (male.isSelected()) {
                    female.setSelected(false);
                    other.setSelected(false);
                }
            }
        });
        male.setBounds(22, 109, 109, 23);
        contentPane.add(male);

        female.setBounds(133, 109, 109, 23);
        contentPane.add(female);

        other.setBounds(244, 109, 109, 23);
        contentPane.add(other);

        JButton okButton = new JButton("OK");
        okButton.setBounds(23, 172, 89, 23);
        contentPane.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter userChoice = new FileWriter(dir + "qn_gender.txt", true);

                    PrintWriter userChoicePrinted = new PrintWriter(userChoice);
                    if (male.isSelected()) {
                        userChoicePrinted.write("M");
                        userChoicePrinted.close();
                    } else if (female.isSelected()) {
                        userChoicePrinted.write("F");
                        userChoicePrinted.close();
                    } else if (other.isSelected()) {
                        userChoicePrinted.write("O");
                        userChoicePrinted.close();
                    }

                    FileReader oop = new FileReader(dir + "qn_gender.txt");
                    BufferedReader poof = new BufferedReader(oop);
                    int maleCounter = 0;
                    int femaleCounter = 0;
                    int otherCounter = 0;
                    int blob = 0;

                    while ((blob = poof.read()) != -1) {
                        char v = (char) blob;

                        if (v == 'M') {
                            maleCounter++;
                        } else if (v == 'F') {
                            femaleCounter++;
                        } else if (v == 'O') {
                            otherCounter++;
                        }
                    }
                    poof.close();

                    JOptionPane.showMessageDialog(null, "~~Statistics For This Question~~ \n" + "Male: " + maleCounter
                            + "\n" + "Female: " + femaleCounter + "\n" + "Other: " + otherCounter);

                } catch (IOException err1) {
                    err1.getStackTrace();
                }

                frame.setVisible(false);
                try {
                    new questionFour();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
