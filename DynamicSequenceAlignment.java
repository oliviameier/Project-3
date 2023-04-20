public class DynamicSequenceAlignment {

    static char[] x = {'A', 'A', 'C', 'A', 'G', 'T', 'T', 'A', 'C', 'C'};
	static char[] y = {'T', 'A', 'A', 'G', 'G', 'T', 'C', 'A'};
	static int m = x.length;
	static int n = y.length;
	static int opt = 0;
	static int penalty = 0;
    static int[][] dynamic = new int[n+1][m+1];


    public static void main(String args[]){
        long start = System.nanoTime();
        fillArray(n,m);
        long end = System.nanoTime();
        long time = end - start; 
        System.out.println(dynamic[0][0]);
    }



    public static void fillArray(int i, int j){
        if(i == 0 && j == 0){
            dynamic[0][0] = optcost(0, 0);
        }
        else{
        dynamic[i][j] = opt(i,j);
        dynamic[i-1][j] = opt(i-1, j);
        dynamic[i][j] = opt(i, (j-1));
        
        fillArray(i-1, j-1);
        }
    }
    
    public static int optcost(int i, int j){
       if(i == m){
        opt =2*(n-j);
       }
       else if(j == n){
        opt = 2*(m-i);
       }
       else{
        if(x[i] == y[j]){
            penalty = 0;
        }
        else{
            penalty = 1;
        }
        opt = Math.min((optcost(i+1, j+1) + penalty), (optcost(i+1,j)+2) , (optcost(i,j+1)+2));
       }
        


    }
}
