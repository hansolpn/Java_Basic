package etc.api.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListDelete {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<String> kakao = new ArrayList<String>();
		Collections.addAll(kakao, "무지", "네오", "어파치", "라이언", "제이지", "춘식이");
		System.out.println("현재 저장된 친구들: " + kakao);
		System.out.print("삭제할 친구를 입력하세요: ");
		String name = sc.next();
		
		/*
		 - 입력받은 이름을 리스트 내에서 삭제하세요.
		   삭제후 결과도 출력하세요.
		 - 없으면 없는 이름이라고 출력해 주세요.
		 */
		int idx = kakao.indexOf(name);
		if (idx == -1) {
			System.out.println("없는 친구입니다.");
		}
		else {
			kakao.remove(idx);
			System.out.println("친구가 삭제됬어요");
			System.out.println("현재 저장된 친구들: " + kakao);
		}
		
		sc.close();
	}

}
