package oop.encap.good;

public class MainClass {

	public static void main(String[] args) {

		MyBirth my = new MyBirth();
		//my.year = 1992;
		my.setYear(1992);
		my.setMonth(11);
		my.setDay(30);
		
//		System.out.printf("내 생일은 %d년 %d월 %d일 입니다\n",
//				my.getYear(), my.getMonth(), my.getDay());
		my.birthInfo();
	}

}
