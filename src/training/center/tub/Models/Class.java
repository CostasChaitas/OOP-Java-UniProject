package training.center.tub.Models;

public class Class {
	private int classId;
	private int classNumber;

	public Class(int classId, int classNumber) {
		this.classId = classId;
		this.classNumber = classNumber;
	}
	
	

	public int getClassId() {
		return classId;
	}



	public void setClassId(int classId) {
		this.classId = classId;
	}



	public int getClassNumber() {
		return classNumber;
	}



	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classId;
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
		Class other = (Class) obj;
		if (classId != other.classId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Class [classId=" + classId + "]";
	}
	

}
