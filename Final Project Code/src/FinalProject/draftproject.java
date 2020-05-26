package FinalProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

//	class student{
//	public int id;
//	public String firstName;
//	public String lastName;
//	private float quiz;
//	private float test1;
//	private float midterm;
//	private float test3;
//	private float finalex;
//	private float present;
//	private float coding;
////	int id,String firstName,String lastName,float quiz,float test1,float midterm,float test3,float finalex,float present,float coding
//	public student(int id) {
//		this.id=id;
////		this.firstName=firstName;
////		this.lastName=lastName;
////		this.quiz=quiz;
////		this.test1=test1;
////		this.midterm=midterm;
////		this.test3=test3;
////		this.finalex=finalex;
////		this.present=present;
////		this.coding=coding;
//	}
//	void setid(int id) {
//		
//		
//	}
//	
//	
//	}
//	

public class draftproject {
	
	 public static void main(String[] args) throws IOException {
		
	     String line    = " ";
	     String splitBy = ",";
	     // read input by Scan
	     //Scanner scan = new Scanner(System.in);
	     //String fileInput = scan.nextLine();
	       
	     //read input by swing
	     String fileInput = JOptionPane.showInputDialog("Enter you file Path: ");
	     //System.out.println("Path for file: " + fileInput);
	     //Libraries\Documents
	     //try{
	         FileReader fileRead = new FileReader( fileInput );
	         BufferedReader br   = new BufferedReader( fileRead );
	         int populate = -1;
	 		HashMap <String, String> studentMap= new HashMap<String, String>();
	 		HashMap <String, String> studentIngrade= new HashMap<String, String>();
	 		ArrayList <String> studentinfo = new ArrayList<String>();
//	         ArrayList <Integer> id = new ArrayList<Integer>();
//	         ArrayList <String> firstName = new ArrayList<String>();
//	         ArrayList <String> lastName = new ArrayList<String>();
	         ArrayList <Float> quiz = new ArrayList<Float>();
	         ArrayList <Float> test1 = new ArrayList<Float>();
	         ArrayList <Float> midterm= new ArrayList<Float>();
	         ArrayList <Float> test3 = new ArrayList<Float>();
	         ArrayList <Float> finalex = new ArrayList<Float>();
	         ArrayList <Float> present = new ArrayList<Float>();
	         ArrayList <Float> coding = new ArrayList<Float>();
	         
	         ArrayList <Float> ingrade = new ArrayList<Float>();

	         ArrayList <Float> classtotalave = new ArrayList<Float>();
	         
	         int startLine = -1;
	         while ( (line = br.readLine()) != null) {
	     	 
	        	 String[] reader = line.split( splitBy );
	        	 
	             if(populate>startLine) {

		        	 //System.out.print( reader[ 0 ] + " - "+ reader[1]+"  "+ reader[2]+" : "+ reader[3]+" : "+ reader[4]+" : "+ reader[5]+" : "+ reader[6]+" : "+ reader[7]+" : "+ reader[8]+" : "+ reader[9]);
		        	 String info = reader[1]+"  "+ reader[2]+" : "+ reader[3]+" : "+ reader[4]+" : "+ reader[5]+" : "+ reader[6]+" : "+ reader[7]+" : "+ reader[8]+" : "+ reader[9];
		        	 int tid = new Integer(reader[0]);
	            	 float qz = new Float(reader[3]);
	            	 float t1 = new Float(reader[4]);
	            	 float mid = new Float(reader[5]);
	            	 float t3 = new Float(reader[6]);
	            	 float fin = new Float(reader[7]);
	            	 float pre = new Float(reader[8]);
	            	 float cod = new Float(reader[9]);
	            	 
//	            	 id.add(tid);
//	            	 firstName.add(reader[1]);
//	            	 lastName.add(reader[2]);
	            	 quiz.add(qz);
	            	 test1.add(t1);
	            	 midterm.add(mid);
	            	 test3.add(t3);
	            	 finalex.add(fin);
	            	 present.add(pre);
	            	 coding.add(cod);
 
	            	 //Grade student individualy
	            	 float studIngrade = (float) (qz*0.2+t1*0.2+mid*0.6+t3/3+fin*0.8+pre+cod);
	            	 //Total Average 
	            	 classtotalave.add(studIngrade);
//	            	 float studIngrade2 = studIngrade;
	            	 
	            	 studentIngrade.put(reader[0], String.format("%.2f", studIngrade));
	            	

	            	 studentMap.put(reader[0], info);
	            	 
	            	 //System.out.println(info);
	             }
	             //System.out.println();
	             
	             populate++;   
	             
	         }
	         
	         
        	
        	 float totalave = 0;
        	 for (float ave : classtotalave) {
        		 totalave += ave ;
        	 }
        	 System.out.println("Total ave 1 :" +totalave/populate);
	         
	         //Class Quiz Total Average
	         float quizTotal = 0;
	         for(  float qt : quiz) {
	        	 quizTotal += qt;
		         
	         }
//	         System.out.println(quizTotal);
	         float quizTotalAverage = (float) (quizTotal*0.2/populate);
	         
	         //Class Test1 Total Average
	         float test1Total = 0;
	         for(  float t1 : test1) {
	        	 test1Total += t1;
		         
	         }
//	         System.out.println(test1Total);
	         float test1TotalAverage = (float) (test1Total*0.2/populate);
	         
	         //Class Mid-term Total Average
	         float midtermTotal = 0;
	         for( float mid : midterm) {
	        	 midtermTotal += mid;
//		         System.out.println(midtermTotal);
	         }
//	         System.out.println(midtermTotal);
	         float midtermTotalAverage = (float) (midtermTotal*0.6/populate);

	         //Class Test3 Total Average
	         float test3Total = 0;
	         for( float t3 : test3 ) {
	        	 test3Total += t3;
	         }
//        	 System.out.println(test3Total);
	         float test3TotalAverage = (float) (test3Total/3/populate);
	         
	         //Class Final Total Average
	         float finalTotal = 0;
	         for( float fl : finalex ) {
	        	 finalTotal += fl;
	         }
//        	 System.out.println(finalTotal);
	         float finalTotalAverage = (float) (finalTotal*0.8/populate);
	         
	         //Class Presentation Total Average
	         float presentationTotal = 0;
	         for( float p1 : present ) {
	        	 presentationTotal += p1;
	         }
//        	 System.out.println(presentationTotal);
	         float presentationTotalAverage = (float) (presentationTotal/2*0.02*100/populate);
	         
	         //Class CodingProject Total Average
	         float codingProjectTotal = 0;
	         for( float cp1 : coding ) {
	        	 codingProjectTotal += cp1;
	         }
//        	 System.out.println(codingProjectTotal);
	         float codingProjectTotalAverage = (float) (codingProjectTotal/6*0.06*100/populate);
	         
	         // Class Total Average
//	         System.out.println(quizTotalAverage);
//		  	 System.out.println(test1TotalAverage);
//		  	 System.out.println(midtermTotalAverage);
//		  	 System.out.println(test3TotalAverage);
//		  	 System.out.println(finalTotalAverage);
//		  	 System.out.println(presentationTotalAverage);
//		  	 System.out.println(codingProjectTotalAverage);
	         float classTotalAverage = (quizTotalAverage + test1TotalAverage + midtermTotalAverage + test3TotalAverage + finalTotalAverage + presentationTotalAverage + codingProjectTotalAverage);
	         System.out.println("Class Total Average is : "+ String.format("%.2f", classTotalAverage));
	         
	         // Grade student individualy 
	         

	         
	         
		  	 
	         System.out.println(studentMap);
	         System.out.println(studentIngrade);
 	         System.out.println("This class has "+ populate+" students.");
//	         System.out.println(id+""+firstName+""+lastName+""+quiz+ ""+test1+""+midterm+""+test3+""+finalex+""+present+""+coding);
	 }
}
	     
