package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Export_CSV{
	public static void main(String[]arg) throws IOException {
		//Define 
		 String line    = " ";
	     String splitBy = ",";
	     int populate = -1;
	     int startLine = -1;
	     String student_grade = null;
	     //Reading File
	     FileReader fileRead = new FileReader( "class.csv" );
	     BufferedReader br   = new BufferedReader( fileRead );	     	   
	 	 ArrayList <String> gradeinfo = new ArrayList<String>();	 		 
	 	 //Create CSV file Setup Headline
	     FileWriter csvWriter = new FileWriter("Student Grade.csv");
			csvWriter.append("Student ID");
			csvWriter.append(",");
			csvWriter.append("Name");
			csvWriter.append(",");
			csvWriter.append("Score");
			csvWriter.append(",");
			csvWriter.append("Grade");
			csvWriter.append("\n");
			
	     while ( (line = br.readLine()) != null) {	     	 
        	 String[] reader = line.split( splitBy );
             if(populate>startLine) {	        
            	 //Transfer Grade Data to Float
            	 int tid = new Integer(reader[0]);
            	 float qz = new Float(reader[3]);
            	 float t1 = new Float(reader[4]);
            	 float mid = new Float(reader[5]);
            	 float t3 = new Float(reader[6]);
            	 float fin = new Float(reader[7]);
            	 float pre = new Float(reader[8]);
            	 float cod = new Float(reader[9]);

	            //Grade student individual
            	 float studIngrade = (float) (qz*0.2+t1*0.2+mid*0.6+t3/3+fin*0.8+pre+cod);
            	 //Count number of A & F Student and Insert Grade into StudentInfo HashMap
            	 if(studIngrade >= 90 && studIngrade<=100) {
            		 student_grade = "A";
         		}else if(studIngrade >= 80 && studIngrade < 90) {
         			student_grade = "B";
         		}else if(studIngrade >= 70 && studIngrade < 80) {
         			student_grade = "C";
         		}else if(studIngrade >= 65 && studIngrade < 70) {
         			student_grade = "D";
         		}else if(studIngrade < 65 && studIngrade > 0) {
         			student_grade = "F";
         	}
            	 //Insert data into row
            	 gradeinfo.add(reader[0]);
            	 gradeinfo.add(reader[1]);
            	 gradeinfo.add(reader[2]);
            	 gradeinfo.add(String.format("%.2f", studIngrade));
            	 gradeinfo.add(student_grade);

     			csvWriter.append(String.join(",", gradeinfo));
     			csvWriter.append("\n");
             }
             	populate++;
//             	System.out.println(gradeinfo);
             	gradeinfo.clear();            	 
             }
	     	//Import Data and Close
			csvWriter.flush();
			csvWriter.close();
	}

}

