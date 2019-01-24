package training.center.tub.Controllers;
import training.center.tub.Models.StudentCourse;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class StudentCourseController {
	
	//Singleton Pattern
	private static StudentCourseController instance = new StudentCourseController();
	private StudentCourseController(){}
	public static StudentCourseController getInstance(){
		return instance;
	}
	
	//Variables
	private static final AtomicInteger count = new AtomicInteger(0); 
	private static ArrayList<StudentCourse> studentCourseList= new ArrayList<StudentCourse>();
	
	//Methods
	public ArrayList<StudentCourse> getStudentCourseList(){
		return studentCourseList;
	}
	
	public void addOneStudentToOneCourse(int studentId, int courseId) {
		//Check if student is already assigned to the course
		if(!isDuplicate(studentId, courseId)) {
			StudentCourse newStudentCourse = new StudentCourse(count.incrementAndGet() , studentId, courseId);
			studentCourseList.add(newStudentCourse);
		}
	}
	
	
	public ArrayList<StudentCourse> getStudentsByCourse(int courseId ){

		ArrayList<StudentCourse> newStudentCourseList = new ArrayList<StudentCourse>();
		
		for (StudentCourse item : studentCourseList) {
            if (item.getCourseId() == courseId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}
	
	
	public ArrayList<StudentCourse> getCoursesByStudent(int studentId ){

		ArrayList<StudentCourse> newStudentCourseList = new ArrayList<StudentCourse>();
		
		for (StudentCourse item : studentCourseList) {
            if (item.getStudentId() == studentId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}
	
	//Check if Tutor is already assigned to the course
	private boolean isDuplicate(int studentId, int courseId){		
		for(StudentCourse studentCourse: studentCourseList) {
			if(studentCourse.getStudentId() == studentId && studentCourse.getCourseId() == courseId ) {
				System.out.println("Student " + studentId + " is already assigned for the course  " + courseId );
				return true;
			}
		}
		return false;
	}
	
//	StudentCourseController.addOneToOne(student, course);
//	StudentCourseController.addManyToOne(List student, course)
//	StudentCourseController.addOneToMany(student, List course)

}
