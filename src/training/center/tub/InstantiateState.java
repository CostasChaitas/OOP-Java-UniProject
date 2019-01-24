package training.center.tub;
import training.center.tub.Controllers.GenericController;
import training.center.tub.Models.*;
import training.center.tub.Models.Class;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;


public final class InstantiateState {
	
	 private InstantiateState() {
	      // this is never run
	 }
	
	
	public static GenericController<Student> getStudentControllerWithData() {
		//Instantiate Students and add them to a list
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Student> students = new ArrayList<Student>();
		GenericController<Student> StudentController = new GenericController<Student>();

		try {
			Student student1 = new Student(1, "George", "Bush", df.parse("08-05-1992") , "Alexander Platz" , "Berlin", 12415, "Germany");
			Student student2 = new Student(2, "Nick", "Klinton", df.parse("12-05-1981"), "Admiral Str" , "Hamburg", 11355, "Germany");
			Student student3 = new Student(3, "Peter", "Trump", df.parse("16-11-1997"), "Potsdamer" , "Dresden", 10655, "Germany");
			Student student4 = new Student(4, "John", "Tonic", df.parse("22-10-1961"), "Tempelhof" , "Berlin", 11011, "Germany");
			Student student5 = new Student(5, "Paul", "Floy", df.parse("13-01-1974"), "Mitte" , "Berlin", 13021, "Germany");
			
			students.add(student1);
			students.add(student2);
			students.add(student3);
			students.add(student4);
			students.add(student5);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StudentController.addItems(students);
		//System.out.println("The students are: " + StudentController.getItems());
		
		return StudentController;
	}
	
	public static GenericController<Course> getCourseControllerWithData() {
		//Instantiate Courses and add them to a list
		DateFormat df = new SimpleDateFormat("hh:mm");
		df.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
		
		ArrayList<Course> courses = new ArrayList<Course>();
		GenericController<Course> CourseController = new GenericController<Course>();
		
		try {
			Course course1= new Course(1, "Mathematics", "Advanced", 100.0, df.parse("08:00") );
			Course course2 = new Course(2, "Physics", "Easy", 120.0, df.parse("10:00") );
			Course course3 = new Course(3, "Programming", "Medium", 90.0, df.parse("10:00") );
			Course course4 = new Course(4, "Philoshopy", "Advanced", 140.0, df.parse("11:00") );
			Course course5 = new Course(5, "English", "Easy", 70.0, df.parse("12:00") );			
		
			courses.add(course1);
			courses.add(course2);
			courses.add(course3);
			courses.add(course4);
			courses.add(course5);	
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CourseController.addItems(courses);
		//System.out.println("The courses are: " +CourseController.getItems());
		
		return CourseController;
		
	}
	
	
	public static GenericController<Tutor> getTutorControllerWithData() {
		//Instantiate Tutors and add them to a list
		Tutor tutor1 = new Tutor(1, "Max", "Lee", 25, 55000 );
		Tutor tutor2 = new Tutor(2, "Jon", "Gas", 34, 45000 );
		Tutor tutor3 = new Tutor(3, "Dimitri", "Lee", 36, 65000 );
		Tutor tutor4 = new Tutor(4, "Leo", "Bezos", 38, 72000 );
		Tutor tutor5 = new Tutor(5, "Steve", "Jobs", 29, 49000 );
		
		ArrayList<Tutor> tutors = new ArrayList<Tutor>();
		tutors.add(tutor1);
		tutors.add(tutor2);
		tutors.add(tutor3);
		tutors.add(tutor4);
		tutors.add(tutor5);
		
		GenericController<Tutor> TutorController = new GenericController<Tutor>();
		TutorController.addItems(tutors);
		//System.out.println("The tutors are: " + TutorController.getItems());
		
		return TutorController;
	}
	
	
	public static GenericController<Class> getClassControllerWithData() {
		//Instantiate Classes and add them to a list
		Class class1 = new Class(1, 101 );
		Class class2 = new Class(2, 131 );
		Class class3 = new Class(3, 153 );
		Class class4 = new Class(4, 134 );
		Class class5 = new Class(5, 128 );
	
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		classes.add(class2);
		classes.add(class3);
		classes.add(class4);
		classes.add(class5);
		
		GenericController<Class> ClassController = new GenericController<Class>();
		ClassController.addItems(classes);
		//System.out.println("The classes are: " + ClassController.getItems());
		
		return ClassController;
	}
	

}



