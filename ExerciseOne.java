
public class ExerciseOne {
	public static void main(String[] args) {
		 
		String results = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
		String [] a_r_r = new String[20];
	  
		int other;
		int wins = 0;
		
		String[] array_results = results.split(",");
		for (int i=0; i<array_results.length; i++){
		 a_r_r = array_results[i].split(" ");
	 }
		
	//checks no. of wins for Manchester United
		public int man (String[] array){
			array = a_r_r;
			for(int j=0; j<array.length; j++){
				if(array[j]== "United"){
					int man = Integer.parseInt(a_r_r[j+1]);
				}
			}
			return man;
		}
	// checks no. of wins for others
			 
			for(int m=0; m<a_r_r.length; m++){
				if(a_r_r[m] != "Manchester" || a_r_r[m] != "United" || a_r_r[m] != "1" || a_r_r[m] != "0" || a_r_r[m] != "2" || a_r_r[m] != "3" || a_r_r[m] != "4"){
					other = Integer.parseInt(a_r_r[m+1]);
				}
			}
			
			
			if (man > other){
				wins++;
			}
			
		
		
	}
}