package tsp;
//Backtracking Java implementation
//find minimum weight Hamiltonian cycle

public class TSPbk {
	
	
	static int tsp(int[][] graph, boolean v[],int current, int count, int n, int cost, int ans) {
		//
		if(count==n && graph[current][0]>0) {
			ans = Math.min(ans, cost+graph[current][0]);
			return ans;
		}
		
		//traverse graph  DFS manner 
		for(int i=0;i<n;i++) {
			
			if(v[i]==false && graph[current][i]>0) {
				
				//mark as visited
				v[i]=true;  
				ans=tsp(graph, v,i,count+1,n,cost+graph[current][i], ans);
				v[i]=false;
			}
		}
		
		return ans;
		
	}
	public static void main(String[] args) {
		int n=4;
		int[][] graph= {
				{0,10,15,20},
				{10,0,35,25},
				{15,35,0,30},
				{20,25,30,0}
		};
		boolean[] v=new boolean[n];
		v[0]=true;
		int ans=Integer.MAX_VALUE;
		
		
		ans=tsp(graph, v, 0, n, 1, 0, ans);
		System.out.println(ans);
	}

}
