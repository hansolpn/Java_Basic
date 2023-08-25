package basic.array;

import java.util.Arrays;

public class ArrayDelete {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13};

		//arr[3] = arr[4];
		//arr[4] = arr[5];
		//arr[5] = arr[6];
		// 삭제되는 값을 기준으로 뒤에 있는 값을 한 칸씩 앞으로 땡기는 작업.
		// 추후에 생성할 때 배열의 값을 그대로 대이하기 편하게 하기 위해 하는 작업.		
		for (int i = 3; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];			
		}

		// 기존의 배열보다 크기가 하나 작은 새 배열을 생성.
		int[] arrTemp = new int[arr.length - 1];

		// 원본 배열의 값을 새 배열에 인덱스에 맞취서 그대로 대입
		//arrTemp[0] = arr[0];
		//arrTemp[1] = arr[1];
		//arrTemp[2] = arr[2];

		for (int j = 0; j < arrTemp.length; j++) {
			arrTemp[j] = arr[j];
		}

		System.out.println(arr);
		System.out.println(arrTemp);

		arr = arrTemp; // arrTemp 베열의 주소값을 arr에 넘긴다.
		arrTemp = null; // 주소값을 지워서 메모리에서 arrTemp는 자동 소멸하게 됩니다.

		System.out.println(Arrays.toString(arr));
		
		

	}

}
