package oop.constructor;

public class PhoneMain {

	public static void main(String[] args) {
		
		Phone basic = new Phone();
//		basic.color = "회색";
//		basic.model = "폴더폰";
//		basic.price = 200000;
		
		basic.showSpect();
		System.out.println("----------");
		
		Phone galaxy = new Phone("갤럭시 s23");
		galaxy.showSpect();
		System.out.println("----------");
		
		Phone iPhone14 = new Phone("아이폰 14", "스페이스 그레이");
		iPhone14.showSpect();
	}

}
