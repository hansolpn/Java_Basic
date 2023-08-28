package basic.array;

import java.util.Arrays;
import java.util.Scanner;

public class RussianRoulette {
	public static void main(String[] args) {
		// 초기화
		String[] players = new String[6];
		boolean[] bullets = new boolean[6];
		int playerCount = 0;
		int playerPoint = 0;
		int bulletCount = 0;
		int bulletPoint = 0;
		Scanner sc = new Scanner(System.in);

		// 시작 부분
		System.out.println("러시안 룰렛을 시작합니다!");
		System.out.println("참가할 사람의 이름을 입력해주세요!");
		System.out.println("입력을 그만하시려면 '종료'를 입력해주세요");

		playerinput: for (playerCount = 0; playerCount < 6; playerCount++) {
			System.out.print("> ");
			String name = sc.next();

			if (name.equals("종료")) {
				System.out.println("입력을 종료합니다.");
				break;
			}

			// 이름 중복 확인
			for(String n : players) {
				if (n == null) {
					break;
				}

				if (name.equals(n)) {
					System.out.println("중복된 이름은 사용할 수 없습니다. 다시 입력해주세요");
					playerCount--;
					continue playerinput;
				}
			}

			players[playerCount] = name;
		}
		if (playerCount == 6) {
			System.out.println("참가자가 6명이 되었습니다.");
			System.out.println("입력을 종료합니다.");
		}

		System.out.println("리볼버에 넣을 총알의 수를 입력해주세요. (1~5)");
		while (true) {
			System.out.print("> ");
			int num = sc.nextInt();

			if (num > 5 || num < 1) {
				System.out.println("수를 잘못 입력했습니다. 1에서 5 사이의 수로 다시 입력해주세요");
				continue;
			}
			else {
				bulletCount = num;
				break;       
			}
		}

		// 리볼버에 총알 넣기
		for (int total = 0; total < bulletCount; total++) {
			int rn = (int)(Math.random() * 2);

			if (rn == 1) { // 총알을 넣음
				if (bullets[bulletPoint]) { // 여기에는 총알이 들어가 있음
					total--;
				}
				else {
					bullets[bulletPoint] = true;
				}
			}
			else { // 총알을 넣지 않음
				total--;
			}

			// 총알 넣을 위치 변경
			if (bulletPoint == bullets.length - 1) {
				bulletPoint = 0;
			}
			else {
				bulletPoint++;
			}
		}

		//System.out.println(Arrays.toString(bullets));
		//System.out.println(Arrays.toString(players));
		System.out.println("리볼버에 총알을 넣었습니다.");

		// 게임 플레이!
		System.out.println("-----------------");
		System.out.print("게임 참여자: ");
		for (String p : players) {
			if (p == null) break;

			System.out.print(p + " ");
		}
		System.out.println();
		System.out.println("게임을 시작합니다!");
		System.out.println("-----------------");
		sc.nextLine();

		for (bulletPoint = 0; bulletPoint < bullets.length; bulletPoint++) {
			System.out.println("리볼버를 든 참여자: " + players[playerPoint]);
			System.out.println("리볼버를 장전했습니다.");
			System.out.print("계속하시려면 엔터를 누르세요.");
			sc.nextLine();

			System.out.println("-----------------");
			// 생사 확인
			if (bullets[bulletPoint]) {
				// 총알이 있음
				System.out.println("총이 발사되었습니다!");
				System.out.println("죽은 참여자: " + players[playerPoint]);

				// 죽은 참여자 제거
				for (int i = playerPoint; i < playerCount - 1; i++) {
					players[i] = players[i + 1];
				}
				playerCount--;
				players[playerCount] = null;

				playerPoint--; // 다음 참여자 위치 유지
				bulletCount--;
			}
			else {
				// 총알이 없음
				System.out.println("......");
				System.out.println("살아남은 참여자: " + players[playerPoint]);
			}
			System.out.print("계속하시려면 엔터를 누르세요.");
			sc.nextLine();

			// 든 참여자 위치 변경
			if (playerPoint == playerCount - 1) {
				playerPoint = 0;
			}
			else {
				playerPoint++;
			}

			System.out.println("-----------------");
			if (playerCount > 1 && bulletCount > 0) {
				System.out.println("남은 게임 참여자 수: " + playerCount);
				System.out.println("남은 총알 수: " + bulletCount);
				System.out.print("현재 남은 게임 참여자: ");

				for (String p : players) {
					if (p == null) break;

					System.out.print(p + " ");
				}
				System.out.println();
				System.out.println("-----------------");
			}
			else {
				break;
			}
		}

		// 결과
		System.out.println("게임이 종료되었습니다!");
		System.out.print("살아 남은 참여자: ");
		for (String p : players) {
			if (p == null) break;

			System.out.print(p + " ");
		}

		sc.close();
	}
}
