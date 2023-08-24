package basic.loop;

import java.util.Scanner;

public class BreakQuiz01 {

	public static void main(String[] args) {
		/*
        1. 2가지의 정수를 1~100사이의 난수를 발생시켜서 
         지속적으로 문제를 출제한 후 정답을 입력받으세요.
         사용자가 0을 입력하면 반복문을 탈출시키세요.
         
        2. 종료 이후에 정답 횟수와 오답 횟수를 각각 출력하세요.
       */
		int good = 0;
		int bad = 0;
		
		System.out.println("*** 연산 퀴즈 ***");
		System.out.println("종료하시려면 0을 입력해주세요");
		Scanner sc = new Scanner(System.in);		
		
		while (true) {
			int a = (int)(Math.random() * 100) + 1;
			int b = (int)(Math.random() * 100) + 1;
			boolean op = (int)(Math.random() * 2) == 1 ? true : false;
									
			int rt;
			if (op) {
				System.out.printf("%d - %d = ?\n", a, b);
				rt = a - b;
			}
			else {
				System.out.printf("%d + %d = ?\n", a, b);
				rt = a + b;
			}
			
			System.out.print("> ");
			int answer = sc.nextInt();
			
			if (answer == 0) {
				System.out.println("종료합니다.");
				break;
			}
			else if (answer == rt) {
				System.out.println("정답입니다!");
				good++;
			}
			else {
				System.out.println("틀렸습니다~");
				bad++;
			}
		}
		System.out.println("----------------");
		System.out.printf("정답 횟수: %d회\n", good);
		System.out.printf("오답 횟수: %d회\n", bad);
		
		sc.close();
	}
	

}
