package accountManagement;
import java.lang.*;
import java.awt.*;
import java.util.*;
import java.security.*;
public class Test {

	public static void main(String[] args) 
	{
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		//String formatted = String.format("%05d", num); 
		System.out.println(num);
		Random rand = new Random();
		int r = rand.nextInt(100000);
		System.out.println(r);
	}

}
