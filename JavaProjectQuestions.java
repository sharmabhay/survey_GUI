// These questions were completed by Abhay.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;


public class JavaProjectQuestions {
    public static String dir = "H:\\Documents - Copy\\GitHub\\survey_GUI\\data\\";

    public static void main(String[] args) throws java.io.FileNotFoundException {
        question1_Teacher();
        question6_Student();
    }

    public static void question6_Student() {
        String[] choices = { "Strongly Agree", "Agree", "Disagree", "Strongly Disagree" };
        // array for options in question

        JFrame frame6_s = new JFrame("Question 6 for Students: ");
        frame6_s.setVisible(true);
        frame6_s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6_s.setSize(600, 150);
        frame6_s.setLocation(430, 100);
        // sets frame

        JPanel panel6_s = new JPanel();
        panel6_s.setLayout(new BoxLayout(panel6_s, BoxLayout.Y_AXIS));
        frame6_s.add(panel6_s);
        // sets and adds panel to frame

        JLabel label6_s = new JLabel(
                "To what extent do you agree/disagree with the following statement: “I like math”?");
        label6_s.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel6_s.add(label6_s);
        // sets and adds label to panel

        JComboBox<String> choice6_s = new JComboBox<String>(choices);
        choice6_s.setMaximumSize(choice6_s.getPreferredSize());
        choice6_s.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel6_s.add(choice6_s);
        // sets and adds combobox to panel

        JButton button6_s = new JButton("Submit");
        button6_s.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel6_s.add(button6_s);
        // sets and adds button to panel

        frame6_s.setVisible(true);
        // shows frame

        button6_s.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File f6_s = new File(dir + "qn_6_student.txt");
                    Scanner s6_s = new Scanner(f6_s);
                    FileReader fr6_s = new FileReader(f6_s);
                    BufferedReader br6_s = new BufferedReader(fr6_s);

                    int cQ6_s = 0;
                    int aCounter = 0;
                    int bCounter = 0;
                    int cCounter = 0;
                    int dCounter = 0;

                    boolean sa = false;
                    boolean a = false;
                    boolean d = false;
                    boolean sd = false;

                    if (choice6_s.getSelectedItem().equals("Strongly Agree")) {
                        sa = true;
                    }
                    if (choice6_s.getSelectedItem().equals("Agree")) {
                        a = true;
                    }
                    if (choice6_s.getSelectedItem().equals("Disagree")) {
                        d = true;
                    }
                    if (choice6_s.getSelectedItem().equals("Strongly Disagree")) {
                        sd = true;
                    }

                    while ((cQ6_s = br6_s.read()) != -1) {
                        char c = (char) cQ6_s;

                        if (c == 'A') {
                            aCounter++;
                        }
                        else if (c == 'B') {
                            bCounter++;
                        }
                        else if (c == 'C') {
                            cCounter++;
                        }
                        else if (c == 'D') {
                            dCounter++;
                        }
                    }
                    FileWriter fw6_s = new FileWriter(f6_s, true);
                    PrintWriter pw6_s = new PrintWriter(new FileWriter(f6_s, true));

                    if (aCounter == 0 && sa) {
                        // Writing text to the file
                        fw6_s.write("A ");
                        fw6_s.close();
                    }
                    else if (aCounter > 0 && sa) {
                        // Appending text to the file
                        pw6_s.print("A ");
                        pw6_s.close();
                    }
                    else if (bCounter == 0 && a) {
                        // Writing text to the file
                        fw6_s.write("B ");
                        fw6_s.close();
                    }
                    else if (bCounter > 0 && a) {
                        // Appending text to the file
                        pw6_s.print("B ");
                        pw6_s.close();
                    }
                    else if (cCounter == 0 && d) {
                        // Writing text to the file
                        fw6_s.write("C ");
                        fw6_s.close();
                    }
                    else if (cCounter > 0 && d) {
                        // Appending text to the file
                        pw6_s.print("C ");
                        pw6_s.close();
                    }
                    else if (dCounter == 0 && sd) {
                        // Writing text to the file
                        fw6_s.write("D ");
                        fw6_s.close();
                    }
                    else if (dCounter > 0 && sd) {
                        // Appending text to the file
                        pw6_s.print("D ");
                        pw6_s.close();
                    }

                    // Reading the file again
                    cQ6_s = 0;

                    while ((cQ6_s = br6_s.read()) != -1) {
                        char c = (char) cQ6_s;

                        if (c == 'A') {
                            aCounter++;
                        }
                        else if (c == 'B') {
                            bCounter++;
                        }
                        else if (c == 'C') {
                            cCounter++;
                        }
                        else if (c == 'D') {
                            dCounter++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Statistics for question 6 - " + "\n" + "Number of students who Strongly Agree (A): "
                            + aCounter + "\n" + "Number of students who Agree (B): " + bCounter + "\n" + "Number of students who Disagree (C): "
                            + cCounter + "\n" + "Number of students who Strongly Disagree (D): " + dCounter);
                    JOptionPane.showMessageDialog(null, "Thank you for running this survey! Please enjoy this complimentary chocolate bar!");
                    frame6_s.setVisible(false);
                    br6_s.close();
                    s6_s.close();
                }
                catch (IOException e1) {
                    System.out.println("Error.");
                    e1.printStackTrace();
                }
                frame6_s.setVisible(false);
            }
        });
    }

    public static void question1_Teacher() {
        JFrame frame1_t = new JFrame("Question 1 for Teachers: ");
        frame1_t.setVisible(true);
        frame1_t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1_t.setSize(600, 150);
        frame1_t.setLocation(430, 100);
        // sets frame

        JPanel panel1_t = new JPanel();
        panel1_t.setLayout(new BoxLayout(panel1_t, BoxLayout.Y_AXIS));
        frame1_t.add(panel1_t);
        // sets and adds panel to frame

        JLabel label1_t = new JLabel("Would you want to use more technology in the classroom?");
        label1_t.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1_t.add(label1_t);
        // sets and adds label to panel

        ButtonGroup cb1_t = new ButtonGroup();
        JCheckBox checkbox1_1_t = new JCheckBox("Yes");
        JCheckBox checkbox1_2_t = new JCheckBox("No");
        cb1_t.add(checkbox1_1_t);
        cb1_t.add(checkbox1_2_t);
        // adds checkboxes to buttongroup so that only one box can be selected at a time
        panel1_t.add(checkbox1_1_t);
        panel1_t.add(checkbox1_2_t);
        // adds checkboxes for panel
        checkbox1_1_t.setSelected(false);
        checkbox1_2_t.setSelected(false);
        // sets which box is set as ticked(true) or unticked(false) at the start

        frame1_t.setVisible(true);
        // shows frame

        checkbox1_1_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean yesBox = false;

                if (checkbox1_1_t.isSelected()) {
                    yesBox = true;
                }

                try {
                    File f1_t = new File(dir + "qn_1_teacher.txt");
                    Scanner s1_t = new Scanner(f1_t);
                    FileReader fr1_t = new FileReader(f1_t);
                    BufferedReader br1_t = new BufferedReader(fr1_t);

                    int cQ1_t = 0;
                    int yesCounter = 0;
                    int noCounter = 0;

                    while ((cQ1_t = br1_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }
                    if (yesCounter == 0 && noCounter == 0 && yesBox) {
                        // Writing text to the file
                        FileWriter fw1_t = new FileWriter(f1_t, true);
                        fw1_t.write("Y ");
                        fw1_t.close();
                    }
                    else if (yesCounter > 0 || noCounter > 0 && yesBox) {
                        // Appending text to the file
                        PrintWriter pw1_t = new PrintWriter(new FileWriter(f1_t, true));
                        pw1_t.print("Y ");
                        pw1_t.close();
                    }
                    
                    // Reading the file again
                    cQ1_t = 0;

                    while ((cQ1_t = br1_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Statistics for question 1 - " + "\n" + "Number of teachers who said Yes: " + yesCounter
                            + "\n" + "Number of teachers who said No: " + noCounter);
                    frame1_t.setVisible(false);
                    br1_t.close();
                    s1_t.close();
                }
                catch (IOException e1) {
                    System.out.println("Error.");
                    e1.printStackTrace();
                }
                frame1_t.setVisible(false);
                question2_Teacher();
            }
        });

        checkbox1_2_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean noBox = false;

                if (checkbox1_2_t.isSelected()) {
                    noBox = true;
                }

                try {
                    File f1_t = new File(dir + "qn_1_teacher.txt");
                    Scanner s1_t = new Scanner(f1_t);
                    FileReader fr1_t = new FileReader(f1_t);
                    BufferedReader br1_t = new BufferedReader(fr1_t);

                    int cQ1_t = 0;
                    int yesCounter = 0;
                    int noCounter = 0;

                    while ((cQ1_t = br1_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }

                    if (yesCounter == 0 && noCounter == 0 && noBox) {
                        // Writing text to the file
                        FileWriter fw1_t = new FileWriter(f1_t, true);
                        fw1_t.write("N ");
                        fw1_t.close();
                    }
                    else if (yesCounter > 0 || noCounter > 0 && noBox) {
                        // Appending text to the file
                        PrintWriter pw1_t = new PrintWriter(new FileWriter(f1_t, true));
                        pw1_t.print("N ");
                        pw1_t.close();
                    }

                    // Reading the file again
                    cQ1_t = 0;

                    while ((cQ1_t = br1_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Statistics for question 1 - " + "\n" + "Number of teachers who said Yes: " + yesCounter
                            + "\n" + "Number of teachers who said No: " + noCounter);
                    frame1_t.setVisible(false);
                    br1_t.close();
                    s1_t.close();
                }
                catch (IOException e1) {
                    System.out.println("Error.");
                    e1.printStackTrace();
                }
                frame1_t.setVisible(false);
                question2_Teacher();
            }
        });
    }

    public static void question2_Teacher() {
        JFrame frame2_t = new JFrame("Question 2 for Teachers: ");
        frame2_t.setVisible(true);
        frame2_t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2_t.setSize(600, 150);
        frame2_t.setLocation(430, 100);
        // sets frame

        JPanel panel2_t = new JPanel();
        panel2_t.setLayout(new BoxLayout(panel2_t, BoxLayout.Y_AXIS));
        frame2_t.add(panel2_t);
        // sets and adds panel to frame

        JLabel label2_t = new JLabel(
                "Do you feel that the current math curriculum prepares the students for university?");
        label2_t.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2_t.add(label2_t);
        // sets and adds label to panel

        ButtonGroup cb2_t = new ButtonGroup();
        JCheckBox checkbox2_1_t = new JCheckBox("Yes");
        JCheckBox checkbox2_2_t = new JCheckBox("No");
        cb2_t.add(checkbox2_1_t);
        cb2_t.add(checkbox2_2_t);
        // adds checkboxes to buttongroup so that only one box can be selected at a time
        panel2_t.add(checkbox2_1_t);
        panel2_t.add(checkbox2_2_t);
        // adds checkboxes for panel
        checkbox2_1_t.setSelected(false);
        checkbox2_2_t.setSelected(false);
        // sets which box is set as ticked(true) or unticked(false) at the start\

        frame2_t.setVisible(true);
        // shows frame

        checkbox2_1_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean yesBox = false;

                if (checkbox2_1_t.isSelected()) {
                    yesBox = true;
                }

                try {
                    File f2_t = new File(dir + "qn_2_teacher.txt");
                    Scanner s2_t = new Scanner(f2_t);
                    FileReader fr2_t = new FileReader(f2_t);
                    BufferedReader br2_t = new BufferedReader(fr2_t);

                    int cQ1_t = 0;
                    int yesCounter = 0;
                    int noCounter = 0;

                    while ((cQ1_t = br2_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }
                    if (yesCounter == 0 && noCounter == 0 && yesBox) {
                        // Writing text to the file
                        FileWriter fw2_t = new FileWriter(f2_t, true);
                        fw2_t.write("Y ");
                        fw2_t.close();
                    }
                    else if (yesCounter > 0 || noCounter > 0 && yesBox) {
                        // Appending text to the file
                        PrintWriter pw2_t = new PrintWriter(new FileWriter(f2_t, true));
                        pw2_t.print("Y ");
                        pw2_t.close();
                    }

                    // Reading the file again
                    cQ1_t = 0;

                    while ((cQ1_t = br2_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Statistics for question 2 - " + "\n" + "Number of teachers who said Yes: " + yesCounter
                            + "\n" + "Number of teachers who said No: " + noCounter);
                    frame2_t.setVisible(false);
                    br2_t.close();
                    s2_t.close();
                }
                catch (IOException e1) {
                    System.out.println("Error.");
                    e1.printStackTrace();
                }
                frame2_t.setVisible(false);
                JOptionPane.showMessageDialog(null,"Thank you for running this survey! Please enjoy this complimentary chocolate bar!");
                System.exit(0);
            }
        });

        checkbox2_2_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean noBox = false;

                if (checkbox2_2_t.isSelected()) {
                    noBox = true;
                }

                try {
                    File f2_t = new File(dir + "qn_2_teacher.txt");
                    Scanner s2_t = new Scanner(f2_t);
                    FileReader fr2_t = new FileReader(f2_t);
                    BufferedReader br2_t = new BufferedReader(fr2_t);

                    int cQ1_t = 0;
                    int yesCounter = 0;
                    int noCounter = 0;

                    while ((cQ1_t = br2_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }
                        else if (c == 'N') {
                            noCounter++;
                        }
                    }
                    if (yesCounter == 0 && noCounter == 0 && noBox) {
                        // Writing text to the file
                        FileWriter fw2_t = new FileWriter(f2_t, true);
                        fw2_t.write("N ");
                        fw2_t.close();
                    }
                    else if (yesCounter > 0 || noCounter > 0 && noBox) {
                        // Appending text to the file
                        PrintWriter pw2_t = new PrintWriter(new FileWriter(f2_t, true));
                        pw2_t.print("N ");
                        pw2_t.close();
                    }

                    // Reading the file again
                    cQ1_t = 0;

                    while ((cQ1_t = br2_t.read()) != -1) {
                        char c = (char) cQ1_t;

                        if (c == 'Y') {
                            yesCounter++;
                        }else if (c == 'N') {
                            noCounter++;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Statistics for question 2 - " + "\n" + "Number of teachers who said Yes: " + yesCounter
                            + "\n" + "Number of teachers who said No: " + noCounter);
                    frame2_t.setVisible(false);
                    br2_t.close();
                    s2_t.close();
                }
                catch (IOException e1) {
                    System.out.println("Error.");
                    e1.printStackTrace();
                }
                frame2_t.setVisible(false);
                question3_Teacher();
            }
        });
    }

    public static void question3_Teacher() {
        JFrame frame3_t = new JFrame("Question 3 for Teachers: ");
        frame3_t.setVisible(true);
        frame3_t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3_t.setSize(600, 150);
        frame3_t.setLocation(430, 100);
        // sets frame

        JPanel panel3_t = new JPanel();
        panel3_t.setLayout(new BoxLayout(panel3_t, BoxLayout.Y_AXIS));
        frame3_t.add(panel3_t);
        // sets and adds panel to frame

        JLabel label3_t = new JLabel("If not, what can be changed about the curriculum to make it better?");
        label3_t.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3_t.add(label3_t);
        // sets and adds label to panel

        JTextField field3_t = new JTextField("Enter your comments", 16);
        panel3_t.add(field3_t);
        // adds textfield to panel

        JButton button3_t = new JButton("Submit");
        button3_t.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3_t.add(button3_t);
        // sets and adds button to panel

        frame3_t.setVisible(true);
        // shows frame

        button3_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                try {
                    FileWriter fw3_t = new FileWriter(dir + "qn_3_teacher.txt", true);
                    PrintWriter pw3_t = new PrintWriter(fw3_t);

                    pw3_t.println(field3_t.getText());
                    pw3_t.close();
                }
                catch(IOException e3) {
                    e3.getStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Thank you for running this survey! Please enjoy this complimentary chocolate bar!");
                System.exit(0);
            }
        });
    }
}
