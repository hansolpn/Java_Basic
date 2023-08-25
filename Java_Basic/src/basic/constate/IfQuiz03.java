package basic.constate;

import java.util.Scanner;

public class IfQuiz03 {

	public static void main(String[] args) {
		/*
        - 정수 3개를 입력 받습니다.
        - 가장 큰 값, 가장 작은 값, 중간값을 구해서 출력해 보세요.
        
        # max, mid, min이라는 변수를 미리 선언하셔서
         판별이 될 때마다 각각의 변수에 값을 넣어줍니다.
         마지막에 한번에 출력하시면 되겠습니다.
        */
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int max;
		int mid;
		int min;
		
		if (a > b) {
			if (a > c) {
				// a가 가장 큼
				max = a;
				if (b > c) {
					mid = b;
					min = c;
				}
				else {
					mid = c;
					min = b;
				}				
			}
			else {
				// a > b
				// a < c
				// c > a > b
				max = c;
				mid = a;
				min = b;
			}
		}
		else {
			// b > a
			if (b > c) {
				// b가 가장 큼
				max = b;
				if (a > c) {
					mid = a;
					min = c;
				}
				else {
					mid = c;
					min = a;
				}
			}
			else {
				// b > a
				// b < c
				// c > b > a
				max = c;
				mid = b;
				min = a;
			}
		}
		System.out.printf("가장 큰 값: %d, 가장 작은 값: %d, 중간값: %d\n", max, mid, min);
		sc.close();

	}

}
