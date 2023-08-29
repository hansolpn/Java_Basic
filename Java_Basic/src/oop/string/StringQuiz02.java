package oop.string;

import java.util.Scanner;

public class StringQuiz02 {

	public static void main(String[] args) {
		/*
        1. 주민등록번호 13자리를 입력받습니다.
        2. 주민등록번호는 -을 포함해서 받을 예정입니다.
        3. 13자리가 아니라면 다시 입력받습니다.
        4. 남자인지 여자인지를 구분해서 출력해 주시면 됩니다.
		 */
		Scanner sc = new Scanner(System.in);
		//"000000-1000000"
		while (true) {
			System.out.print("주민번호를 입력하세요(- 포함): ");
			String input = sc.next();
			input = input.trim();

			if (input.length() == 14) {
				int i = Integer.parseInt(input.substring(7, 8));

				switch (i) {
				case 1:
				case 3:
					System.out.println("남자입니다");
					break;
				case 2:
				case 4:
					System.out.println("여자입니다");
					break;
				default:
					System.out.println("???");
				}

				break;
			}
			else {
				System.out.println("주민번호를 다시 입력하세요");
			}
		}
		sc.close();

	}

}
