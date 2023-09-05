package etc.api.lang.math;

public class MathQuiz {
	/*
    1 ~ 10이 전달되면 1이 반환되고,
    11 ~ 20이 전달되면 2가 반환되고,
    21 ~ 30이 전달되면 3이 반환되고.......
    이러한 로직을 수행하는 static 메서드 page를 선언해 보세요.
    */
	
	public static int page(int num) {
		return (int)Math.ceil(num * 0.1);
	}

	public static void main(String[] args) {

		System.out.println(page(5));
		System.out.println(page(19));
		System.out.println(page(20));
		System.out.println(page(21));
		System.out.println(page(30));
	}

}
