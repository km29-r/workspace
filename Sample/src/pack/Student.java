package pack;

public class Student {
	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (0 <= score && score <= 100) {
			this.score = score;
		} else {
			this.score = 0;
		}
		this.score = score;
	}
}
