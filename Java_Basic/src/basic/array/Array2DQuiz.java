package basic.array;

public class Array2DQuiz {

	public static void main(String[] args) {

		int[][] score = {
				{79, 80, 99}, //A학생
				{95, 85, 89}, //B학생
				{90, 65, 56}, //C학생
				{69, 78, 77}  //D학생
				//과목: 3과목
		};
		String[] stuName = {"A학생", "B학생", "C학생", "D학생"};
		String[] subName = {"국어", "영어", "수학"};

		/*
        1. 각 학생의 평균을 소수점 첫째 자리까지 출력해 보세요.
        2. 각 과목의 평균을 출력해 보세요.
        3. 반 평균을 출력해 보세요. (모든 학생들의 평균을 더해서 학생수로 나누기)
		*/
		
		double avgTotalStu = 0; // 모든 학생들의 평균의 총합
		// 1번 문제
		for (int i = 0; i < score.length; i++) {
			int total = 0;
			for (int j = 0; j < score[i].length; j++) {
				total += score[i][j];
			}
			double avgStu = total / 3.0;
			avgTotalStu += avgStu;
			System.out.printf("%s의 평균: %.1f점\n", stuName[i], avgStu);
		}
		
		System.out.println("--------------------");
		// 2번 문제
		int[] totalScoreSub = new int[3]; // 과목의 총합
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				totalScoreSub[j] += score[i][j];
			}
		}
		for (int i = 0; i < totalScoreSub.length; i++) {
			System.out.printf("%s의 평균: %.1f점\n", subName[i], totalScoreSub[i] / 4.0);
		}
		
		System.out.println("--------------------");
		// 3번 문제
		System.out.printf("반 평균: %.1f점\n", avgTotalStu / 4.0);
	}

}
