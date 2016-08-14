/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
   단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.io.FileInputStream;
import java.util.HashSet;
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
			
			int[][] map;
			HashSet<String> ht = new HashSet<String>();
			Laser laser;
			boolean laserIn;
			int mazeSize;
			
			int n = sc.nextInt();
			//init 
			map = new int[n][n];
			laser = new Laser();
			mazeSize = n;
			
			for (int i = 0; i < n ; i++) {
				String input = sc.next();
				for (int j = 0; j < n; j++){
					map[j][i] = Integer.parseInt(input.charAt(j)+"");
				}
			}
			
			int result = 0;
			laserIn = true;
			while (laserIn){
				//NEXT();
				int x = laser.atX - laser.fromX; // 1 = moving east, -1 = west
				int y = laser.atY - laser.fromY; // 1 = south, -1 = north
				//System.out.println("Currently at maze[" + laser.atX + "][" + laser.atY + "] moving " + "FROM maze[" + laser.fromX + "][" + laser.fromY + "]");
				laser.fromX = laser.atX;
				laser.fromY = laser.atY;
				
				switch (map[laser.atX][laser.atY]){
					case 0:
						laser.atX = laser.atX + x;
						laser.atY = laser.atY + y;
						break;
					case 1:
						ht.add(laser.atX + "," + laser.atY +"");
						laser.atX = laser.atX - y;
						laser.atY = laser.atY - x;
						break;
					case 2:
						ht.add(laser.atX + "," + laser.atY +"");
						laser.atX = laser.atX + y;
						laser.atY = laser.atY + x;
						break;
					default:
						laser.atX = laser.atX + x;
						laser.atY = laser.atY + y;
						//laserIn = false;
						//System.out.println("got switch INPUT = " + map[laser.atX][laser.atY]);
				}
				//CHECKLASERIN();
				if (laser.atX < 0 || laser.atX > mazeSize - 1 || laser.atY < 0 || laser.atY > mazeSize - 1){
					laserIn = false;
				}
			}
			
			result = ht.size();

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
			
		}
	}	
}

class Laser {
	public int fromX;
	public int fromY;
	public int atX;
	public int atY;
	
	void init() {
		fromX = -1;
		fromY = 0;
		atX = 0;
		atY = 0;
	}
	
	public Laser(){
		init();
	}
}