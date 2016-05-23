import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

class Day4 {
	public static void main (String[] args) throws  NoSuchAlgorithmException {
	long index = 0;
	String input = "yzbqklnj";

		MessageDigest md = MessageDigest.getInstance("MD5");
		while(true){
			String key = String.format("%s%d", input, index++);

			byte[] digest = md.digest(key.getBytes());

			String digestString = DatatypeConverter.printHexBinary(digest);
			if(digestString.startsWith("00000")){ // just add one more zero for part 2
				System.out.println(index-1);
				break;
			}
		}
	}
}