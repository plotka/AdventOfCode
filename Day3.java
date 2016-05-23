import java.io.*;
import java.util.Set;
import java.util.HashSet;

class Day3 {
	public static void main (String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputday3.txt"));
        String line = br.readLine();
        // part 1
		Set<String> path = new HashSet<String>();
		int x=0;
		int y=0;
		String pos = "(" + x + "," + y + ")";
		path.add(pos);
    	for(int i=0; i<line.length(); i++){
    		if (line.charAt(i) == 'v') y--;
    		else if (line.charAt(i) == '^') y++;
    		else if (line.charAt(i) == '>') x++;        		
    		else if (line.charAt(i) == '<') x--;
		 pos = "(" + x + "," + y + ")";
		 path.add(pos);
    	}
        System.out.println("Santa visited " + path.size() + " unique houses");

        // part 2
        Set<String> path2 = new HashSet<String>();
        int xs=0;
		int ys=0;
		int xr=0;
		int yr=0;
		pos = "(" + xs + "," + ys + ")";
		path2.add(pos);
		for(int i=0; i<line.length(); i++){
			// santa moves at even numbers
			if(i % 2 == 0){
				if (line.charAt(i) == 'v') ys--;
	    		else if (line.charAt(i) == '^') ys++;
	    		else if (line.charAt(i) == '>') xs++;        		
	    		else if (line.charAt(i) == '<') xs--;
	    		pos = "(" + xs + "," + ys + ")";
	    		

			}
			// robo moves
			else {
				if (line.charAt(i) == 'v') yr--;
	    		else if (line.charAt(i) == '^') yr++;
	    		else if (line.charAt(i) == '>') xr++;        		
	    		else if (line.charAt(i) == '<') xr--;
	    		pos = "(" + xr + "," + yr + ")";
	    		
			}
			path2.add(pos);
		}
		System.out.println("Santa and Robo visited " + path2.size() + " unique houses");
	}
}
