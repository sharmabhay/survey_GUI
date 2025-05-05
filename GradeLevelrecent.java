// This question was completed by Salman.
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.awt.Color;
import java.awt.color.*;


public class GradeLevelrecent {
    public static void main(String[] args) {
        dir = "C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\";

        GradeLevels();
    }

    public static void GradeLevels() {
        int grade9Counter = 0;
        int grade10Counter = 0;
        int grade11Counter = 0;
        int grade12Counter = 0;

        int yesCounter = 0;
        int noCounter = 0;

        JFrame f = new JFrame("What grade are you in?");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        f.setContentPane(contentPane);
        contentPane.setLayout(null);

        // The following set of codes asks the user to select their grade level
        String[] gradeLevel = { "Select Grade:", "Grade 9", "Grade 10", "Grade 11", "Grade 12" };
        JComboBox<String> cb = new JComboBox<String>(gradeLevel);
        cb.setBounds(200, 80, 140, 50);
        contentPane.add(cb);
        f.setVisible(true);

        JLabel followingQuestion = new JLabel(" ");
        followingQuestion.setBounds(18, 109, 1100, 100);
        contentPane.add(followingQuestion); // the next question that the user gets is according to what grade they are in 
        System.out.println(grade9Counter);
        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent act) {
                switch ((String)cb.getSelectedItem()) {
                    case "Select Your Grade": followingQuestion.setText(" ");
                    break;
                    case "Grade 9": followingQuestion.setText("Is it hard to remember and apply mathematical formulas (eg y = mx+b)?");
                    break;
                    case "Grade 10": followingQuestion.setText("Is it hard to remember and apply mathematical formulas (eg quadratic formula)?");
                    break;
                    case "Grade 11": followingQuestion.setText("Is it hard to remember and apply mathematical formulas (eg sine and cosine law)?");
                    break;
                    case "Grade 12": followingQuestion.setText("Is it hard to remember and apply mathematical formulas (eg double Angle formulas)?");
                    break;
                }
            }
        });

        // Based on their given question, the user has to either say "yes" or "no"
        JRadioButton no = new JRadioButton("No");
        JRadioButton yes = new JRadioButton("Yes");
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (yes.isSelected()) { // if the user selects yes, he/she can't change it to "no" 
                    no.setSelected(false);
                }
            }
        });
        yes.setBounds(23, 250, 100, 23);
        contentPane.add(yes);

        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (no.isSelected()) {
                    yes.setSelected(false);
                }
            }
        });
        no.setBounds(133, 250, 250, 23);
        contentPane.add(no);

        // After saying yes or no, the user then has to press on "OK"
        JButton okButton1 = new JButton("OK");
        okButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fn = new FileWriter(dir + "onlyGrades.txt", true);
                        PrintWriter pn = new PrintWriter(fn);

                        if (cb.getSelectedItem().equals("Grade 9")) {
                            System.out.println("Hello");
                            pn.write("a");
                            pn.close();
                        }
                        else if (cb.getSelectedItem().equals("Grade 10")) {
                            pn.write("b");
                            pn.close();
                        }
                        else if (cb.getSelectedItem().equals("Grade 11")) {
                            pn.write("c");
                            pn.close();
                        }
                        else if (cb.getSelectedItem().equals("Grade 12")) {
                            pn.write("d");
                            pn.close();
                        }
                } catch (IOException dd) {
                    dd.printStackTrace();
                }

                try {
                    FileWriter usersChoice = new FileWriter(dir + "qn_grades.txt", true);

                    PrintWriter usersChoicePrinted = new PrintWriter(usersChoice);
                    if (yes.isSelected()) {
                        usersChoicePrinted.write("Y");
                        usersChoicePrinted.close();
                    }
                    if (no.isSelected()) {
                        usersChoicePrinted.write("N");
                        usersChoicePrinted.close();
                    }
                } catch (IOException error1) {
                    error1.getStackTrace();
                }

                try {
                    FileReader fr = new FileReader (dir + "qn_grades.txt");
                    BufferedReader br = new BufferedReader(fr);
                    int yesCounter = 0;
                    int noCounter = 0;
                    int blob = 0;
                    try {
                        while ((blob = br.read()) != -1) {
                            char v = (char)blob;

                            if (v == 'Y') {
                                yesCounter++;
                            }
                            else if (v == 'N') {
                                noCounter++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "~Statistics to know each student can remember the formulas~" + "\n"
                                + "# of Students who answered yes" + " " + yesCounter + "# of Students who answered no" + " " + noCounter);
                        br.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } catch (FileNotFoundException kk) {
                    kk.printStackTrace();
                }

                try {
                    FileReader fr = new FileReader (dir + "onlyGrades.txt");
                    BufferedReader br = new BufferedReader(fr);
                    int grade9Counter = 0;
                    int grade10Counter = 0;
                    int grade11Counter = 0;
                    int grade12Counter = 0;
                    int blob = 0;
                    try {
                        while ((blob = br.read()) != -1) {
                            char v = (char)blob;

                            if (v == 'a') {
                                grade9Counter++;
                            }
                            else if (v == 'b') {
                                grade10Counter++;
                            }
                            else if (v == 'c') {
                                grade11Counter++;
                            }
                            else if (v == 'd') {
                                grade12Counter++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "~Statistics for the Grade of Each Student~" + "\n" + "Students in Grade 9: "
                                + " " + grade9Counter + "Students in Grade 10: " + " " + grade10Counter + "Students in Grade 11" + " "
                                + grade11Counter + "Students in Grade 12" + " " + grade12Counter);
                        br.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } catch (FileNotFoundException kk) {
                    kk.printStackTrace();
                }

                f.setVisible(false);
                GenderQuestionLav.GenderQuestionMultipleChoice();
            }
        });
        okButton1.setBounds(23, 350, 100, 23);
        contentPane.add(okButton1);
        f.setBackground(Color.CYAN);
        f.setSize(550, 415);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
