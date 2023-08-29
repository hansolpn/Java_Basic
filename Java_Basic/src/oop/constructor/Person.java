package oop.constructor;

public class Person {
	String name;
	int age;
	int height;

	Person() {
		name = "";
		age = 0;
		height = 0;		
	}

	Person(String pName, int pAge, int pHeight) {
		name = pName;
		age = pAge;
		height = pHeight;
	}

	void info() {
		System.err.println("*** 사람 정보 ***");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
	}
}
