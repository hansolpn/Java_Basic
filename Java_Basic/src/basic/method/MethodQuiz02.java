package basic.method;

import java.util.Arrays;

public class MethodQuiz02 {

	static String[] foods = {"떡볶이", "치킨", "파스타"};

	//1. 배열의 맨 마지막 위치에 데이터를 추가하는 함수 (push -> void)
	//기존 배열보다 크기가 하나 큰 배열을 선언해서 값 고대로 내리기
	//매개값으로 전달된 값을 마지막 위치에 채우기
	static void pushFood(String food) {
		String[] temp = new String[foods.length + 1];

		for (int i = 0; i < foods.length; i++) {
			temp[i] = foods[i];
		}
		temp[temp.length - 1] = food;

		foods = temp;
		temp = null;
	}

	//2. 배열 내부 데이터 단순 출력 함수
	static void printFood() {
		System.out.println(Arrays.toString(foods));
	}

	//3. 배열 내의 특정 음식의 위치를 찾아주는 함수 (indexOf -> int)
	// 매개값을 전달하면 해당 매개값이 배열 내의 몇 번 인덱스인지를 리턴하는 함수
	// 존재하지 않는 값이라면 -1을 리턴.
	static int indexOfFood(String food) {
		int i = 0;
		for (/*i=0*/; i < foods.length; i++) {
			if (foods[i].equals(food)) {
				break;
			}
		}

		if (i != foods.length) {
			return i;
		}
		else {
			return -1;
		}

	}


	//4. 특정 음식의 배열 포함 여부 (include -> boolean)
	//매개값으로 전달된 음식이 배열에 포함되어있는지의 여부를 판단.
	//힌트 -> indexOf 메서드를 활용하면 쉽게 끝남.
	static boolean includeFood(String food) {
		return indexOfFood(food) != -1;/* ? true : false; */ 
	}


	//5. 특정 음식 제거 함수 (remove -> void)
	//전달된 음식을 배열에서 삭제하고 배열의 길이를 줄이면 된다.
	static void removeFood(String food) {
		int idx = indexOfFood(food);

		if (idx == -1) {
			System.out.println("삭제 실패! " + food + "는 존재하지 않습니다");
		}
		else {
			String[] temp = new String[foods.length - 1];

			// foods 배열에서 찾은 음식 다음에 있는 음식들 앞으로 당기기
			for (int i = idx; i < foods.length - 1; i++) {
				foods[i] = foods[i + 1];
			}

			// temp배열에 옮기기
			for (int i = 0; i < temp.length; i++) {
				temp[i] = foods[i];
			}

			// temp와 foods 배열 주소 바꾸기
			foods = temp;
			temp = null;
		}

	}


	//6. 특정 음식 수정 메서드 (modify -> void)
	//매개값으로 전달한 인덱스의 값을 전달한 값으로 수정해 주는 메서드
	static void modifyFood(int index, String modifyFood) {
		if (index < 0 || index > foods.length - 1) {
			System.out.println("수정실패! 올바른 인덱스 값을 입력하세요");
		}
		else {
			foods[index] = modifyFood;
		}
	}
	public static void main(String[] args) {
		//배열 내부를 한번 출력 후, '라면', '김치찌개' 추가한 뒤 배열 출력하기
		printFood();
		pushFood("라면");
		pushFood("김치찌개");
		printFood();

		//파스타의 인덱스 알아내기
		System.out.println("파스타의 인덱스: " + indexOfFood("파스타"));

		//김치찌개의 인덱스 알아내기
		System.out.println("김치찌개의 인덱스: " + indexOfFood("김치찌개"));

		//짜장면의 인덱스 알아내기(존재하지 않는 값)
		System.out.println("짜장면의 인덱스: " + indexOfFood("짜장면"));

		//김치찌개, 망고 지우기 (망고는 존재하지 않는 값)
		removeFood("김치찌개");
		removeFood("망고");
		printFood();

		//라면의 존재 여부 출력
		System.out.println("라면 존재 여부: " + (includeFood("라면") ? "O" : "X"));

		//양념치킨의 존재 여부 출력
		System.out.println("양념치킨 존재 여부: " + (includeFood("양념치킨") ? "O" : "X"));

		//2번 인덱스 데이터를 닭갈비로 수정
		modifyFood(2, "닭갈비");
		printFood();


	}

}
