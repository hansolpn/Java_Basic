package oop.obj_arr;

/*
- 이름, 국어, 영어, 수학, 총점, 평균(double)을
 담을 수 있는 객체를 디자인하세요.

- 학생의 모든 정보를 한 눈에 확인할 수 있게
 scoreInfo() 메서드를 선언해 주세요.
 메서드 내부에는 출력문을 이용해서 모든 정보를 출력해 주세요.

- 캡슐화를 구현해서 작성해 주세요. (생성자는 맘대로 하세요.)
 */

public class Score {

	private String name;
	private int korean = -1;
	private int english = -1;
	private int math = -1;
	private int total = -1;
	private double avg = -1;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int score) {
		this.korean = score;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int score) {
		this.english = score;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int score) {
		this.math = score;
	}
	public int getTotal() {
		return total;
	}
	public double getAvg() {
		return avg;
	}

	private boolean isValidateScore(int score) {
		if (score < 0 || score > 100) {
			return false;
		}

		return true;

	}

	private boolean isValidateScore() {
		if (!isValidateScore(korean)) {
			return false;
		}
		if (!isValidateScore(english)) {
			return false;
		}
		if (!isValidateScore(math)) {
			return false;
		}

		return true;

	}
	public void calcTotalAvg() {
		if (!isValidateScore()) {
			System.out.println("국어, 영어, 수학에 올바른 점수가 들어있지 않습니다.");
			return;
		}

		total = korean + english + math;
		avg = total / 3.0;

	}

	public void scoreInfo() {
		if (!isValidateScore()) {
			System.out.println("국어, 영어, 수학에 올바른 점수가 들어있지 않습니다.");
			return;
		}

		if (total == -1 || avg == -1) {
			calcTotalAvg();
		}

		System.out.printf("이름:%s	국어:%d	영어:%d	수학:%d	총점:%d	평균:%.1f\n",
				name, korean, english, math, total, avg);
	}
}
