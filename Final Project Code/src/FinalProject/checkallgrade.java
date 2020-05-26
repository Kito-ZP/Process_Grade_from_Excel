package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class checkallgrade {
	 
		 public static void main(String[] args) throws IOException{
				
		     String line    = " ";
		     String splitBy = ",";
		     String grade = null;
		     FileReader fileRead = new FileReader( "class.csv" );
		     BufferedReader br   = new BufferedReader( fileRead );
		     int populate = -1;
		     int startLine = -1;
		     //HashMap for Checking All Student Grade
		 	 HashMap <String, String> studentIngrade= new HashMap<String, String>();
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
		         			grade = "A";
		         		}else if(studIngrade >= 80 && studIngrade < 90) {
		         			grade = "B";
		         		}else if(studIngrade >= 70 && studIngrade < 80) {
		         			grade = "C";
		         		}else if(studIngrade >= 65 && studIngrade < 70) {
		         			grade = "D";
		         		}else if(studIngrade < 65 && studIngrade > 0) {
		         			grade = "F";
		         	}	            	 
		            	 studentIngrade.put(reader[0], grade);
		             }		            
		             populate++;   		            
		         }		    			         
	        	//Print out All Student Grade
		         for( String key : studentIngrade.keySet()) {
		         System.out.println(key+"  Grade is: "+studentIngrade.get(key));
	        	 }
		 }
}