package etc.api.lang.wrapper;

import java.time.LocalDate;
import java.util.Scanner;

public class ParseQuiz {

	public static void main(String[] args) {
		/*
		 주민등록번호를 입력받아서 다음과 같은 정보를 추출하여 출력합니다.

		ex) 입력값: 921013-1234567
		출력값: 1992년 10월 13일 31세 남자 

		입력값: 040906-4123456
		출력값: 2004년 9월 6일 19세 여자 

		입력값은 하이픈이 포함된 문자열이어야 합니다. 
		하이픈이 포함되어 있지 않거나, 주민등록번호 뒷자리 첫번째 숫자가 1,2,3,4가 아닐 시에는 다시 입력받아야 합니다.
		또한 하이픈을 제외한 값이 숫자가 아닐 시에도 다시 입력받아 주시면 됩니다.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호를 입력해주세요.(하이픈 포함)");
		System.out.print("> ");

		int year;
		int month;
		int day;
		int sex;

		while (true) {
			String pNum = sc.next();
			pNum = pNum.trim();

			if (pNum.length() != 14 || pNum.indexOf("-") != 6) {
				System.out.println("주민번호를 하이픈 포함해서 14자를 입력해주세요.");
				System.out.println("다시 입력해주세요!");
				System.out.print("> ");
				continue;
			}

			try {
				String[] temp = pNum.split("-");

				if (temp.length != 2) {
					System.out.println("하이픈이 너무 많습니다.");
					System.out.println("다시 입력해주세요!");
					System.out.print("> ");
					continue;
				}
				Integer.parseInt(temp[0]);
				Integer.parseInt(temp[1]);

				year = Integer.parseInt(temp[0].substring(0, 2));
				month = Integer.parseInt(temp[0].substring(2, 4));
				day = Integer.parseInt(temp[0].substring(4, 6));
				sex = Integer.parseInt(temp[1].substring(0, 1));
			}
			catch (NumberFormatException e) {
				System.out.println("숫자가 아닌 문자가 포함되어 있습니다.");
				System.out.println("다시 입력해주세요!");
				System.out.print("> ");
				continue;
			}

			if (sex < 1 || sex > 4) {
				System.out.println("주민등록번호 뒷자리 첫번째 숫자가 1,2,3,4가 아닙니다.");
				System.out.println("다시 입력해주세요!");
				System.out.print("> ");
				continue;
			}

			//System.out.printf("%d, %d, %d, %d \n", year, month, day, sex);
			break;
		}

		System.out.println(makeMessage(year, month, day, sex));

		sc.close();

	}

	private static StringBuilder makeMessage(int year, int month, int day, int sex) {
		StringBuilder msg = new StringBuilder();

		if (sex == 1 || sex == 2) {
			year = 1900 + year;
		}
		else {
			year = 2000 + year;
		}

		msg.append(year + "년 ");
		msg.append(month + "월 ");
		msg.append(day + "일 ");

		LocalDate now = LocalDate.now();
		int age = now.getYear() - year;

		msg.append(age + "세 ");

		switch (sex) {
		case 1:
		case 3:
			msg.append("남자");
			break;
		case 2:
		case 4:
			msg.append("여자");
			break;
		}
		return msg;
	}

}
