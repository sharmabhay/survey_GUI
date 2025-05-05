import javax.swing.*; // Imports the Java Swing GUI utilities
import java.awt.HeadlessException;
import java.awt.event.*; // Imports the Java Adbstract Window Toolkit for Events
import java.util.Scanner;
import java.io.*; // Imports the necessary classes like IOException, FileReader, etc.


public class Survey extends JFrame {
    public static void main(String[] args) throws HeadlessException, IOException {
        Scanner in = new Scanner(System.in);
        new FirstQuestion();
        // new GenderQuestionLav();
        // new GradeLevelQuestion();
        // new FourthQuestion();
        // new JavaProjectQuestions();
        // new KalQuestions();
    }
}
