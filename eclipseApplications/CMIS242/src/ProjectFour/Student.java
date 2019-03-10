package ProjectFour;

/**
 * 
 * 
 * File Name : Student.java
 * Author : Sean Hamilton
 * Date: 03/04/2019
 * Purpose of program: Project 4 CMIS 242 UMUC. This class defines the student record. Includes all necessary variables and methods per requirements.  
 * 
 * 
 *
 */

public class Student {
	
	//Instance variables declared private per requirements.
	private String studentName;
	private String studentMajor;
	private double creditsCompleted;
	private double qualityPoints; 
	
	//Getters and Setters.
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentMajor() {
		return studentMajor;
	}


	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}


	public double getCreditsCompleted() {
		return creditsCompleted;
	}


	public void setCreditsCompleted(double creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}


	public double getQualityPoints() {
		return qualityPoints;
	}


	public void setQualityPoints(double qualityPoints) {
		this.qualityPoints = qualityPoints;
	}

	
	//constructor per requirements.
	public Student(String studentName, String studentMajor) {
		
		this.studentName = studentName;
		this.studentMajor = studentMajor;
		this.creditsCompleted = 0;
		this.qualityPoints = 0;
		
		
	}
	
	//Course completed method per requirements.
	public void courseCompleted(String courseGrade, Double creditHours){
		
		Double qp = null;
		
		if(courseGrade.equals("A")) {
			qp = 4.0;
		}
		if(courseGrade.equals("B")) {
			qp = 3.0;
		}
		if(courseGrade.equals("C")) {
			qp = 2.0;
		}
		if(courseGrade.equals("D")) {
			qp = 1.0;
		}
		if(courseGrade.equals("F")) {
			qp = 0.0;
		}
		this.setQualityPoints((creditHours*qp)+this.getQualityPoints());
		this.setCreditsCompleted(creditHours+this.getCreditsCompleted());

		
	}
	
	//ToString method per requirement.
	public String studentToString() {
		
		Double GPA = null;
		
		if(this.getCreditsCompleted() == 0) {
			 GPA = 4.0;
		}else {
			 GPA = this.getQualityPoints()/this.getCreditsCompleted();
		}
		
		
		return "Student Name: " + this.getStudentName() + ", Student Major: " + this.getStudentMajor() + ", Student GPA: " + GPA;
		
		
	}

}
