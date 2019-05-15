package main.java;

import main.java.transverse.UtilClass;

public class DFD {
	
	public  void runExercise( String[] argv ) throws Exception {
        int[][] timestable = this.getTimesTable();
        System.out.println(timestable[2][2]);
    }

    public int[][] getTimesTable() throws Exception {
    
    int[][] timestable1 =  new int[12][12];
    for(int i = 0; i<12 ; i++)
    for(int j =0; j<12;j++)
    {
    timestable1[i][j]=(i+1)*(j+1);
    }
    
    return timestable1;
    }
    
    public static void main(String[] args) throws Exception {

		DFD dfd = new DFD();
		String []str = null;
		dfd.runExercise(str);
	
	

}
}
