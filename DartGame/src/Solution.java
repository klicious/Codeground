/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
   ��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			//Bull�� ������ A
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
        

			// �� �κп��� ������ ����Ͻʽÿ�.
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