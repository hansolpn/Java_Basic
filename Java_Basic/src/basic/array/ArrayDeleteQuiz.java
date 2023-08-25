package basic.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeleteQuiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] kakao = {"무지", "네오", "아파치", "라이언" ,"춘식이"};

		/*
		 1. 삭제할 친구를 입력받아서 삭제를 진행해 주세요.

		 2. 입력받은 이름이 없다면 없다고 애기해 주세요.

		 - 추가
		 배열의 길이가 0이 될때까지 삭제를 반복해 보세요.
		 더 이상 지울 친구가 없다면 프로그램 종료
		 */

		while (true) {
			System.out.println("현재 저장된 친구들: " + Arrays.toString(kakao));

			if (kakao.length == 0) {
				System.out.println("더 이상 지울 친구가 없어요...");
				break;
			}

			System.out.print("삭제를 원하는 친구를 입력하세요: ");
			String name = sc.next();

			int i = 0;
			for (/*i=i*/; i < kakao.length; i++) {
				if (kakao[i].equals(name)) {
					System.out.println("삭제할 친구: " + kakao[i]);
					break;
				}
			}

			if (i == kakao.length) {
				System.out.println("해당하는 이름의 친구가 없습니다");
			}
			else {
				// 삭제되는 값을 기준으로 뒤에 있는 값을 한 칸씩 앞으로 땡기는 작업.
				for (/*i=i*/; i < kakao.length - 1; i++) {
					kakao[i] = kakao[i + 1];
				}

				// 기존의 배열보다 크기가 하나 작은 새 배열을 생성.
				String[] temp = new String[kakao.length - 1];

				// 원본 배열의 값을 새 배열에 인덱스에 맞취서 그대로 대입
				for (i = 0; i < temp.length; i++) {
					temp[i] = kakao[i];
				}

				// temp의 주소를 kakao에 주기
				kakao = temp;
				temp = null;
			}
		}

		//System.out.println("현재 저장된 친구들: " + Arrays.toString(kakao));
		sc.close();
	}

}
