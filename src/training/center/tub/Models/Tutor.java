package training.center.tub.Models;

public class Tutor {
	private int tutorId;
	private String firstName;
	private String lastName;
	private int age;
	private int salary;


	public Tutor(int tutorId, String firstName, String lastName, int age, int salary) {
		this.tutorId = tutorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}



	public int getTutorId() {
		return tutorId;
	}



	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tutorId;
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
		Tutor other = (Tutor) obj;
		if (tutorId != other.tutorId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + "]";
	}
}
