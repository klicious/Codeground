/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
   ��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.util.Scanner;
import java.io.FileInputStream;

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
		final int VALUE = 1000000007;
		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.

			int n = sc.nextInt();
			int m = sc.nextInt();
			n = 500000;
			m = 500000;
			long result = 0;
			for(int i = 0; i <= n; i++){
				for(int j = 0; j <= m; j++){
					//result += binomialCoefficient(i+j,i);
				}
			}
			for(int i = 0; i < 40; i++){
				System.out.println("FACTORIAL i = " + i + " RESULT :: " + factorial(i));
			}
			result = result % VALUE;

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(result);
			
		}
	}
	
	private static long factorial(int n){
		long x, fact = 1;
		  for ( x = n; x > 1; x--)
		     fact *= x;
		     
		  return fact;
	}
	
	private static int fact(int n, int k){
		if (n == 0) return k;
		else return fact(n - 1, n * k);
	}
	
	private static long binomialCoefficient(int n, int k) {
		
		if(k < 0 || k > n){
			return 0;
		}
		long a = factorial(n);
		long b = factorial(k) * factorial(n - k);
		if(b == 0){
			System.out.println("(a,b) = " + a + "," + b + " :: n,k = " + n + "," + k);
		}
		return a/b;
	}
}