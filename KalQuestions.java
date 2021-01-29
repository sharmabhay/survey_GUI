import javax.swing.*;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class KalQuestions {
	
	static int q8no;
	
public static void main(String[] args) throws IOException {

	
	
	runQuestions();// method to run questions
	
	

}
	public static void runQuestions() throws HeadlessException, IOException {
    File file = new File("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_7.txt");// import file for question 1
    File file2 = new File("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_8.txt");// import file for question 2 yes/no
    File file3 = new File("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_9.txt");// import file for question 2 response

    if (file.createNewFile()) {
	
		try {
			
		FileWriter fw1 = new FileWriter(file,true);	
		FileWriter fw2 = new FileWriter(file2,true);
		FileWriter fw3 = new FileWriter(file3,true);   //creates file writer for 3 files
			
            
		PrintWriter out = new PrintWriter(fw1);
		PrintWriter que2 = new PrintWriter(fw2);
		PrintWriter que2String = new PrintWriter(fw3); // create printwriter with filewriter

    
            int i = (JOptionPane.showConfirmDialog(null, "Do you feel confident doing Math Questions on your own?",
					"?",JOptionPane.YES_NO_OPTION)); // saves user response in variable i
			out.print(i); 
			out.close();
			
			countQuestion7();
			
			int j =(JOptionPane.showConfirmDialog(null, "Are you comfortable to approach your teacher after school?",
					"?",JOptionPane.YES_NO_OPTION));
            que2.print(j); //save responses for question 2 as yes/no(0/1) in file for question 2
            que2.close();
            
            countQuestion8();
            
            if (j == 1) {  // saves user comment if question 2 answer is no
                String response = JOptionPane.showInputDialog(null, "Why are you not comfortable to approach your teacher?" );
                que2String.println(response);
                que2String.close();
            }
						
		
    } catch (FileNotFoundException e) {
        
        e.printStackTrace();
    }
    }
    
    else {
    	
    	try {
			
    		FileWriter fw1 = new FileWriter("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_7.txt",true);	
    		FileWriter fw2 = new FileWriter("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_8.txt",true);
    		FileWriter fw3 = new FileWriter("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_9.txt",true);   //creates file writer for 3 files
    			
                
    		PrintWriter out = new PrintWriter(fw1);
    		PrintWriter que2 = new PrintWriter(fw2);
    		PrintWriter que2String = new PrintWriter(fw3); // create printwriter with filewriter

        
                int i = (JOptionPane.showConfirmDialog(null, "Do you feel confident doing Math Questions on your own?",
    					"?",JOptionPane.YES_NO_OPTION)); // saves user response in variable i
    			out.print(i); 
    			out.close();
    			
    			countQuestion7();// prints yes and no to question 7
    			
    			int j =(JOptionPane.showConfirmDialog(null, "Are you comfortable to approach your teacher after school?",
    					"?",JOptionPane.YES_NO_OPTION));
                que2.print(j); //save responses for question 2 as yes/no(0/1) in file for question 2
                que2.close();
                
                countQuestion8();// prints yes and no to question 8
                
                if (j == 1) {  // saves user comment if question 2 answer is no
                    String response = JOptionPane.showInputDialog(null, "Why are you not comfortable to approach your teacher?" );
                    que2String.println(response);
                    que2String.close();
                    
                }
    						
    		
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
    	
    }
	}
	
		

@SuppressWarnings("resource")
public  static void countQuestion7() throws IOException {
	
	FileReader fr7 = new FileReader ("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_7.txt");
    
	BufferedReader br7 = new BufferedReader(fr7);
	
	int q7yes = 0;
	int q7no = 0;
	
	
	int blob = 0;
	
	
	while ((blob = br7.read()) != -1) {
		char v = (char)blob;
		
		if (v == '0') {
			q7yes++;
		}
		else {
			q7no++;
		}
	}
	
	blob = 0;
	
	
	
	JOptionPane.showMessageDialog(null,"~~Statistics For This Question~~" + " \n" + "# of Students who answered Yes: " + q7yes
								 + " \n" + "# of Students who answered No: " + q7no);
}


public  static int countQuestion8() throws IOException {
	
	FileReader fr8 = new FileReader ("C:\\Users\\salma\\Desktop\\Java Files\\Unit Project\\Question_8.txt");
    
	
	BufferedReader br8 = new BufferedReader(fr8);
	
	int q8yes = 0;
	int blob = 0;
	
	blob = 0;
	
	while ((blob = br8.read()) != -1) {
		char v = (char)blob;
		
		if (v == '0') {
			q8yes++;
		}
		else {
			q8no++;
		}
	}
	br8.close();
	
	JOptionPane.showMessageDialog(null,"~~Statistics For This Question~~" + " \n" + "# of Students who answered Yes: " + q8yes
	+ " \n" + "# of Students who answered No: " + q8no);
	UnitProject.question6_Student();

	
	return q8no;  
}
}


