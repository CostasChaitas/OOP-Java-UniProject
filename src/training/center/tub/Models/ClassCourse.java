package training.center.tub.Models;

public class ClassCourse {
	private int id;
	private int classId;
	private int courseId;
	
	public ClassCourse(int id, int classId, int courseId) {
		this.id = id; 
		this.classId = classId;
		this.courseId = courseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "ClassCourse [id=" + id + ", classId=" + classId + ", courseId=" + courseId + "]";
	}

}
