package oop.constructor;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		/*
        Scanner를 이용해서 사용자에게
        이름, 나이, 키를 입력받아서 
        해당 정보를 저장하는 객체를 디자인 해 보세요.
        객체 내에는 해당 사람의 정보를 모두 출력 해 주는
        info() 메서드가 존재합니다.
		*/

		Scanner sc = new Scanner(System.in);

		Person p1 = new Person();
		System.out.print("이름: ");
		p1.name = sc.next();
		System.out.print("나이: ");
		p1.age = sc.nextInt();
		System.out.print("키: ");
		p1.height = sc.nextInt();

		System.out.println("------------");
		p1.info();
		
		//Person p2 = new Person(p1.name, p1.age, p1.height);
		//p2.info();
		
		sc.close();

	}

}
