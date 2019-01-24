package training.center.tub.Models;

import java.util.Date;

public class Course {

	private int courseId;
	private String courseName;
	private String courseLevel;
	private double coursePrice;
	private Date courseTimezone;
	private final int maxStudents = 20;

	
	public Course( int courseId, String courseName, String courseLevel, double coursePrice, Date courseTimezone) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseLevel = courseLevel;
		this.coursePrice = coursePrice;
		this.courseTimezone = courseTimezone;
	}

	
    public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseLevel() {
		return courseLevel;
	}


	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}


	public double getCoursePrice() {
		return coursePrice;
	}


	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}


	public int getMaxStudents() {
		return maxStudents;
	}

	public Date getCourseTimezone() {
		return courseTimezone;
	}


	public void setCourseTimezone(Date courseTimezone) {
		this.courseTimezone = courseTimezone;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + "]";
	}


}
