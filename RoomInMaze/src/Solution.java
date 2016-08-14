import java.io.*;
import java.util.*;

public class Solution {
	MyScanner sc; PrintWriter out;
	void solve(){
		sc = new MyScanner(); out = new PrintWriter( new BufferedOutputStream(System.out) );
		int T = ni();
		for(int tt = 1; tt <= T; tt++){
			out.println( "Case #" + tt );
			int N = ni(), K = ni();
			String dir = sc.next();
			int x = 0, y = 0; long ans = 1;
			for( int i=0; i<dir.length(); i++ ){
				char d = dir.charAt(i);
				if( d == 'U' ) x--;
				if( d == 'D' ) x++;
				if( d == 'L' ) y--;
				if( d == 'R' ) y++;
				long r = x + y;
				// 0, 1, 2, ... N-1
				// 1, 2, 3, ... N 
				if( r < N ){
					long p = r * (r+1) / 2;
					if( r % 2 == 0 ) ans += p + y + 1;
					else ans += p + (r+1) - y;
				}else{
					// r:  N  , N+1, ... 2*N-2
					// rn: N-1, N-2, ... 1
					long p = N * 1L * (N+1) / 2 + ( r - N ) * ( N-1 + 2 * N - r ) / 2;
					long nn;
					if( r % 2 == 0 ) ans += p + ( N-x );
					else ans += p + ( 2*N - r ) - (N-x);
				}
			}
			out.println( ans );
		}
		out.close();
	}
	public static void main(String[] args){
		new Solution().solve();
	}
	class MyScanner{
		BufferedReader br; StringTokenizer st;
		public MyScanner(){
			br = new BufferedReader( new InputStreamReader(System.in) );
		}
		String next(){
			while( st == null || !st.hasMoreElements() ){
				try{
					st = new StringTokenizer( br.readLine() );
				}catch( IOException e ){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
	}
	int ni(){
		return Integer.parseInt( sc.next() );
	}
}