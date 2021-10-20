package cn.wsp.sms.domain;

public class Student {
	private int id;
	private String name;
	private String myclass;
	private double score;

	public Student() {
		super();
	}

	public Student(String name, String myclass, double score) {
		super();
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}

	public Student(int id, String name, String myclass, double score) {
		super();
		this.id = id;
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMyclass() {
		return myclass;
	}

	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", myclass=" + myclass + ", score=" + score + "]";
	}

}
