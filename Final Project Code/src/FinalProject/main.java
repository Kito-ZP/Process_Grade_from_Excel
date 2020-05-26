package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {
	
	 public static void main(String[] args) throws IOException{			
	     String line    = " ";
	     String splitBy = ",";
	     Scanner scan = new Scanner(System.in);
	     int countA = 0;
    	 int countF = 0;
    	 FileReader fileRead = new FileReader( "class.csv" );
	     BufferedReader br   = new BufferedReader( fileRead );
	     int populate = -1;
	     int startLine = -1;
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
	         			countA++;
	         		}else if(studIngrade < 65 && studIngrade > 0) {
	         			countF ++;
	         	}
	             }	            
	             populate++;   	            
	         }
	     	 System.out.println("This class has "+ populate+" students.");
	     	 System.out.println("Class has "+countA+" students get 'A' and " + countF +" students get 'F'.");
	    	 System.out.println("Do you want to Check Class Total Average? Y/N");
	    	 String checkaverage = scan.next();	      
	         while(checkaverage.equalsIgnoreCase("y")) {
	        	 ClassTotalAverage.main(null);	
	        	 break;
	         }
	    	 System.out.println("Type 'all' to check all student grade or Enter'N' for skip ");
	    	 String checkallstudentgrade = scan.next();	      
	    	 while(checkallstudentgrade.equalsIgnoreCase("all")) {
	    		 checkallgrade.main(null);
	    		 break;
	    	 }
	    	//Search Info Data Part
	    	 System.out.println("Do you want to search individual student information? Y/N");
	    	 String checkstudentinfo = scan.next();
	    	 while(checkstudentinfo.equalsIgnoreCase("Y")) {
	    			 searchinfo.main(null);
	    	    	 System.out.println("Check another one? Y/N");
	    	    	 if(scan.next().equalsIgnoreCase("n")) {
	    	    		 break;
	    	    	 }
	    	    	 }       	 
        	 
        	 //Export Student Grade
	    	 System.out.println("Do you want to export CSV for Student ID & Grade? Y/N");
	    	 String exportCSV = scan.next();
	    	 if(exportCSV.equalsIgnoreCase("Y")){        	         
	    	 for(int i = 0 ;i < 100 ;i++) {
		    	 System.out.println("Exporting CSV File..."+i+"% ");
	    	 }
	    	 Export_CSV.main(null);
	    	 System.out.println("Export CSV File Failed!");
	    	 System.out.println("Just kidding Lmao :P    CSV File export successfully! ");
	    	 System.out.println("Hopefully, I can get a A or A+ grade~");
	    	 System.out.println("I really appreciate you teach me in this semester !");
	    	 System.out.println(" ");
	    	 System.out.println("			by ZHIWEN PAN");
	    	 }else {
	    		 System.out.print("Program is Finish. Have you try Export CSV file?");
	    	 }        	 
	 }//End of main
	 
}

