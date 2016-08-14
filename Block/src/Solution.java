import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	final int INF = 987654321;
	int max( int a, int b ) { return a>b ? a: b; }
	int min( int a, int b ) { return a<b ? a: b; }
	void solve() throws Exception{
		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
	
		int T = sc.nextInt();
		for(int tt = 1; tt <= T; tt++){
			System.out.println( "Case #" + tt );
			int N = sc.nextInt(); int[] b = new int[N];
			for(int i=0; i<N; i++) b[i] = sc.nextInt();
			System.out.println("---------------------------");
			System.out.println("Blocks Before reduction");
			System.out.println(Arrays.toString(b));
			System.out.println("---------------------------");
			int mt = 0; 
			for(int i=0; i<N; i++){
				mt++;
				b[i] = min( b[i], mt );
				mt   = min( b[i], mt );
			}
			System.out.println("---------------------------");
			System.out.println("Blocks After First Iteration");
			System.out.println(Arrays.toString(b));
			System.out.println("---------------------------");
			mt = 0;
			for(int i=N-1; i>=0; i--){
				mt++;
				b[i] = min( b[i], mt );
				mt   = min( b[i], mt );
			}
			System.out.println("---------------------------");
			System.out.println("Blocks After Second Iteration");
			System.out.println(Arrays.toString(b));
			System.out.println("---------------------------");
			int ans = 0;
			for(int i=0; i<N; i++) ans = max( ans, b[i] );
			System.out.println( ans );
		}
		
	}
	
	public static void main(String[] args){
		try {
			new Solution().solve();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}