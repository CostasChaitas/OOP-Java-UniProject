package training.center.tub.Models;

public class TutorCourse {
	private int id;
	private int tutorId;
	private int courseId;
	
	public TutorCourse(int id, int tutorId, int courseId) {
		this.id = id; 
		this.tutorId = tutorId;
		this.courseId = courseId;
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getTutorId() {
		return tutorId;
	}



	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "TutorCourse [id=" + id + ", tutorId=" + tutorId + ", courseId=" + courseId + "]";
	}

}
