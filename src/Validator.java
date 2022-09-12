import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Pattern pattern;
    private Matcher matcher;

    public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATTERN = "^01\\d{9}$"
            + "|^\\+8801\\d{9}$"
            + "|^8801\\d{9}$"
            + "|^1\\d{9}$";

    public boolean isValidEmail(final String email){
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPhoneNumber(final String passedNumber){
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(passedNumber);
        return matcher.matches();
    }

}
