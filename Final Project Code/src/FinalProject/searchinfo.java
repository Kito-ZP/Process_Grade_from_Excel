package FinalProject;
import java.util.*;
import java.io.*;
public class searchinfo{			
		 public static void main(String[] args) throws IOException{				
		     String line    = " ";
		     String splitBy = ",";
		     Scanner scan = new Scanner(System.in);
		     String grade = null;
		     FileReader fileRead = new FileReader( "class.csv" );
		     BufferedReader br   = new BufferedReader( fileRead );
		     int populate = -1;
		     int startLine = -1;
		     //HashMap for Checking Individual Student info 
		     HashMap <String, String> studentInfo= new HashMap<String, String>();
		 	 //Define a Headline
		     ArrayList <String> headline = new ArrayList<String>();
		    	  while ( (line = br.readLine()) != null) {		     	 
		        	 String[] reader = line.split( splitBy );		        	 
		        	 if(populate == startLine) {
//		        		 String head = "   "+reader[ 0 ] + "   -           "+reader[1]+"         "+ reader[2]+": "+ reader[3]+" : "+ reader[4]+" : "+ reader[5]+" : "+ reader[6]+" : "+ reader[7]+" : "+ reader[8];		        		 
		        		 headline.add("   ID   ");
		        		 headline.add("         Name          ");
		        		 headline.add(" Quiz ");
		        		 headline.add("Test-1 ");
		        		 headline.add("Mid-Term ");
		        		 headline.add("Test-3 ");
		        		 headline.add("   Final   ");
		        		 headline.add("Presentation ");
		        		 headline.add("Coding ");
		        		 headline.add("  Grade  "); 
		        	 }
		             if(populate>startLine) {
		            	 String info = reader[ 0 ] + " - "+reader[1]+"   "+ reader[2]+" :   "+ reader[3]+"  :   "+ reader[4]+"   :    "+ reader[5]+"    :   "+ reader[6]+"   :     "+ reader[7]+"     :      "+ reader[8]+"       :    "+ reader[9];
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
		            	 String info2 = info +"   :     "+ grade;
		            	 //Insert Student Info into StudentInfo HashMap
		            	 studentInfo.put(reader[0], info2);		            	 		            	 
		             }		            
		             populate++;   		            
		         }		    	  		   
		         //Search Info Data Part
	        	 System.out.println("Enter Student ID Number :");
	        	 String idNumber = scan.nextLine();
	        	 System.out.println(headline);
	        	 System.out.println(studentInfo.get(idNumber));
		 }//End of main
		 
	}

