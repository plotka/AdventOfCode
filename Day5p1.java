import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Day5p1 {
	public static void main (String[] args) throws FileNotFoundException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("inputday5.txt"));
        String line = br.readLine();
		int countNice = 0;
		
		while((line = br.readLine()) != null) {

			int countVowels = 3;
			boolean hasRepeated = false;
			boolean nice = true;

			for (int i=0; i < line.length(); i++) {
				char first = line.charAt(i);

				if(i < line.length() - 1){
					String sub = line.substring(i, i + 2);
					char second = line.charAt(i + 1);

					if (!( sub.equals("ab") || sub.equals("cd") || sub.equals("pq") || sub.equals("xy"))) {
						if(!hasRepeated && first == second) hasRepeated = true;
					}
					else nice = false;
				}

				if ((countVowels > 0) && (first=='a' || first=='e' || first == 'i' || first == 'o' || first == 'u')){
					countVowels--;
				}
			}

			if (countVowels==0 && hasRepeated && nice) countNice++;
		}
		System.out.println("Part 1: " + countNice + " nice words"); // 238
	}
}