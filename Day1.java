import java.io.*;

class Day1 {
	public static void main (String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputday1.txt"));
		String s = br.readLine();
		int floor = 0;
		boolean wasInBasement = false;
		int enteredBasement = 0;
		for(int i = 0; i<s.length(); i++) {
			floor += (s.charAt(i) == '(') ? 1 : -1;
			if(!wasInBasement && floor == -1) {
				enteredBasement = i+1;
				wasInBasement = true;
			}
		}
		System.out.println("Santa is at floor " +  floor);
		System.out.println("Santa entered basement at floor " +  enteredBasement);
	}
}