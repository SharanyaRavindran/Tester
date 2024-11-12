package randomDateGenerator.Tester;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
    private RandomDateGenerator randomDateGenerator;

	public AppTest(String testName) {
		super(testName);
		randomDateGenerator = new RandomDateGenerator();

	}


//  // 1. Test that the generated date is within the specified range

	public void testDateWithinRange() {
		LocalDate startDate = LocalDate.of(1700, 1, 1);
		LocalDate endDate = LocalDate.of(2020, 12, 31);
		LocalDate randomDate = randomDateGenerator.randomDate();
		assertTrue("Date should be on or after the start date", randomDate.isAfter(startDate));
		assertTrue("Date should be on or before the end date", randomDate.isBefore(endDate));
	}


// // 2. Test to check randomness
	public void testRandomness() {
		LocalDate randomDate1 = randomDateGenerator.randomDate();
		LocalDate randomDate2 = randomDateGenerator.randomDate();
		assertTrue("Two consecutive random dates should not be same", !randomDate1.equals(randomDate2));
	}

//  
	// 3. Test the format of the date generated
	public void testFormat() {
		LocalDate randomDate = randomDateGenerator.randomDate();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date2 = LocalDate.parse(randomDate.toString(), formatter1);
		assertTrue("The format of the generated date should be YYYY-MM-DD", randomDate.equals(date2));
	}

	// 4. Test Leap year
	public void testLeapYear() {
		// LocalDate randomDate = LocalDate.of(2001, 2, 29);
		LocalDate randomDate = randomDateGenerator.randomDate();
		if (!randomDate.isLeapYear() && randomDate.getMonthValue() == 2) {
			assertTrue("Non leap year should not have dates greater than 28", randomDate.getDayOfMonth() < 29);

		}
	}

	// 5. Test 30 or 31 days in a month
	public void testDaysOfMonth() {
		LocalDate randomDate = randomDateGenerator.randomDate();
		//LocalDate randomDate = LocalDate.of(2001, 4, 31);
		if (randomDate.isLeapYear() && randomDate.getMonthValue() == 2) {
			assertTrue("leap year should not have dates greater than 29", randomDate.getDayOfMonth() <= 29);
		} else if (randomDate.getMonthValue() == 2) {
			assertTrue("Non leap year should not have dates greater than 28", randomDate.getDayOfMonth() < 29);
		} else if (randomDate.getMonthValue() == 1 || randomDate.getMonthValue() == 3 || randomDate.getMonthValue() == 5
				|| randomDate.getMonthValue() == 7 || randomDate.getMonthValue() == 8
				|| randomDate.getMonthValue() == 10 || randomDate.getMonthValue() == 12) {
			assertTrue("Check dates for months Jan, Mar, May, Jul, Aug, Oct, Dec", randomDate.getDayOfMonth() <= 31);
		} else {
			assertTrue("Check dates for months Apr, Jun, Sep, Nov", randomDate.getDayOfMonth() <= 30);

		}

	}
}
