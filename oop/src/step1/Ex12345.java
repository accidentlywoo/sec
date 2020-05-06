package step1;

/**
 * TODO영역 외는 수정하지 않습니다.
 * TODO영역만  완성하세요
 * @author 오문정
 *
 */
public class Ex12345 {

	public static void main(String[] args) {
		System.out.println("1. 다음 numArr이 {8, 7, 5, 3, 2, 1}이 되도록   내림차순 버블정렬한다");
		int []numArr = new int[] {5, 3, 8, 1, 2, 7};
		//TODO 이곳을 완성하시오
		
		System.out.println("출력결과");
		System.out.println("예상결과: 8, 7, 5, 3, 2, 1,");
		System.out.println("실행결과:");
		for(int element:numArr) {
			System.out.print(element + ", ");
		}
		
		System.out.println("---------------------------------");
		System.out.println("2. 1~9까지의 숫자가 저장되도록 한다. [0][0]에는 1, [0][1]에는 2,....[2][1]에는 8, [2][2]에는 9 숫자가 차례로 저장되도록 한다.");
		
		int [][]numArr2 = new int[3][3];
		
		//TODO 이곳을 완성하시오
		
		System.out.println("출력 결과");
		System.out.println("예상결과");
		System.out.println("1 2 3");
		System.out.println("4 5 6");
		System.out.println("7 8 9");
		
		System.out.println("실행결과");
		for(int[]rowArr: numArr2) {
			for(int element: rowArr) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		System.out.println("3. 9~1까지의 숫자가 저장되도록 한다. [0][0]에는 9, [0][1]에는 8,....[2][1]에는 2, [2][2]에는 1 숫자가 차례로 저장되도록 한다.");
		int [][]numArr3 = new int[3][3];
		
		//TODO 이곳을 완성하시오
		
		System.out.println("출력 결과");
		System.out.println("예상결과");
		System.out.println("9 8 7");
		System.out.println("6 5 4");
		System.out.println("3 2 1");
		
		System.out.println("실행결과");
		for(int[]rowArr: numArr3) {
			for(int element: rowArr) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------");
		System.out.println("4. 1~9까지의 숫자가 저장되도록 한다. [0][0]에는 1, [1][0]에는 2,....[2][1]에는 8, [2][2]에는 9 숫자가 차례로 저장되도록 한다.");
		int [][]numArr4 = new int[3][3];
		
		//TODO 이곳을 완성하시오
		
		System.out.println("출력 결과");
		System.out.println("예상결과");
		System.out.println("1 4 7");
		System.out.println("2 5 8");
		System.out.println("3 6 9");
		
		System.out.println("실행결과");
		for(int[]rowArr: numArr4) {
			for(int element: rowArr) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		System.out.println("5. 다음 numArr5배열의 내용을 오른쪽으로 90도 회전시켜 numArr51에 저장한다");
		int [][]numArr5 = { {1,2,3}, {4,5,6}, {7,8,9} };
		int [][]numArr51 = new int[numArr5.length][numArr5[0].length];
		//TODO 이곳을 완성하시오
		
		System.out.println("출력 결과");
		System.out.println("예상결과");
		System.out.println("7 4 1");
		System.out.println("8 5 2");
		System.out.println("9 6 3");
		
		System.out.println("실행결과");
		for(int[]rowArr: numArr51) {
			for(int element: rowArr) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
			
	}	
}
