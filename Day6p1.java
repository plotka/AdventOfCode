import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class Day6p1 {
	public static Map<String, Integer> lights = new HashMap<String, Integer>();
	public static void main (String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputday6.txt"));
        String line = "";
        String startPos = "";
        String endPos = "";
        String[] parts;
        int count = 0;

		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				lights.put((i + "," + j), 0);
			}
		}

		while((line = br.readLine()) != null) {
			parts = line.split("\\s+");

			/*
			if(line.startsWith("turn on")) {
				startPos = parts[2];
			    endPos = parts[4];
			    turnOnLights(transform(startPos), transform(endPos));
			}
			else if(line.startsWith("turn off")) {
				startPos = parts[2];
			    endPos = parts[4];
			    turnOffLights(transform(startPos), transform(endPos));
			}
			else if(line.startsWith("toggle")) {
				startPos = parts[1];
			    endPos = parts[3];
			    toggleLights(transform(startPos), transform(endPos));
			}
			*/

			if(line.startsWith("toggle")) {
				startPos = parts[1];
			    endPos = parts[3];
			    toggleLights(transform(startPos), transform(endPos));
			}
			else {
				startPos = parts[2];
			    endPos = parts[4];
			    if(line.startsWith("turn on")) 
			    	turnOnLights(transform(startPos), transform(endPos));
			    else if(line.startsWith("turn off")) 
			    	turnOffLights(transform(startPos), transform(endPos));
			}
		}

		for (String key : lights.keySet() ) {
			if (lights.get(key) == 1) count++;
		}
		System.out.println("There are " + count + " lights lit"); // 377891

	}

	public static int[] transform(String s) {
		int[] arr = new int[2];
		arr[0] = Integer.parseInt((s.split(","))[0]);
		arr[1] = Integer.parseInt((s.split(","))[1]);
		return arr;
	}

	public static void turnOnLights(int[] start, int[] end) {
		for(int i = start[0]; i <= end[0]; i++) {
			for(int j = start[1]; j <= end[1]; j++) {
				lights.replace((i + "," + j), 1);
			}
		} 
	}

	public static void turnOffLights(int[] start, int[] end) {
		for(int i = start[0]; i <= end[0]; i++) {
			for(int j = start[1]; j <= end[1]; j++) {
				lights.replace((i + "," + j), 0);
			}
		} 
	}

	public static void toggleLights(int[] start, int[] end) {
		for(int i = start[0]; i <= end[0]; i++) {
			for(int j = start[1]; j <= end[1]; j++) {
				if (lights.get(i + "," + j) == 0) lights.replace((i + "," + j), 1);
				else lights.replace((i + "," + j), 0);
			}
		} 
	}
}
