package randomDateGenerator.Tester;

import java.time.LocalDate;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class RandomDateGenerator {
	
	
	public LocalDate randomDate() {
		
		Random r = new Random();
		int day = r.nextInt(1, 31);
		int month = r.nextInt(1, 12);
		int year = (r.nextInt(1,2)*1000+r.nextInt(7,9)*100+r.nextInt(0, 9)*10+r.nextInt(1,10));
		System.out.println("Day is  " + day + " Month is " + month  + " Year is " + year);
		LocalDate date1 = LocalDate.of(1, 1, 1);
		try {
		date1 = LocalDate.of(year, month, day);
		} catch(Exception e) {
			randomDate();
		}
		System.out.println(date1);
		return date1;
	}
	
	public static void main(String args[]) {
		
		
	}

}