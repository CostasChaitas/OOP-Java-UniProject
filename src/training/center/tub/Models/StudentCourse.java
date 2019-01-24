package training.center.tub.Models;

public class StudentCourse {
	private int id;
	private int studentId;
	private int courseId;
	
	public StudentCourse(int id, int studentId, int courseId) {
		this.id = id; 
		this.studentId = studentId;
		this.courseId = courseId;
	}

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + "]";
	}

}
