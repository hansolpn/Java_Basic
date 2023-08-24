package basic.loop;

import java.util.Scanner;

public class ForExample {

	public static void main(String[] args) {
		/*
		int i = 1;
		int total = 0;
		while (i <= 10) {
			total += i;
			
			i++;
		}
		 */
		
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			total += i;
		}
		System.out.println(total);
		
		// 1~200까지의 정수 중 6의 배수이면서 12의 배수는 아닌 수를
		//가로로 출력해 보세요.(for)
		for (int i = 1; i <= 200; i++) {
			if (i % 6 == 0 && i % 12 != 0) {
				System.out.print(i + " ");
			}
		}
		
		// 1~60000까지의 정수 중 177의 배수의 개수를 구해보세요
		int count = 0;
		for (int i = 1; i <= 60000; i++) {
			if (i % 177 == 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println(count);
		
		// 정수를 하나 입력받아서 입력받은 정수까지의 팩토리얼 값을 구하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요: ");
		int a = sc.nextInt();
		total = 1;
//		for (int i = 1; i <= a; i++) {
//			total *= i;
//		}
		for (int i = a; i >= 1; i--) {
			total *= i;
		}
		System.out.println(a + "!: " + total);
		
		sc.close();
	}

}
