package DBScan;


import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;



public class DBScanImpl {

	public void onStartClick(Grid gd, int[] arr) throws InterruptedException {
		
		int distance = arr[0];
		int firstIndex = arr[1];
		ArrayList<Integer[]> nodes = gd.getSelectedDots();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(firstIndex);
		
		while(!st.isEmpty()) {
			
			int index = st.pop();
			gd.changeColor(nodes.get(index)[0], nodes.get(index)[1]);
			//Thread.sleep(1000);
			TimeUnit.SECONDS.sleep(1);
			for(int i = 0; i < nodes.size(); i++) {
				if(i != index && 
						visited.indexOf(i) == -1 && 
						distanceBwTwoPoints(nodes.get(index)[0], nodes.get(index)[1], nodes.get(i)[0], nodes.get(i)[1]) <= distance) {
					st.push(i);
					visited.add(i);
				}
			}
			
		}
		
		
		
		
	}
	
	public float distanceBwTwoPoints(int x1, int y1, int x2, int y2) {
		
		float ans = 0;
		
		ans = (float) Math.sqrt(Math.pow((x1 - x2), 2)+ Math.pow((y1 - y2), 2) );
		
		return ans;
	}
	
	
}
