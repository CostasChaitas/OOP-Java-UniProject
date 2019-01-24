package training.center.tub.Controllers;
import training.center.tub.InstantiateState;
import training.center.tub.Models.ClassCourse;
import training.center.tub.Models.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassCourseController {
	
	//Singleton Pattern
	private static ClassCourseController instance = new ClassCourseController();
	private ClassCourseController(){}
	public static ClassCourseController getInstance(){
		return instance;
	}
	
	//Variables
	private static final AtomicInteger count = new AtomicInteger(0); 
	private static ArrayList<ClassCourse> classCourseList= new ArrayList<ClassCourse>();
	GenericController<Course> CourseController = InstantiateState.getCourseControllerWithData();

	
	//Methods
	public ArrayList<ClassCourse> getClassCourseList(){
		return classCourseList;
	}
	
	public void addOneClassToOneCourse(int classId, int courseId) {
		//Check if student is already assigned to the course
		if(!this.isDuplicate(classId, courseId)) {
			//Check if Class is available at this time for the course
			if(this.isClassAvailableForCourse(classId, courseId)) {
				ClassCourse newClassCourse = new ClassCourse(count.incrementAndGet() , classId, courseId);
				classCourseList.add(newClassCourse);
			}
		}
	}
	
	
	public ArrayList<ClassCourse> getCoursesByClass(int classId ){

		ArrayList<ClassCourse> newStudentCourseList = new ArrayList<ClassCourse>();
		
		for (ClassCourse item : classCourseList) {
            if (item.getClassId() == classId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}
	
	
	public ArrayList<ClassCourse> getClassesByCourse(int courseId ){

		ArrayList<ClassCourse> newStudentCourseList = new ArrayList<ClassCourse>();
		
		for (ClassCourse item : classCourseList) {
            if (item.getCourseId() == courseId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}
	
	
	//One Class can have many Courses but not at the same time zone
	private boolean isClassAvailableForCourse(int classId, int courseId){
		Date courseTimezone = CourseController.getItem(courseId).getCourseTimezone();
		
		for(ClassCourse classCourse: classCourseList) {
			if(classCourse.getClassId() == classId) {
				Date busyCourseTimezone = CourseController.getItem(classCourse.getCourseId()).getCourseTimezone();
				if( courseTimezone.compareTo(busyCourseTimezone) == 0 ) {
					System.out.println("Class is booked at " + courseTimezone + "  with other course");
					return false;
				}
			}
		}
		return true;
	}
	
	//Check if Class is already assigned to the course
	private boolean isDuplicate(int classId, int courseId){		
		for(ClassCourse classCourse: classCourseList) {
			if(classCourse.getClassId() == classId && classCourse.getCourseId() == courseId ) {
				System.out.println("Class " + classId + " is already assigned for the course  " + courseId );
				return true;
			}
		}
		return false;
	}
	
}
