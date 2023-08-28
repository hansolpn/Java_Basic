package basic.array;

//import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사원의 정보: 사번, 이름, 나이, 부서명
		String[] userNums = new String[100];
		String[] names = new String[100];
		int[] ages = new int[100];
		String[] departments = new String[100];

		//실제로 입력한 데이터(사원의 정보)의 개수를 체크하는 변수
		int count = 0;

		outer: while (true) {
			System.out.println("\n========== 사원 관리 프로그램 ==========");
			System.out.println("# 1. 사원 정보 신규 등록");
			System.out.println("# 2. 모든 사원 정보 보기");
			System.out.println("# 3. 사원 정보 검색");
			System.out.println("# 4. 사원 정보 수정");
			System.out.println("# 5. 사원 정보 삭제");
			System.out.println("# 6. 프로그램 종료");            
			System.out.println("====================================");

			System.out.print("> ");
			int menu = sc.nextInt();

			int i = 0;
			switch (menu) {
			case 1:
				//사원 정보 4가지를 입력받아 각 배열에 저장하는 코드를 작성.
				//사번은 중복되면 안됩니다.
				//(무한루프를 구현해서 사번 중복이 발생하면 다시 입력받기.)
				if (count >= userNums.length) {
					System.out.println("추가할 수 있는 최대 한도에 도달했습니다!");
					System.out.print("계속하시려면 엔터를 입력하세요.");
					sc.nextLine();
					sc.nextLine();
					continue outer;
				}

				String userNum;
				while (true) {
					System.out.println("사원 번호를 입력해 주세요");
					System.out.print("> ");
					userNum = sc.next();

					boolean flag = false;
					for (i = 0; i < count; i++) {
						if (userNums[i] == null) {
							break;
						}
						if (userNums[i].equals(userNum)) {
							flag = true;
							break;
						}
					}

					if (flag) {
						System.out.println("사원번호가 이미 존재합니다. 다시 입력해주세요!");
					}
					else {
						break;
					}
				}

				userNums[count] = userNum;

				System.out.println("사원 이름을 입력해 주세요");
				System.out.print("> ");
				names[count] = sc.next();

				System.out.println("사원 나이를 입력해 주세요");
				System.out.print("> ");
				ages[count] = sc.nextInt();

				System.out.println("사원 부서명을 입력해 주세요");
				System.out.print("> ");
				departments[count] = sc.next();

				System.out.println("--- 입력된 정보 ---");
				System.out.println("사번: " + userNums[count]);
				System.out.println("이름: " + names[count]);
				System.out.println("나이: " + ages[count]);
				System.out.println("부서명: " + departments[count]);

				count++;
				System.out.print("계속하시려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 2:
				//각 배열을 반복문을 통해 저장된 데이터까지만 출력하도록 작성. (count)
				//만약 사용자가 사원 등록을 한 명도 하지 않았다면
				//"등록된 사원 정보가 없습니다." 를 출력하시면 됩니다.
				if (count == 0) {
					System.out.println("등록된 사원 정보가 없습니다.");
				}
				else {
					System.out.println("--- 사원 정보 ---");
					for (i = 0; i < count; i++) {
						System.out.println("사번:	" + userNums[i]);
						System.out.println("이름:	" + names[i]);
						System.out.println("나이:	" + ages[i]);
						System.out.println("부서명:	" + departments[i]);
						System.out.println("--------------");
					}
				}
				System.out.print("계속하시려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 3:
				//입력한 사번에 일치하는 사원의 4가지 정보를 모두 출력하세요.
				//입력한 사번이 존재하지 않는다면 "조회하신 사원의 정보가 없습니다." 를 출력.
				System.out.println("사원 번호를 입력해 주세요");
				System.out.print("> ");
				userNum = sc.next();

				for (i = 0; i < count; i++) {
					if (userNums[i] == null) {
						break;
					}
					if (userNums[i].equals(userNum)) {
						break;
					}
				}

				if (i < count) {
					System.out.println("--- 입력한 사원 번호의 사원 정보 ---");
					System.out.println("사번: " + userNums[i]);
					System.out.println("이름: " + names[i]);
					System.out.println("나이: " + ages[i]);
					System.out.println("부서명: " + departments[i]);
				}
				else {
					System.out.println("조회하신 사원의 정보가 없습니다.");
				}

				System.out.print("계속하시려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 4:
				//해당 사번과 일치하는 사원의 나이와 부서를 선택적으로 변경할 수 있도록
				//프로그램을 구성하시고, 나이와 부서를 수정하는 코드를 작성하세요.
				//사번 입력 -> 존재하는 사번이 맞다면 -> [1. 나이변경 | 2. 부서변경 | 3.취소]
				//사번이 존재하지 않는다면 없다고 얘기해 주세요.
				System.out.println("수정할 사원의 사번을 입력해 주세요");
				System.out.print("> ");
				userNum = sc.next();

				for (i = 0; i < count; i++) {
					if (userNums[i] == null) {
						break;
					}
					if (userNums[i].equals(userNum)) {
						break;
					}
				}

				if (i < count) {
					System.out.println("수정할 사원의 이름 : " + names[i]);
					System.out.println("해당되는 메뉴의 번호를 입력해 주세요");
					System.out.println("[1. 나이변경 | 2. 부서변경 | 3.취소]");
					System.out.print("> ");
					int subnum = sc.nextInt();

					switch (subnum) {
					case 1:
						System.out.println("나이를 입력해주세요");
						System.out.print("> ");
						ages[i] = sc.nextInt();
						break;
					case 2:
						System.out.println("부서명를 입력해주세요");
						System.out.print("> ");
						departments[i] = sc.next();
						break;
					case 3:
					default:
						System.out.println("사원 수정을 취소합니다.");
						System.out.print("계속하시려면 엔터를 입력하세요.");
						sc.nextLine();
						sc.nextLine();
						continue outer;
					}

					System.out.println("--- 수정된 사원 정보 ---");
					System.out.println("사번: " + userNums[i]);
					System.out.println("이름: " + names[i]);
					System.out.println("나이: " + ages[i]);
					System.out.println("부서명: " + departments[i]);
				}
				else {
					System.out.println("조회하신 사원의 정보가 없습니다.");
				}

				System.out.print("계속하시려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 5:
				//사번을 입력받아서
				//해당 사번과 일치하는 사원의 4가지 정보를 각 배열에서 모두 삭제하고
				//삭제하기 전에 "정말 삭제하시겠습니까? [Y/N]" 를 입력받아서
				//y를 눌렀을 시에 삭제가 되도록 코드를 구성하세요.
				//배열의 크기는 줄이지 않겠습니다. 삭제할 인덱스를 기준으로 뒤에 있는 값들을
				//앞으로 한칸씩 땡기신 다음 count를 하나 내려주시면 됩니다.
				System.out.println("사원 번호를 입력해 주세요");
				System.out.print("> ");
				userNum = sc.next();

				for (i = 0; i < count; i++) {
					if (userNums[i] == null) {
						break;
					}
					if (userNums[i].equals(userNum)) {
						break;
					}
				}

				if (i < count) {
					System.out.printf("사번: %s, 사원 이름: %s\n", userNums[i], names[i]);
					System.out.println("정말 삭제하시겠습니까? [Y/N]");
					System.out.print("> ");
					String submenu = sc.next();
					switch (submenu) {
					case "y":
					case "Y":
						//삭제할 인덱스 기준으로 뒤에 있는 값들을 앞으로 한칸씩 땡기기
						for (int j = i; j < count - 1; j++) {
							userNums[j] = userNums[j + 1];
							names[j] = names[j + 1];
							ages[j] = ages[j + 1];
							departments[j] = departments[j + 1];
						}

						// 카운트 줄이기
						count--;

						// 맨 뒤의 정보 삭제
						userNums[count] = null;
						names[count] = null;
						ages[count] = 0;
						departments[count] = null;

						System.out.println("사원이 삭제되었습니다.");
						//System.out.println(count);
						//System.out.println(Arrays.toString(userNums));
						break;
					default:
						System.out.println("사원 삭제를 취소합니다.");
					}
				}
				else {
					System.out.println("조회하신 사원의 정보가 없습니다.");
				}

				System.out.print("계속하시려면 엔터를 입력하세요.");
				sc.nextLine();
				sc.nextLine();

				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				sc.close();
				break outer; // while true break
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}
	}

}
