package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassTotalAverage {		
		 public static void main(String[] args) throws IOException{
				
		     String line    = " ";
		     String splitBy = ",";
		     FileReader fileRead = new FileReader( "class.csv" );
		     BufferedReader br   = new BufferedReader( fileRead );
		     int populate = -1;
		     int startLine = -1;

		     //Create ArrayList for collecting all student grade
		     ArrayList <Float> classtotalave = new ArrayList<Float>();	     

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
		            	 classtotalave.add(studIngrade);	            	
		         	}
		             populate++;   	
		             }		            
		    	//Calculate Class Total Grade
			         float totalave = 0;
		        	 for (float ave : classtotalave) {
		        		 totalave += ave ;
		        	 }		    	  		    	 	      	
	        	 System.out.println("Class Total Average is : "+ String.format("%.2f", totalave/populate));
		         }
		 }

    
