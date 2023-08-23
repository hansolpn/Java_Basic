package basic.loop;

public class WhileExample2 {

	public static void main(String[] args) {
		// 48 ~ 150사이의 정수 중 8의 배수만 가로로 출력해 보세요
		// (48부터 숫자를 하나씩 돌려가면서 8의 배수 판별을 반복하면 되겠죠?)
		
		int i = 48; // begin
		
		while (i <= 150) { // end
			if (i % 8 == 0) {
				System.out.print(i + " ");
			}
			
			i++; // step
		}
		
		System.out.println();
		
		// 1 ~ 100까지의 정수 중 4의 배수이면서
		// 8의 배수는 아닌 수를 가로로 출력해 보세요.
		
		int j = 1; // begin
		
		while (j <= 100) { // end
			if (j % 4 == 0 && j % 8 != 0) {
				System.out.print(j + " ");
			}
			
			j++; // step
		}
		
		System.out.println();
		
		// 1 ~ 30000까지의 정수 중 258의 배수의 개수를 출력
		int k = 1; // begin
		int count = 0; // 배수의 개수를 세 줄 변수
		
		while (k <= 30000) { // end
			if (k % 258 == 0) {
				count++;
			}
			
			k++; //step
		}
		System.out.println("258의 배수의 개수: " + count);
		
		// 1000의 약수의 개수를 구하세요
		int l = 1; // begin
		int count2 = 0;
		
		while (l <= 1000) { // end
			if (1000 % l == 0) {
				count2++;
			}
			
			l++; // step
		}
		System.out.println("1000의 약수의 개수: " + count2);

	}

}
