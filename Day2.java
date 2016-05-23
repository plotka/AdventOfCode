import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Day2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int totalPaper=0;
        int paper = 0;
        int ribbon = 0;
        int totalRibbon = 0;
        BufferedReader br = new BufferedReader(new FileReader("inputday2.txt"));
        String line;
        while((line = br.readLine()) != null) {
             String[] values = line.split("x");

             // part 1
             int l = Integer.parseInt(values[0]);
             int w = Integer.parseInt(values[1]);
             int h = Integer.parseInt(values[2]);
             int extra = Math.min(l*w, l*h);
             extra = Math.min(w*h, extra);
             paper = 2*l*w + 2*w*h + 2*h*l + extra;
             totalPaper += paper;

             // part 2     
             int min1=l;
             int min2=w;
             if (l<=w && h<=w) {
                min1=l;
                min2=h; 
             }
             else if (w<=l && h<=l) {
                min1=w;
                min2=h; 
             }
             int wrap = min1*2 + min2*2;
             int bow = l*w*h;
             ribbon = wrap + bow;
             totalRibbon += ribbon;
        }
        System.out.println("The elves need a total of " + totalPaper + " square feet of wrapping paper");
        System.out.println("The elves need a total of " + totalRibbon + " feet of ribbon");
	}
}
