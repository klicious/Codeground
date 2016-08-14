/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
   ��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution �������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.io.FileInputStream;
import java.util.HashSet;
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
			// �� �κп��� �˰����� ���α׷��� �ۼ��Ͻʽÿ�.
			
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

			// �� �κп��� ������ ����Ͻʽÿ�.
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