package etc.api.io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BufferedQuiz {

	public static void main(String[] args) {
		/*
        1. LocalDate클래스를 이용해서 MyWork폴더 내에 하위 경로로
         오늘 날짜 20230908file 이라는 이름으로 폴더를 생성하세요.
        2. 스캐너로 파일명을 입력받고 파일명.txt로 파일을 쓸 겁니다.
        3. '그만' 이라고 입력할 때까지 엔터를 포함해서 실시간으로
         파일을 작성합니다. 각 문장은 줄 개행을 포함합니다.
         (변수를 하나 선언해서 사용자의 입력값을 계속 누적시켜서 
          연결해 주시면 됩니다.)
        4. '그만'으로 파일이 작성되었다면, 아무 방법으로나 
         파일을 읽어서 콘솔에 출력해 보세요.
		 */

		// 1.
		LocalDate now = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		String workSpace = String.format("c:/MyWork/%sfile", now.format(dtf));

		File f = new File(workSpace);
		if (!f.exists()) {
			f.mkdir();
		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		String name = null;
		Scanner sc = new Scanner(System.in);

		try {
			// 2.
			System.out.print("파일명을 입력하세요: ");
			name = sc.next();
			sc.nextLine();

			fw = new FileWriter(String.format("%s/%s.txt", workSpace, name));
			bw = new BufferedWriter(fw);

			// 3.
			System.out.println("입력하고 싶은 내용을 입력하세요");
			System.out.println("그만 입력하고 싶으면 '그만'이라고 입력하세요");
			while (true) {
				System.out.print("> ");
				String input = sc.nextLine();

				if (input.equals("그만")) {
					break;
				}

				bw.write(input + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("입력을 종료합니다.");

		System.out.println("*** 출력 ***");

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(String.format("%s/%s.txt", workSpace, name));
			br = new BufferedReader(fr);

			String out = null;
			while ((out = br.readLine()) != null) {
				System.out.println(out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		sc.close();

	}

}
