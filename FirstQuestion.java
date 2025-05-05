// This question was completed by Salman.
import javax.swing.*; // Imports the Java Swing GUI utilities
import java.awt.event.*; // Imports the Java Adbstract Window Toolkit for Events
import java.util.Scanner;
import java.io.*; // Imports the necessary classes like IOException, FileReader, etc.


public class FirstQuestion extends JFrame {
    private static final long serialVersionUID = 1L;
    public static String dir = "H:\\Documents - Copy\\GitHub\\survey_GUI\\data\\";

    public FirstQuestion() {
        frame();
    }

    public void frame() {
        // Creates a new frame window
        JFrame frameQ1 = new JFrame();

        // Creates a label text box
        JLabel questionQ1 = new JLabel ("Are you a student or a teacher?");
        JButton studentQ1 = new JButton ("Student");
        JButton teacherQ1 = new JButton ("Teacher");

        // Adding action listener to student button and teacher button
        studentQ1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s){
                    try {
                        File myObj = new File(dir + "qn_1_student.txt");
                        // Reading the file
                        Scanner file = new Scanner(myObj);
                        FileReader fr = new FileReader(myObj); // Creation of FileReader object
                        BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
                        int cQ1 = 0;
                        int studentCounterQ1 = 0;
                        int teacherCounterQ1 = 0;

                        while ((cQ1 = br.read()) != -1) { // Read char by char
                            char character = (char) cQ1; // Converts int to char

                            if (character == 's') { // Checking for the number of students
                                studentCounterQ1++;
                            }
                            else if (character == 't') { // Checking for the number of teachers
                                teacherCounterQ1++;
                            }
                        }

                        if (studentCounterQ1 == 0 && teacherCounterQ1 == 0) {
                            // Writing text to the file
                            FileWriter myWriter = new FileWriter(myObj);
                            myWriter.write("s");
                            myWriter.close();
                            System.out.println("Successfully wrote to the file.");
                        }
                        else if (studentCounterQ1 > 0 || teacherCounterQ1 > 0) {
                            // Appending text to the file
                            PrintWriter writer = new PrintWriter(new FileWriter(myObj, true));
                            writer.print("s");
                            writer.close();
                            System.out.println("Successfully wrote to the file.");
                        }

                        // Reading the file again
                        cQ1 = 0;

                        while ((cQ1 = br.read()) != -1) { // Read char by char
                            char character = (char) cQ1; // Converts int to char
                            if (character == 's') { // Checking for the number of students
                                studentCounterQ1++;
                            }
                            else if (character == 't') { // Checking for the number of teachers
                                teacherCounterQ1++;
                            }
                        }
                        System.out.println("Students: " + studentCounterQ1);
                        System.out.println("Teachers: " + teacherCounterQ1);

                        // Closing frame, bufferedwriter, and scanner
                        frameQ1.setVisible(false);
                        JOptionPane.showMessageDialog(null, "~~Statistics~~ \n" + "Students Surveyed: " + studentCounterQ1 + "\n"
                                + "Teachers Surveyed: " + teacherCounterQ1);
                        GradeLevelQuestion.GradeLevels();
                        br.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            });

        teacherQ1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Creating file if not there, then writes in it. If present, immediately writes in file
                try {
                    File myObj = new File(dir + "qn_1_student.txt");
                    // Reading the file
                    Scanner file = new Scanner(myObj);
                    FileReader fr = new FileReader(myObj); // Creation of FileReader object
                    BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
                    int cQ1 = 0;
                    int studentCounterQ1 = 0;
                    int teacherCounterQ1 = 0;

                    while ((cQ1 = br.read()) != -1) { // Read char by char
                        char character = (char) cQ1; // Converts int to char
                        if (character == 's') { // Checking for the number of students
                            studentCounterQ1++;
                        }
                        else if (character == 't') { // Checking for the number of teachers
                            teacherCounterQ1++;
                        }
                    }

                    if (studentCounterQ1 == 0 && teacherCounterQ1 == 0) {
                        // Writing text to the file
                        FileWriter myWriter = new FileWriter(myObj);
                        myWriter.write("t");
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    }
                    else if (studentCounterQ1 > 0 || teacherCounterQ1 > 0) {
                        // Appending text to the file
                        PrintWriter writer  = new PrintWriter(new FileWriter(myObj, true));
                        writer.print("t");
                        writer.close();
                        System.out.println("Successfully wrote to the file.");
                    }

                    // Reading the file again
                    cQ1 = 0;
                    while ((cQ1 = br.read()) != -1) { // Read char by char
                        char character = (char) cQ1; //Converts int to char
                        if (character == 's') { // Checking for the number of students
                            studentCounterQ1++;
                        }
                        else if (character == 't') { // Checking for the number of teachers
                            teacherCounterQ1++;
                        }
                    }
                    System.out.println("Students: " + studentCounterQ1);
                    System.out.println("Teachers: " + teacherCounterQ1);

                    // Closing frame, bufferedwriter, and scanner
                    frameQ1.setVisible(false);
                    JOptionPane.showMessageDialog(null, studentCounterQ1 + " students and " + teacherCounterQ1
                            + " teachers have been surveyed so far.");
                    JavaProjectQuestions.question1_Teacher();
                    br.close();
                    file.close();
                } catch (IOException t) {
                    System.out.println("An error occurred.");
                    t.printStackTrace();
                }
            }
        });

        // Setting position of the text (x, y, width, height)
        questionQ1.setBounds(100, 0, 275, 25);
        studentQ1.setBounds(50, 50, 100, 25);
        teacherQ1.setBounds(225, 50, 100, 25);

        // Adding the label to the frame
        frameQ1.add(questionQ1);
        frameQ1.add(studentQ1);
        frameQ1.add(teacherQ1);

        // Setting size of frame window (length, width), and other things
        frameQ1.setSize(400, 200);
        frameQ1.setLayout(null);
        frameQ1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Open the window
        frameQ1.setVisible(true);
    }

    public static void main(String[] args) throws java.io.FileNotFoundException {
        Scanner in = new Scanner(System.in);

        // Calls the constructor
        new FirstQuestion();

        // Closes the scanner
        in.close();
    }
}
