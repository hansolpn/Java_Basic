package basic.constate;

import java.util.Scanner;

public class SwitchQuiz01 {

	public static void main(String[] args) {
		/*
        - 정수를 하나 입력받고, 연산자를 하나 입력 받으세요.
         다시 정수를 입력받아서, 사용자가 선택한 연산자를 기준으로
         연산 결과를 출력해 주시면 됩니다. (switch문 사용)
         연산자가 잘못 입력되었다면 연산자를 똑바로 입력하라고
         결과를 말씀해 주세요.
        */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수1개 연산자1개 정수1개를 입력해주세요");
		int a = sc.nextInt();
		String b = sc.next();
		int c = sc.nextInt();
		
		switch (b) {
		case "+":
			System.out.printf("%d + %d = %d", a, c, a + c);
			break;
		case "-":
			System.out.printf("%d - %d = %d", a, c, a - c);
			break;
		case "*":
			System.out.printf("%d * %d = %d", a, c, a * c);
			break;
		case "/":
			if (c == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			}
			System.out.printf("%d / %d = %.2f", a, c, a / (double)c);
			break;
		case "%":
			if (c == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			}
			System.out.printf("%d %% %d = %d", a, c, a % c);
			break;
		default:
			System.out.println("연산자를 제대로 입력해 주세요!");
		}
		sc.close();
		
	}

}
