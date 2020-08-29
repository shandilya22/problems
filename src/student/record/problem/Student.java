package student.record.problem;

public class Student {
	private int rollNo;
	private int score;
	
	public Student(int rollNo, int score) {
		this.rollNo = rollNo;
		this.score  = score;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return rollNo + "," + score;
	}
	
}
