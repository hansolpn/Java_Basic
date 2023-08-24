package basic.loop;

public class ForQuiz01 {

	public static void main(String[] args) {
		// 2 ~ 19까지의 난수를 생성하셔서 구구단을 출력해 보세요.
		// 19행까지 출력하세요
		int dan = (int)(Math.random() * 18) + 2;
		
		System.out.println(dan + " 단");
		for (int row = 1; row <= 19; row++) {
			System.out.printf("%d * %d = %d\n", dan, row, dan * row);
		}

	}

}
