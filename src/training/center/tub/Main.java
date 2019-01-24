package training.center.tub;
import training.center.tub.Controllers.*;
import training.center.tub.Models.*;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ParseException {
		// Create data/objects(Students, Courses ...) and return the controllers
		GenericController<Course> CourseController = InstantiateState.getCourseControllerWithData();
		GenericController<Tutor> TutorController = InstantiateState.getTutorControllerWithData();

		// Instantiate the controllers for the relations
		StudentCourseController StudentCourseControllerInstance = StudentCourseController.getInstance();
		TutorCourseController TutorCourseControllerInstance = TutorCourseController.getInstance();
		ClassCourseController ClassCourseControllerInstance = ClassCourseController.getInstance();
		
		//Adding Student-Course Relations 
		StudentCourseControllerInstance.addOneStudentToOneCourse(2, 4);
		StudentCourseControllerInstance.addOneStudentToOneCourse(2, 2);
		StudentCourseControllerInstance.addOneStudentToOneCourse(3, 2);
		StudentCourseControllerInstance.addOneStudentToOneCourse(1, 2);
		StudentCourseControllerInstance.addOneStudentToOneCourse(4, 1);
		// Wrong! A Student can be assigned to a course only one time
		//StudentCourseController.addOneStudentToOneCourse(3, 2);
		//System.out.println("Student/Course List" + StudentCourseController.getStudentCourseList());
		
		//Adding Tutor-Course Relations 
		TutorCourseControllerInstance.addOneTutorToOneCourse(1, 3);
		TutorCourseControllerInstance.addOneTutorToOneCourse(3, 4);
		TutorCourseControllerInstance.addOneTutorToOneCourse(1, 5);
		TutorCourseControllerInstance.addOneTutorToOneCourse(3, 2);
		TutorCourseControllerInstance.addOneTutorToOneCourse(4, 1);
		// Wrong! One Tutor can deal with many Courses but not at the same time zone
		//TutorCourseController.addOneTutorToOneCourse(1, 2);
		//System.out.println("Tutor/Course List" + TutorCourseController.getTutorCourseList());
		
		//Adding Class-Course Relations 
		ClassCourseControllerInstance.addOneClassToOneCourse(1, 3);
		ClassCourseControllerInstance.addOneClassToOneCourse(3, 4);
		ClassCourseControllerInstance.addOneClassToOneCourse(1, 5);
		ClassCourseControllerInstance.addOneClassToOneCourse(3, 2);
		ClassCourseControllerInstance.addOneClassToOneCourse(4, 1);
		// Wrong! One Tutor can deal with many Courses but not at the same time zone
		//ClassCourseController.addOneClassToOneCourse(1, 2);
		//System.out.println("Tutor/Course List" + ClassCourseController.getClassCourseList());

		
		// ***QUESTION 1***
		//How many Students are enrolled on a particular Course?
		//StudentCourseController.getStudentsByCourse(courseId);
		int numOfStudentsInCourse2 = 0;
		for (@SuppressWarnings("unused") StudentCourse studentCourse: StudentCourseControllerInstance .getStudentsByCourse(2)) {
			numOfStudentsInCourse2++;
		}
		System.out.println("Q1, How many Students are enrolled on a particular Course(e.g course 2): " + numOfStudentsInCourse2 );
		//Find ALl courses for a student
		//System.out.println(StudentCourseController.getCoursesByStudent(2));
		
		//Find All tutors for a course
		//System.out.println(TutorCourseController.getTutorsByCourse(3));
		//Find ALl courses for a tutor
		//System.out.println(TutorCourseController.getCoursesByTutor(1));
		
		//Find All classes for a course
		//System.out.println(ClassCourseController.getClassesByCourse(3));
		//Find ALl courses for a class
		//System.out.println(ClassCourseController.getCoursesByClass(1));
		// *** END QUESTION 1***

		
		// ***QUESTION 2***
		//The list of Students in each course and its Tutor and Course information (Level and Price)
		for( Course course : CourseController.getItems() ) {
			ArrayList<StudentCourse> students = StudentCourseControllerInstance .getStudentsByCourse(course.getCourseId());
			ArrayList<TutorCourse> tutors = TutorCourseControllerInstance .getTutorsByCourse(course.getCourseId());
			System.out.println("Q2, The students for " + course  + " at " + course.getCourseTimezone() + " and price " + course.getCoursePrice()  + " and level " + course.getCourseLevel() + " are " + students + " and the tutor " + tutors);
		}
		// ***END QUESTION 2***

		
		// ***QUESTION 3***
		//The total expensive of the center which will include:
		//Tutors salary + benefit (Extra hours) + Tax.
		double totalTutorsSalaryWithoutTax = 0.0;
		double totalTutorsSalaryWithTax = 0.0;
		double rentingTrainingCenter = 120000;
		double managementExpensive = 35000;
		double otherExpensive = 12000;
		for( Tutor tutor : TutorController.getItems() ) {
			totalTutorsSalaryWithoutTax += tutor.getSalary();
			totalTutorsSalaryWithTax += tutor.getSalary() + tutor.getSalary() * 19/100;
		}
		System.out.println("Q3, Summary of all tutors salary without tax is: " + totalTutorsSalaryWithoutTax);
		System.out.println("Q3, Summary of all tutors salary with tax 19% is: " + totalTutorsSalaryWithTax);
		double totalExpensesWithoutTax = totalTutorsSalaryWithoutTax + rentingTrainingCenter + managementExpensive + otherExpensive;
		double totalExpensesWithTax = totalTutorsSalaryWithTax + rentingTrainingCenter + managementExpensive + otherExpensive;
		System.out.println("Q3, Summary of all expenses without tax is: " + totalExpensesWithoutTax);
		System.out.println("Q3, Summary of all expenses with tax 19% is: " + totalExpensesWithTax);
		// ***END QUESTION 3***
		
		
		// ***QUESTION 4***
		//4. The total income include all (the students income price + 19% Tax)
		double totalIncomeWithoutTax = 0.0;
		double totalIncomeWithTax = 0.0;
		for( StudentCourse studenCourse : StudentCourseControllerInstance .getStudentCourseList()) {
			double coursePrice = CourseController.getItem(studenCourse.getCourseId()).getCoursePrice();
			totalIncomeWithoutTax += coursePrice;
			totalIncomeWithTax += coursePrice + coursePrice * 19/100;
		}
		double avgCoursePriceWithTax = 0.0;
		int numOfTotalCourses = 0;
		for( @SuppressWarnings("unused") Course course : CourseController.getItems() ) {
			numOfTotalCourses++;
		}
		avgCoursePriceWithTax = totalIncomeWithTax / numOfTotalCourses;
		System.out.println("Q4, Total income without tax is: " + totalIncomeWithoutTax);
		System.out.println("Q4, Total income with tax is: " + totalIncomeWithTax);
		// ***END QUESTION 4***
		
		
		// ***QUESTION 5***
		//5. The profit or lost per year.	
		double profitWithoutTax = totalIncomeWithoutTax - totalExpensesWithoutTax ;
		double profitWithTax = totalIncomeWithTax - totalExpensesWithTax ;
		System.out.println("Q5, The total profit without tax is: " + profitWithoutTax);
		System.out.println("Q5, The total profit with tax 19% is: " + profitWithTax);
		// ***END QUESTION 5***
		
		
		// ***QUESTION 6***
		//6. How many Students the center must have at least in each course in order to be the center profitable.	
		System.out.println("Q6, Total number of courses is: " + numOfTotalCourses);
		System.out.println("Q6, Average price of a course with tax 19% is: " + avgCoursePriceWithTax);
		int numOfStudents = 0;
		while(totalExpensesWithTax - avgCoursePriceWithTax * numOfStudents > 0) {
			numOfStudents++;
		}
		System.out.println("Q6, Minimum number of students in order to be the center profitable is : " + numOfStudents);
		// ***END QUESTION 6***
		
		
		// MySQL Tasks //
		DBconnection.createDatabase();
	
		DBconnection.createTableInDB();
	
		DBconnection.insertStudentsToTable();
		
		DBconnection.getStudentsFromDB();
		
	}
		
}
