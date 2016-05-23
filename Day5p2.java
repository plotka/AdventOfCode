import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Day5p2 {
	public static void main (String[] args) throws FileNotFoundException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("inputday5.txt"));
        String line = br.readLine();
		int count = 0;

		while((line = br.readLine()) != null) {
			boolean hasRepeatedPair = false;
			boolean hasRepeatedBetween = false;
			int length = line.length();

			for(int i = 0; i < length - 1; i++) {
				String sub1 = line.substring(i, i + 2);
				for(int j = 0;j < length - 1; j++) {
					String sub2 = line.substring(j, j + 2);
					if((Math.abs(i-j) > 1) && sub1.equals(sub2)) hasRepeatedPair = true;
				}

				if((i < length - 2) && (line.charAt(i) == line.charAt(i + 2)))
					hasRepeatedBetween = true;
				
			}
			if(hasRepeatedBetween && hasRepeatedPair) count++;	
		}
		System.out.println("Part 2: " + count + " nice words"); // 69
	}
}