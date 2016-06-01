import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);

		// get dates from user
		System.out.println("Input first date : example: (01/14/1999)");
		String myDate = scanner.nextLine();

		System.out.println("Input second date : example: (01/14/1999)");
		String myDate2 = scanner.nextLine();

		scanner.close();

		// create formatter
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

		// parse strings into dates
		Date date = format.parse(myDate);
		Date date2 = format.parse(myDate2);

		// subtract date2 from date 1 and convert to days dividing by
		// milliseconds
		long days = (date2.getTime() - date.getTime()) / 86400000;
		long years;

		// math to divide into years/months/days
		if (days >= 365) {
			years = days / 365;
			days = days - years * 365;
		} else {
			years = 0;
		}

		// wasn't sure how else to get months, doesn't compensate for months
		// with more or less than 30 days
		long months = days / 30;

		days = days - months * 30;

		// print results
		System.out.println(years + " year(s) " + months + " month(s) " + days
				+ " day(s) between your dates");

	}
}
