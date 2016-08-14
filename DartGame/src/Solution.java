/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
   단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			//Bull의 반지름 A
			int result = 0;
			int bull = sc.nextInt();
			int tripleStart = sc.nextInt();
			int tripleEnd = sc.nextInt();
			int doubleStart = sc.nextInt();
			int doubleEnd = sc.nextInt();
			
			int n = sc.nextInt();
			ArrayList<Dart> darts = new ArrayList<Dart>();
			for (int i = 0; i < n; i++){
				darts.add(new Dart(sc.nextInt(), sc.nextInt()));	
			}
        
			// Dart Board has 20 sections each section consists of 18 degrees.
			// Starting from +8 degrees scores would be, 
			// 1 18 4 13 6 10 15 2 17 3 19 7 16 8 11 14 9 12 5 20
			// 20 is special case where it contains angle from 360 - 8 < section < 8
			
			for (int i = 0; i < n; i++) {
				int x = darts.get(i).x;
				int y = darts.get(i).y;
				System.out.println("x = " + x + " y = " + y);
				double angle = 0;
				angle = getAngle(x,y);
				if(angle < 0){
					angle += 360;
				}
				double r = Math.sqrt(x*x + y*y);
				
				int rawScore = getRawScore(angle);
				int score = 0;
				if (r < bull){
					score = 50;
				}else if(r > tripleStart && r < tripleEnd){
					score = rawScore * 3;
				}else if(r > doubleStart && r < doubleEnd){
					score = rawScore * 2;
				}else if(r > doubleEnd){
					score = 0;
				}else {
					score = rawScore;
				}
				System.out.println("rawScore = " + rawScore + " score = " + score + " :: angle = " + angle + " r = " + r);
				//System.out.println("Section = " + (int) (angle + 8) / 18);
				result += score;
			}
        

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
			
		}
	}
	
	private static double getAngle(int x, int y)
	{
	    return Math.atan2(y,x) * (180 / Math.PI); //note the atan2 call, the order of paramers is y then x
	}
	
	private static int getRawScore(double angle){
		// Dart Board has 20 sections each section consists of 18 degrees.
		// Starting from +8 degrees scores would be, 
		// 13 4 18 1 20 5 12 9 14 11 8 16 7 19 3 17 2 15 10 6
		// 20 is special case where it contains angle from 360 - 8 < section < 8
		int section = (int) (angle + 9)/18;
		int result = 0;
		switch(section) {
		case 1:
			result = 13;
			break;
		case 2:
			result = 4;
			break;
		case 3:
			result = 18;
			break;
		case 4:
			result = 1;
			break;
		case 5:
			result = 20;
			break;
		case 6:
			result = 5;
			break;
		case 7:
			result = 12;
			break;
		case 8:
			result = 9;
			break;
		case 9:
			result = 14;
			break;
		case 10:
			result = 11;
			break;
		case 11:
			result = 8;
			break;
		case 12:
			result = 16;
			break;
		case 13:
			result = 7;
			break;
		case 14:
			result = 19;
			break;
		case 15:
			result = 3;
			break;
		case 16:
			result = 17;
			break;
		case 17:
			result = 2;
			break;
		case 18:
			result = 15;
			break;
		case 19:
			result = 10;
			break;
		default:
			result = 6;			
		}
		return result;
	}
	
}

class Dart {
	int x;
	int y;
	
	public Dart() {
		
	}
	
	public Dart(int a, int b) {
		x = a;
		y = b;
	}
	
}