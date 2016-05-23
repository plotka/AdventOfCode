import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class Day6p2 {
	public static Map<String, Integer> lights = new HashMap<String, Integer>();
	public static int brightness = 0;
	public static void main (String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputday6.txt"));
        String line = "";
        String startPos = "";
        String endPos = "";
        String[] parts;
        int count = 0;
        

		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				lights.put((i + "," + j), brightness);
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
			count += lights.get(key);
		}
		System.out.println("The total brightness is " + count); // 14110788

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
				brightness = lights.get((i + "," + j));
				lights.replace((i + "," + j), (brightness + 1));
			}
		} 
	}

	public static void turnOffLights(int[] start, int[] end) {
		for(int i = start[0]; i <= end[0]; i++) {
			for(int j = start[1]; j <= end[1]; j++) {
				brightness = lights.get((i + "," + j));
				if((brightness - 1) > 0) lights.replace((i + "," + j), (brightness - 1));
				else lights.replace((i + "," + j), 0);
			}
		} 
	}

	public static void toggleLights(int[] start, int[] end) {
		for(int i = start[0]; i <= end[0]; i++) {
			for(int j = start[1]; j <= end[1]; j++) {
				brightness = lights.get((i + "," + j));
				lights.replace((i + "," + j), (brightness + 2));
			}
		} 
	}
}
