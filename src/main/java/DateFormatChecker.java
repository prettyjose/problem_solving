import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DateFormatChecker {
    public static void main(String[] args) {

        final ArrayList<String> validDateStrings = new ArrayList<>();
        validDateStrings.add("2/29/2000");
        validDateStrings.add("2/28/2001");
        validDateStrings.add("1/1/1989");
        validDateStrings.add("02/1/2018");
        validDateStrings.add("1/02/2016");
        validDateStrings.add("02/09/2010");

        boolean result = true;
        for (String dateString :
                validDateStrings) {

            result = result && checkDate(dateString);
        }

        final ArrayList<String> invalidDateStrings = new ArrayList<>();
        invalidDateStrings.add("2/29/2001");
        invalidDateStrings.add("-1/1/2000");
        invalidDateStrings.add("11/31/2018");
        invalidDateStrings.add("11/30/20o8");
        invalidDateStrings.add("1/1/200");
        for (String dateString :
                invalidDateStrings) {

            result = result && !checkDate(dateString);
        }

        System.out.println(result? "Success" : "Failure");

//        final TemporalAccessor temporalAccessor = formatter.parse(dateString, new ParsePosition(0));
//        System.out.println(temporalAccessor.query(TemporalQueries.localDate()));
//        System.out.println(temporalAccessor.query(TemporalQueries.precision()));

    }

    private static boolean checkDate(String dateString) {
        try{
            final String pattern = "M/d/yyyy";
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            final LocalDate parsedDate = LocalDate.parse(dateString, formatter);

            String[] separatorArray = dateString.split("/");
            return parsedDate.getDayOfMonth() == Integer.parseInt(separatorArray[1]);

        }catch(DateTimeException dte){
            return false;
        }
    }
}
