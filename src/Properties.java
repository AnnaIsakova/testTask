
//analog of properties file
//I decided not to create separate config.properties
//because I didn't want to overload the code with
//additional functionality (reading from file, setting props)
public class Properties {

    public static final String DATE_PATTERN = "d.M.yyyy";
    public static final char TIME_LINE_MARKER = 'C';
    public static final char QUERY_MARKER = 'D';
    public static final int SERVICE_INFO_INDEX = 1;
    public static final int QUESTION_INFO_INDEX = 2;
    public static final int RESPONSE_TYPE_INDEX = 3;
    public static final int DATE_INFO_INDEX = 4;
    public static final int MINUTES_INDEX = 5;
    public static final char RESPONSE_TYPE_PREVOUS = 'P';
    public static final char RESPONSE_TYPE_NEXT = 'N';
}
