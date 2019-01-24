package training.center.tub.Controllers;
import training.center.tub.InstantiateState;
import training.center.tub.Models.Course;
import training.center.tub.Models.TutorCourse;

import java.util.Date;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class TutorCourseController {
	
	//Singleton Pattern
	private static TutorCourseController instance = new TutorCourseController();
	private TutorCourseController(){}
	public static TutorCourseController getInstance(){
		return instance;
	}
		
	//Variables
	private static final AtomicInteger count = new AtomicInteger(1); 
	private static ArrayList<TutorCourse> tutorCourseList= new ArrayList<TutorCourse>();
	GenericController<Course> CourseController = InstantiateState.getCourseControllerWithData();

	
	//Methods
	public ArrayList<TutorCourse> getTutorCourseList(){
		return tutorCourseList;
	}
	
	public void addOneTutorToOneCourse(int tutorId, int courseId ) {
		//Check if Tutor is already assigned to the course
		if(!this.isDuplicate(tutorId, courseId)) {
			//Check if Tutor is available at this time for the course
			if(this.isTutorAvailableForCourse(tutorId, courseId)) {
				TutorCourse newStudentCourse = new TutorCourse(count.incrementAndGet(), tutorId, courseId);
				tutorCourseList.add(newStudentCourse);
			}
		}
	}
	
	public ArrayList<TutorCourse> getTutorsByCourse(int courseId ){

		ArrayList<TutorCourse> newStudentCourseList = new ArrayList<TutorCourse>();
		
		for (TutorCourse item : tutorCourseList) {
            if (item.getCourseId() == courseId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}
	
	
	public ArrayList<TutorCourse> getCoursesByTutor(int tutorId ){

		ArrayList<TutorCourse> newStudentCourseList = new ArrayList<TutorCourse>();
		
		for (TutorCourse item : tutorCourseList) {
            if (item.getTutorId() == tutorId) {
            	newStudentCourseList.add(item);
            }
        }
		
		return newStudentCourseList;
	}

	//One Employee (Tutor) can deal with many Courses but not at the same time zone
	private boolean isTutorAvailableForCourse(int tutorId, int courseId){
		Date courseTimezone = CourseController.getItem(courseId).getCourseTimezone();
		
		for(TutorCourse tutorCourse: tutorCourseList) {
			if(tutorCourse.getTutorId() == tutorId) {
				Date busyCourseTimezone = CourseController.getItem(tutorCourse.getCourseId()).getCourseTimezone();
				if( courseTimezone.compareTo(busyCourseTimezone) == 0 ) {
					System.out.println("Tutor is busy at " + courseTimezone + "  with other course");
					return false;
				}
			}
		}
		return true;
	}
	
	//Check if Tutor is already assigned to the course
	private boolean isDuplicate(int tutorId, int courseId){		
		for(TutorCourse tutorCourse: tutorCourseList) {
			if(tutorCourse.getTutorId() == tutorId && tutorCourse.getCourseId() == courseId ) {
				System.out.println("Tutor " + tutorId + " is already assigned for the course  " + courseId );
				return true;
			}
		}
		return false;
	}
	

}
