package oop.modi.member.pac1;

public class B {

	public B() {
	
		A a = new A();
		
		a.x = 2;
		a.y = 2;
//		a.z = 2; (x) private
		
		a.method1();
		a.method2();
		//a.method3(); (x)
	}
}
